package com.project.restaurant.DAO.Impl;

import com.project.restaurant.DAO.WaitersDAO;
import com.project.restaurant.models.Menu;
import com.project.restaurant.models.Waiter;
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
public class WaitersDAOImpl implements WaitersDAO
{

  private JdbcTemplate jdbcTemplate;

  @Autowired
  public WaitersDAOImpl(JdbcTemplate jdbcTemplate)
  {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public Waiter get(int id)
  {
    String sql = "SELECT * FROM WAITERS WHERE ID = ?";
    Object[] args = {id};
    Waiter waiter = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(Waiter.class));
    return waiter;
  }

  public List<Waiter> getAll()
  {
    String sql = "SELECT * FROM waiters\n";
    List<Waiter> waiterList = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Waiter.class));
    return waiterList;
  }

  @Override
  public List<Waiter> getAllActive()
  {
    String sql = "SELECT * FROM waiters\n" +
        "WHERE activ = 1";
    List<Waiter> waiterList = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Waiter.class));
    return waiterList;
  }

  @Override
  public void save(Waiter waiter)
  {
    SimpleJdbcInsert insertAction = new SimpleJdbcInsert(jdbcTemplate);
    insertAction.withTableName("WAITERS").usingColumns("ID", "NAME", "TIP", "ACTIV");
    BeanPropertySqlParameterSource para = new BeanPropertySqlParameterSource(waiter);
    insertAction.execute(para);
  }

  @Override
  public void delete(int id)
  {
    String sql = "UPDATE WAITERS\n" +
        "SET ACTIV = 0\n" +
        "WHERE ID = ?";
    jdbcTemplate.update(sql, id);
  }
  public class WaiterRowMapper implements RowMapper
  {
    @Override
    public Waiter mapRow(ResultSet resultSet, int i) throws SQLException
    {
      Waiter waiter= new Waiter();
      waiter.setId(resultSet.getInt("ID"));
      waiter.setName(resultSet.getString("NAME"));
      waiter.setTip(resultSet.getDouble("TIP"));
      waiter.setActiv(resultSet.getBoolean("ACTIV"));
      return waiter;
    }
  }
}
