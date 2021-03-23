package com.project.restaurant.DAO.Impl;

import com.project.restaurant.DAO.SalesDAO;
import com.project.restaurant.models.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SalesDAOImpl implements SalesDAO
{

  private JdbcTemplate jdbcTemplate;

  @Autowired
  public SalesDAOImpl(JdbcTemplate jdbcTemplate)
  {
    this.jdbcTemplate = jdbcTemplate;
  }

  public List<Sale> getAll()
  {
    String sql = " SELECT  o.id AS ID,  c.name AS \"Client name\",w.name as \"Waiters Name\", m.dishes_name AS \"Dishes\", m.price AS \"Price\", m.quantity AS \"Quantity\"\n" +
        "            FROM  orders o, waiters w, clients c, menu m\n" +
        "            WHERE o.id_waiters = w.id\n" +
        "            AND o.id_clients = c.id\n" +
        "            AND o.id_menu = m.id\n" +
        "            ORDER BY o.id";
    List<Sale> saleList = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Sale.class));
    return saleList;
  }

  public List<Sale> list2()
  {
    String sql = "SELECT \n" +
        "o.id AS Id, c.name as \"Client Name\", w.name as \"Waiters Name\", m.dishes_name AS \"Dishes\", m.price AS \"Price\", c.is_tipping AS \"Tip\", c.is_vegan AS \"ClientsIsVeg\",m.vegan AS \"Vegan\"\n" +
        "FROM clients c, waitress w, menu m, orders o\n" +
        "WHERE c.id = o.client_id\n" +
        "AND w.id = o.waitress_id\n" +
        "AND m.id = o.menu_id\n" +
        "ORDER BY m.dishes_name";
    List<Sale> saleList = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Sale.class));
    return saleList;
  }

  public void save(Sale sale)
  {

  }

  public Sale get(int id)
  {
    return null;
  }

  public void update(Sale sale)
  {

  }

  public void delete(int id)
  {

  }
}
