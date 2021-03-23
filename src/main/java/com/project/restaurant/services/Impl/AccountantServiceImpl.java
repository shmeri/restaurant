package com.project.restaurant.services.Impl;

import com.project.restaurant.DAO.АccountantDAO;
import com.project.restaurant.models.ClientAvaSpend;
import com.project.restaurant.models.Menu;
import com.project.restaurant.models.Waiter;
import com.project.restaurant.services.AccountantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountantServiceImpl implements AccountantService
{
  АccountantDAO accountantDAO;

  @Autowired
  public AccountantServiceImpl(АccountantDAO accountantDAO)
  {
    this.accountantDAO = accountantDAO;
  }

  @Override
  public Waiter secondLowestTip()
  {
    Waiter waiter = accountantDAO.secondLowestTip();
    return waiter;
  }

  @Override
  public List<Waiter> allWaitersOrderByTip()
  {
    List<Waiter> waiterList = accountantDAO.allWaitersOrderByTip();
    return waiterList;
  }

  @Override
  public ClientAvaSpend clientAve()
  {
    ClientAvaSpend clientAvaSpend = accountantDAO.clientAve();
    return clientAvaSpend;
  }

  @Override
  public Menu secondBestSale()
  {
    Menu secondBestSale = accountantDAO.secondBestSale();
    return secondBestSale;
  }

  @Override
  public Menu veganTotalWeightAndPrice()
  {
    Menu veganTotalWeightAndPrice = accountantDAO.veganTotalWeightAndPrice();
    return veganTotalWeightAndPrice;
  }

  @Override
  public List<Menu> veganDishesSale()
  {
    List<Menu> veganDishesSale = accountantDAO.veganDishesSale();
    return veganDishesSale;
  }

  @Override
  public ClientAvaSpend studentMutraAve()
  {
    ClientAvaSpend studentMutraAve = accountantDAO.studentMutraAve();
    return studentMutraAve;
  }

  @Override
  public void fireWaiterWithSecondLowTip()
  {
    accountantDAO.fireWaiterWithSecondLowTip();
  }
}
