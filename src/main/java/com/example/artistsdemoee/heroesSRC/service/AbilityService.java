package com.example.artistsdemoee.heroesSRC.service;


import com.example.artistsdemoee.heroesSRC.dao.AbilityDao;
import com.example.artistsdemoee.heroesSRC.entity.Ability;

import java.util.List;

/**
 * @author i.sukach
 */
public final class AbilityService {

    private static AbilityService INSTANCE = null;

    private AbilityService() {}

    public static AbilityService getInstance() {
        if (INSTANCE == null) {
            synchronized (AbilityService.class) {
                if (INSTANCE == null) {
                    INSTANCE = new AbilityService();
                }
            }
        }
        return INSTANCE;
    }

    public List<Ability> getAllAbilities() {
        return AbilityDao.getInstance().findAll();
    }
}
