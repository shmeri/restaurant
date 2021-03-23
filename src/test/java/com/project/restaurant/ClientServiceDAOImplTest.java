package com.project.restaurant;

import com.project.restaurant.DAO.Impl.ClientsDAOImpl;
import com.project.restaurant.models.Client;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class ClientServiceDAOImplTest
{
  private ClientsDAOImpl daoClients;

  @BeforeEach
  void setUp() throws Exception
  {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setUrl("jdbc:oracle:thin:@//83.228.124.173:6223/Shmeri");
    dataSource.setUsername("Shmeri");
    dataSource.setPassword("Shmeri");
    dataSource.setDriverClassName("oracle.jdbc.OracleDriver");

    daoClients = new ClientsDAOImpl(new JdbcTemplate(dataSource));
  }

  @Test
  void testGetAll()
  {
    List<Client> clientList = daoClients.getAll();
    assertFalse(clientList.isEmpty());
    System.out.println(clientList);
  }

  @Test
  void testSave()
  {
    Client client = new Client(100, "Dragan", "vegan");
    daoClients.save(client);
  }

  @Test
  void testGetById(int id)
  {
    Client client = daoClients.getById(id);
    Assertions.assertNotNull(client);
  }

}
