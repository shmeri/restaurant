package com.project.restaurant.Controllers;

import com.project.restaurant.models.ClientAvaSpend;
import com.project.restaurant.models.Menu;
import com.project.restaurant.models.Waiter;
import com.project.restaurant.services.AccountantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AccountantController
{
  AccountantService accountantService;

  @Autowired
  public AccountantController(AccountantService accountantService)
  {
    this.accountantService = accountantService;
  }

  @RequestMapping("/accountant")
  public String viewAccountant(){
    return "Accountant/Accountant";
  }

  @RequestMapping("/accountant/secondLower")
  public String viewSecondLower(Model model)
  {
    Waiter waiter = accountantService.secondLowestTip();
    model.addAttribute("secondLower", waiter);
    return "Accountant/accountantSecondLower";
  }
  @RequestMapping("/accountant/clientAveSpend")
  public String viewClientAveSpend(Model model)
  {
    ClientAvaSpend clientAvaSpend = accountantService.clientAve();
    model.addAttribute("clientAve", clientAvaSpend);
    return "Accountant/accountantAveSpend";
  }
  @RequestMapping("/accountant/secondBest")
  public String viewSecondBest(Model model)
  {
    Menu secondBest = accountantService.secondBestSale();
    model.addAttribute("secondBest", secondBest);
    return "Accountant/accountantSecondBest";
  }

  @RequestMapping(value = "/accountant/fireSecond", method = RequestMethod.POST)
  public String viewFireSecond()
  {
    accountantService.fireWaiterWithSecondLowTip();
    return "redirect:/clients";
  }

}
