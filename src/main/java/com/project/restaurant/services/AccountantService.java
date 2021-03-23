package com.project.restaurant.services;

import com.project.restaurant.models.ClientAvaSpend;
import com.project.restaurant.models.Menu;
import com.project.restaurant.models.Waiter;

import java.util.List;

public interface AccountantService
{
  Waiter secondLowestTip();

  List<Waiter> allWaitersOrderByTip();

  ClientAvaSpend clientAve();

  Menu secondBestSale();

  Menu veganTotalWeightAndPrice();

  List<Menu> veganDishesSale();

  ClientAvaSpend studentMutraAve();

  void fireWaiterWithSecondLowTip();
}
