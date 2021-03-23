package com.project.restaurant.DAO.Impl;

import com.project.restaurant.DAO.MenuDAO;
import com.project.restaurant.models.Menu;
import com.project.restaurant.models.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class MenuDAOImpl implements MenuDAO
{

  private JdbcTemplate jdbcTemplate;

  @Autowired
  public MenuDAOImpl(JdbcTemplate jdbcTemplate)
  {
    this.jdbcTemplate = jdbcTemplate;
  }

  public List<Menu> getAll()
  {
    String sql = "SELECT ID, DISHES_NAME, PRICE,WEIGHT, QUANTITY FROM MENU";
    List<Menu> menuList = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Menu.class));
    return menuList;
  }

  @Override
  public void save(Menu menu)
  {
    SimpleJdbcInsert insertAction = new SimpleJdbcInsert(jdbcTemplate);
    insertAction.withTableName("MENU").usingColumns("ID", "DISHES_NAME", "PRICE", "WEIGHT", "QUANTITY");
    BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(menu);
    insertAction.execute(param);

  }

  @Override
  public void delete(Menu menu)
  {

  }

  public class MenuRowMapper implements RowMapper
  {
    @Override
    public Menu mapRow(ResultSet resultSet, int i) throws SQLException
    {
      Menu menu = new Menu();
      menu.setId(resultSet.getInt("ID"));
      menu.setDishesName(resultSet.getString("DISHES_NAME"));
      menu.setPrice(resultSet.getDouble("PRICE"));
      menu.setWeight(resultSet.getInt("WEIGHT"));
      menu.setQuantity(resultSet.getInt("QUANTITY"));
      return menu;
    }
  }
}
