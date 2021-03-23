package com.project.restaurant.DAO.Impl;

import com.project.restaurant.DAO.ClientsDAO;
import com.project.restaurant.models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientsDAOImpl implements ClientsDAO
{

  private JdbcTemplate jdbcTemplate;

  @Autowired
  public ClientsDAOImpl(JdbcTemplate jdbcTemplate)
  {
    this.jdbcTemplate = jdbcTemplate;
  }

  public List<Client> getAll()
  {
    String sql = "SELECT id, name, type FROM CLIENTS";
    List<Client> clientList = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Client.class));
    return clientList;
  }

  public void save(Client client)
  {
    SimpleJdbcInsert insertAction = new SimpleJdbcInsert(jdbcTemplate);
    insertAction.withTableName("CLIENTS").usingColumns("ID", "NAME", "TYPE");
    BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(client);
    insertAction.execute(param);
  }

  @Override
  public Client getById(int id)
  {
    String sql = "SELECT * FROM CLIENTS WHERE ID = ?";
    Object[] args = {id};
    Client client = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(Client.class));
    return client;
  }

  @Override
  public void update(Client client)
  {

  }

  @Override
  public void delete(int id)
  {

  }

}
