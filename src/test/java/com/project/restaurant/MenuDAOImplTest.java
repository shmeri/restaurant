package com.project.restaurant;

import com.project.restaurant.DAO.Impl.MenuDAOImpl;
import com.project.restaurant.models.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class MenuDAOImplTest
{

  private MenuDAOImpl menuDAOImpl;

  @BeforeEach
  void setUp() throws Exception
  {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setUrl("jdbc:oracle:thin:@//83.228.124.173:6223/Shmeri");
    dataSource.setUsername("Shmeri");
    dataSource.setPassword("Shmeri");
    dataSource.setDriverClassName("oracle.jdbc.OracleDriver");

    menuDAOImpl = new MenuDAOImpl(new JdbcTemplate(dataSource));
  }

  @Test
  void testList()
  {
    List<Menu> menuList = menuDAOImpl.getAll();
    assertFalse(menuList.isEmpty());
    System.out.println(menuList);
  }

  @Test
  void testSave()
  {
    Menu menu = new Menu(7, "Pizza", 11.90, 500,  20);
    menuDAOImpl.save(menu);
  }
}