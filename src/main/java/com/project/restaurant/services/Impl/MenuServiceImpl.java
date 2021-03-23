package com.project.restaurant.services.Impl;

import com.project.restaurant.DAO.MenuDAO;
import com.project.restaurant.models.Menu;
import com.project.restaurant.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService
{
  MenuDAO menuDAO;

  @Autowired
  public MenuServiceImpl(MenuDAO menuDAO)
  {
    this.menuDAO = menuDAO;
  }

  @Override
  public List<Menu> getAll()
  {
    List<Menu> menuList = menuDAO.getAll();
    return menuList;
  }

  @Override
  public void save(Menu menu)
  {
    menuDAO.save(menu);
  }
}
