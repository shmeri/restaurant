package com.project.restaurant.Controllers;

import com.project.restaurant.models.Menu;
import com.project.restaurant.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class MenuController
{
  private MenuService menuService;

  @Autowired
  public MenuController(MenuService menuService)
  {
    this.menuService = menuService;
  }

  @RequestMapping("/menu")
  public String viewMenuPage(Model model)
  {
    List<Menu> menuList = menuService.getAll();
    model.addAttribute("menuList", menuList);
    return "Menu/menu";
  }

  @RequestMapping("/addNewDishes")
  public String showAddNewDishes(Model model)
  {
    Menu menu = new Menu();
    model.addAttribute("dishes", menu);
    return "Menu/addNewDishes";
  }

  @RequestMapping(value = "/saveDishes", method = RequestMethod.POST)
  public String save(@ModelAttribute("dishes") Menu menu)
  {
    menuService.save(menu);
    return "redirect:/menu";
  }
}
