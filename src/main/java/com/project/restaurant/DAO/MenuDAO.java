package com.project.restaurant.DAO;

import com.project.restaurant.models.Menu;

import java.util.List;

public interface MenuDAO
{
  List<Menu> getAll();

  void save(Menu menu);

  void delete(Menu menu);
}
