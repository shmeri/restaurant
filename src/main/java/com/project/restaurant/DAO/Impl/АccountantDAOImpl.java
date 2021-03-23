package com.project.restaurant.DAO.Impl;

import com.project.restaurant.DAO.АccountantDAO;
import com.project.restaurant.models.ClientAvaSpend;
import com.project.restaurant.models.Menu;
import com.project.restaurant.models.Waiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class АccountantDAOImpl implements АccountantDAO
{
  JdbcTemplate jdbcTemplate;

  @Autowired
  public АccountantDAOImpl(JdbcTemplate jdbcTemplate)
  {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public Waiter secondLowestTip()
  {
    String sql = "SELECT NAME, TIP \n" +
        "    FROM WAITERS\n" +
        "    ORDER BY tip\n" +
        "OFFSET 1 ROWS \n" +
        "FETCH NEXT 1 ROWS ONLY";
    Waiter secondLow = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Waiter.class));
    return secondLow;
  }

  @Override
  public List<Waiter> allWaitersOrderByTip()
  {
    String sql = "SELECT * FROM waiters\n" +
        "ORDER BY tip DESC";
    List<Waiter> waiterList = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Waiter.class));
    return waiterList;
  }

  @Override
  public ClientAvaSpend clientAve()
  {
    String sql = "SELECT  c.type AS \"Type\", AVG(m.price) AS \"average\"\n" +
        "            FROM clients c, waiters w, menu m, orders o\n" +
        "            WHERE c.id = o.id_clients\n" +
        "            AND w.id = o.id_waiters\n" +
        "            AND m.id = o.id_menu\n" +
        "            \n" +
        "            GROUP BY c.type\n" +
        "            ORDER BY AVG(m.price)DESC\n" +
        "            FETCH NEXT 1 ROWS ONLY";
    ClientAvaSpend clientAvaSpend = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(ClientAvaSpend.class));
    return clientAvaSpend;
  }

  @Override
  public Menu secondBestSale()
  {
    String sql = "SELECT m.dishes_name AS \"dishesName\", SUM(m.price) AS \"Price\", COUNT(m.dishes_name) AS \"Quantity\"\n" +
        "        FROM clients c, waiters w, menu m, orders o\n" +
        "        WHERE c.id = o.id_clients\n" +
        "        AND w.id = o.id_waiters\n" +
        "        AND m.id = o.id_menu\n" +
        "        GROUP BY m.dishes_name\n" +
        "        ORDER BY COUNT(m.dishes_name)DESC,\n" +
        "        SUM(m.price) DESC\n" +
        "OFFSET 1 ROWS \n" +
        "FETCH NEXT 1 ROWS ONLY";
    Menu secondBestSale = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Menu.class));
    return secondBestSale;
  }

  @Override
  public Menu veganTotalWeightAndPrice()
  {
    String sql = "SELECT  c.type AS \"Type client\", SUM(m.weight) AS \"Total weight\", SUM(m.price) AS \"Total price\"\n" +
        "        FROM clients c, menu m, orders o\n" +
        "        WHERE c.id = o.id_clients\n" +
        "        AND m.id = o.id_menu\n" +
        "        AND c.type = 'vegan'\n" +
        "        GROUP BY c.type";
    Menu veganTotalWeightAndPrice = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Menu.class));
    return veganTotalWeightAndPrice;
  }

  @Override
  public List<Menu> veganDishesSale()
  {
    String sql = "SELECT  m.dishes_name AS \"Dishes\", m.price AS \"Price\", m.weight as \"Weight\"\n" +
        "        FROM  orders o, waiters w, clients c, menu m\n" +
        "        WHERE o.id_waiters = w.id\n" +
        "        AND o.id_clients = c.id\n" +
        "        AND o.id_menu = m.id\n" +
        "        AND c.type = 'vegan'\n" +
        "        ORDER BY o.id";
    List<Menu> veganDishesSale = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Menu.class));
    return veganDishesSale;
  }

  @Override
  public ClientAvaSpend studentMutraAve()
  {
    String sql = "SELECT  c.type AS \"Type client\", AVG(m.price) AS \"AVG price\"\n" +
        "        FROM clients c, menu m, orders o\n" +
        "        WHERE c.id = o.id_clients\n" +
        "        AND m.id = o.id_menu\n" +
        "        GROUP BY c.type\n" +
        "        FETCH NEXT 2 ROWS ONLY";
    ClientAvaSpend clientAvaSpend = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(ClientAvaSpend.class));
    return clientAvaSpend;
  }

  @Override
  public void fireWaiterWithSecondLowTip()
  {
    String sql = "UPDATE WAITERS\n" +
        "   SET (ACTIV) = 0\n" +
        "   WHERE ID = (SELECT ID\n" +
        "    FROM WAITERS\n" +
        "    ORDER BY tip\n" +
        "OFFSET 1 ROWS \n" +
        "FETCH NEXT 1 ROWS ONLY)";
    jdbcTemplate.update(sql);
  }
}
