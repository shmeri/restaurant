package com.project.restaurant;

import com.project.restaurant.DAO.Impl.SalesDAOImpl;
import com.project.restaurant.models.Sale;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SalesDAOImplTest
{
  private SalesDAOImpl dao;

  @BeforeEach
  void setUp() throws Exception
  {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setUrl("jdbc:oracle:thin:@//83.228.124.173:6223/Shmeri");
    dataSource.setUsername("Shmeri");
    dataSource.setPassword("Shmeri");
    dataSource.setDriverClassName("oracle.jdbc.OracleDriver");

    dao = new SalesDAOImpl(new JdbcTemplate(dataSource));
  }

  @Test
  void testList()
  {
    List<Sale> saleList = dao.getAll();
    assertFalse(saleList.isEmpty());
    System.out.println(saleList);
  }

  @Test
  void testSave()
  {
    fail("Not implement yet");
  }

  @Test
  void testGet()
  {
    fail("Not implement yet");
  }

  @Test
  void testUpdate()
  {
    fail("Not implement yet");
  }

  @Test
  void testDelete()
  {
    fail("Not implement yet");
  }
}
