package com.project.restaurant.services;

import com.project.restaurant.models.Waiter;

import java.util.List;

public interface WaitersService
{
  List<Waiter> getAll();

  List<Waiter> getAllActive();

  List<Waiter> getAllActiveOrderByTip();
  List<Waiter> getAllActiveOrderByName();

  void save(Waiter waiter);

  void delete(int id);
}
