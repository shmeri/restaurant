package com.project.restaurant.DAO.Impl;

import com.fasterxml.jackson.databind.BeanProperty;
import com.project.restaurant.DAO.RestaurantDAO;
import com.project.restaurant.models.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class RestaurantDAOImpl implements RestaurantDAO
{
  JdbcTemplate jdbcTemplate;

  @Autowired
  public RestaurantDAOImpl(JdbcTemplate jdbcTemplate)
  {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public Restaurant findInfo()
  {
    String sql = "SELECT ID, NAME, ADDRESS, money FROM RESTAURANT";
    Restaurant restaurant = (Restaurant) jdbcTemplate.queryForObject(sql, new RestaurantRowMapper());
    return restaurant;
  }

  @Override
  public Double getAllCash()
  {
    return jdbcTemplate.queryForObject("SELECT SUM(m.price) AS \"Total\"\n" +
        "FROM  orders o, menu m\n" +
        "WHERE o.id_menu = m.id", Double.class);
  }


  public class RestaurantRowMapper implements RowMapper
  {
    @Override
    public Restaurant mapRow(ResultSet resultSet, int i) throws SQLException
    {
      Restaurant restaurant = new Restaurant();
      restaurant.setId(resultSet.getInt("ID"));
      restaurant.setName(resultSet.getString("NAME"));
      restaurant.setAddress(resultSet.getString("ADDRESS"));
      restaurant.setMoney(resultSet.getDouble("MONEY"));
      return restaurant;
    }
  }
}