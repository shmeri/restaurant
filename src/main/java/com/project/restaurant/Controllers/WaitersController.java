package com.project.restaurant.Controllers;

import com.project.restaurant.models.Waiter;
import com.project.restaurant.services.WaitersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class WaitersController
{
  private WaitersService waitersService;

  @Autowired
  public WaitersController(WaitersService waitersService)
  {
    this.waitersService = waitersService;
  }

  @RequestMapping("/waiters")
  public String viewWaitressPage(Model model)
  {
    List<Waiter> waitersList = waitersService.getAllActive();
    model.addAttribute("waitersList", waitersList);
    return "Waiters/waiters" +
        "";
  }
  @RequestMapping("/waitersOrderByTip")
  public String viewWaitressOrderByTip(Model model)
  {
    List<Waiter> waitersList = waitersService.getAllActiveOrderByTip();
    model.addAttribute("waitersList", waitersList);
    return "Waiters/waitersOrderByTip";
  }
  @RequestMapping("/waitersOrderByName")
  public String viewWaitressOrderByName(Model model)
  {
    List<Waiter> waitersList = waitersService.getAllActiveOrderByName();
    model.addAttribute("waitersList", waitersList);
    return "Waiters/waitersOrderByName";
  }

  @RequestMapping("/addNewWaiters")
  public String showAddNewWaitress(Model model)
  {
    Waiter waiter = new Waiter();
    model.addAttribute("waiter", waiter);
    return "Waiters/addNewWaiter";
  }

  @RequestMapping(value = "/saveWaiter", method = RequestMethod.POST)
  public String save(@ModelAttribute("waiter") Waiter waiter)
  {
    waitersService.save(waiter);
    return "redirect:/waiters";
  }
  @RequestMapping("/delete/{id}")
  public String delete(@PathVariable(name = "id") int id){
    waitersService.delete(id);
    return "redirect:/waiters";
  }

}
