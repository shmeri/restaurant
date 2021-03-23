package com.project.restaurant;

import com.project.restaurant.DAO.Impl.WaitersDAOImpl;
import com.project.restaurant.models.Waiter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class WaiterDAOImplTest
{
  private WaitersDAOImpl daoWaitress;

  @BeforeEach
  void setUp() throws Exception
  {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setUrl("jdbc:oracle:thin:@//83.228.124.173:6223/Shmeri");
    dataSource.setUsername("Shmeri");
    dataSource.setPassword("Shmeri");
    dataSource.setDriverClassName("oracle.jdbc.OracleDriver");

    daoWaitress = new WaitersDAOImpl(new JdbcTemplate(dataSource));
  }

  @Test
  void testList()
  {
    List<Waiter> waiterList = daoWaitress.getAll();
    assertFalse(waiterList.isEmpty());
    System.out.println(waiterList);
  }

  @Test
  void testSave()
  {
    Waiter waiter = new Waiter();
    daoWaitress.save(waiter);
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
  void testDelete(int id)
  {

  }
}
