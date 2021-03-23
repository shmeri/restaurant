package com.project.restaurant.services.Impl;

import com.project.restaurant.DAO.WaitersDAO;
import com.project.restaurant.models.Waiter;
import com.project.restaurant.services.WaitersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class WaitersServiceImpl implements WaitersService
{
  WaitersDAO waitersDAO;

  @Autowired
  public WaitersServiceImpl(WaitersDAO waitersDAO)
  {
    this.waitersDAO = waitersDAO;
  }

  @Override
  public List<Waiter> getAll()
  {
    List<Waiter> waiterList = waitersDAO.getAll();
    return waiterList;
  }

  @Override
  public List<Waiter> getAllActive()
  {
    List<Waiter> waiterList = waitersDAO.getAllActive();
    return waiterList;
  }

  @Override
  public List<Waiter> getAllActiveOrderByTip()
  {
    List<Waiter> waiterList = waitersDAO.getAllActive();
    Collections.sort(waiterList, Comparator.comparingDouble(Waiter::getTip).reversed());
    return waiterList;
  }

  @Override
  public List<Waiter> getAllActiveOrderByName()
  {
    List<Waiter> waiterList = waitersDAO.getAllActive();
    waiterList.sort(Comparator.comparing(Waiter::getName));
    return waiterList;
  }

  @Override
  public void save(Waiter waiter)
  {
    waitersDAO.save(waiter);
  }

  @Override
  public void delete(int id)
  {
    waitersDAO.delete(id);
  }
}
