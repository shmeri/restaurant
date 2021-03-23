package com.project.restaurant.DAO;

import com.project.restaurant.models.Waiter;

import java.util.List;

public interface WaitersDAO
{
  Waiter get(int id);
  List<Waiter> getAll();

  List<Waiter> getAllActive();

  void save(Waiter waiter);

  void delete(int id);
}
