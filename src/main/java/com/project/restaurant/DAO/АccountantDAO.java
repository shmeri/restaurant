package com.project.restaurant.DAO;

import com.project.restaurant.models.ClientAvaSpend;
import com.project.restaurant.models.Menu;
import com.project.restaurant.models.Waiter;

import java.util.List;

public interface АccountantDAO
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
