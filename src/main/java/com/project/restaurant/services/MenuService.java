package com.project.restaurant.services;

import com.project.restaurant.models.Menu;

import java.util.List;

public interface MenuService
{
  List<Menu> getAll();
  void save(Menu menu);
}
