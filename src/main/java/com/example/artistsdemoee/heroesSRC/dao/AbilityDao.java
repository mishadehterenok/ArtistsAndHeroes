package com.example.artistsdemoee.heroesSRC.dao;

import com.example.artistsdemoee.heroesSRC.dbconnection.DBConnectionHeroes;
import com.example.artistsdemoee.heroesSRC.entity.Ability;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * @author i.sukach
 */
public final class AbilityDao {

    private static final String TABLE_NAME = "abilities";
    private static AbilityDao INSTANCE = null;

    private AbilityDao() {}

    public static AbilityDao getInstance() {
        if (INSTANCE == null) {
            synchronized (AbilityDao.class) {
                if (INSTANCE == null) {
                    INSTANCE = new AbilityDao();
                }
            }
        }
        return INSTANCE;
    }

    public List<Ability> findAll() {
        List<Ability> abilities = new ArrayList<>();
        try (Connection connection = DBConnectionHeroes.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM " + TABLE_NAME)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()){
                    while (resultSet.next()) {
                        abilities.add(new Ability(resultSet.getLong(TABLE_NAME + ".id"),
                                resultSet.getString(TABLE_NAME + ".name")));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return abilities;
    }
}
