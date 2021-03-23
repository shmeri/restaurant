package com.project.restaurant.DAO;

import com.project.restaurant.models.Restaurant;

public interface RestaurantDAO
{
  Restaurant findInfo();

  Double getAllCash();
}
