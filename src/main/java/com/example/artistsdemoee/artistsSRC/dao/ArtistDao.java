package com.example.artistsdemoee.artistsSRC.dao;

import com.example.artistsdemoee.artistsSRC.dbconnection.DBConnectionArtists;
import com.example.artistsdemoee.artistsSRC.entity.Artist;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArtistDao {

    public static final String FIND_BY_ID = "SELECT * FROM artists WHERE id=?";
    public static final String SAVE_ARTIST = "INSERT INTO artists (name,age) VALUES (?,?)";
    public static final String FIND_ALL = "SELECT * FROM artists ORDER BY id";
    private static ArtistDao INSTANCE;

    public ArtistDao() {
    }

    public static ArtistDao getInstance(){
        if (INSTANCE == null){
            synchronized (ArtistDao.class){
                if (INSTANCE == null){
                    INSTANCE = new ArtistDao();
                }
            }
        }
        return INSTANCE;
    }

    public Artist save (Artist artist) {
        try (Connection connection = DBConnectionArtists.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SAVE_ARTIST, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, artist.getName());
            statement.setInt(2,artist.getAge());
            statement.executeUpdate();

            ResultSet generatedKeys = statement.getGeneratedKeys();
            while (generatedKeys.next()){
                artist.setId(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return artist;
    }

        public Artist findById(int id){
        try(Connection connection = DBConnectionArtists.getConnection()){
            PreparedStatement statement = connection.prepareStatement(FIND_BY_ID);
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                return new Artist(resultSet.getInt("id"),resultSet.getString("name"),resultSet.getInt("age"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<Artist> findAll(){
        List<Artist> artists = new ArrayList<>();
        try(Connection connection = DBConnectionArtists.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(FIND_ALL);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                artists.add(new Artist(resultSet.getInt("id"),resultSet.getString("name"),resultSet.getInt("age")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return artists;
    }
}

