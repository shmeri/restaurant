package com.project.restaurant.Controllers;

import com.project.restaurant.DAO.Impl.RestaurantDAOImpl;
import com.project.restaurant.models.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RestaurantController
{
  private RestaurantDAOImpl restaurantDAOImpl;

  @Autowired
  public RestaurantController(RestaurantDAOImpl restaurantDAOImpl)
  {
    this.restaurantDAOImpl = restaurantDAOImpl;
  }

  @RequestMapping("/restaurantInfo")
  public String viewRestaurantInfo(Model model)
  {
    Restaurant restaurant = restaurantDAOImpl.findInfo();
    Double allCash = restaurantDAOImpl.getAllCash();
    model.addAttribute("restaurantInfo", restaurant);
    model.addAttribute("allCash", allCash);
    return "restaurantInfo";
  }
}
