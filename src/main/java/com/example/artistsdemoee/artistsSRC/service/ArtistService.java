package com.example.artistsdemoee.artistsSRC.service;

import com.example.artistsdemoee.artistsSRC.dao.ArtistDao;
import com.example.artistsdemoee.artistsSRC.dto.ArtistDto;
import com.example.artistsdemoee.artistsSRC.entity.Artist;

import java.util.List;
import java.util.stream.Collectors;

public class ArtistService {
    private static ArtistService INSTANCE;

    public ArtistService() {
    }
    public static ArtistService getInstance(){
        if (INSTANCE == null){
            synchronized (ArtistDao.class){
                if (INSTANCE == null){
                    INSTANCE = new ArtistService();
                }
            }
        }
        return INSTANCE;
    }

    public ArtistDto save(Artist artist){
        Artist savedArtist = ArtistDao.getInstance().save(artist);
        return new ArtistDto(savedArtist.getId(),savedArtist.getName(),savedArtist.getAge());
    }
    public ArtistDto findById(int id){
        Artist artist = ArtistDao.getInstance().findById(id);
        if (artist == null){
            return null;
        }
        return new ArtistDto(artist.getId(),artist.getName(), artist.getAge());
    }

    public List<ArtistDto> findAll(){
        return ArtistDao.getInstance()
                .findAll()
                .stream()
                .map(artist -> new ArtistDto(artist.getId(), artist.getName(), artist.getAge()))
                .collect(Collectors.toList());
    }

}
