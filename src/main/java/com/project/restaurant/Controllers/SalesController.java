package com.project.restaurant.Controllers;

import com.project.restaurant.models.Sale;
import com.project.restaurant.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class SalesController
{

  private SaleService saleService;

  @Autowired
  public SalesController(SaleService saleService)
  {
    this.saleService = saleService;
  }

  @RequestMapping("/sales")
  public String viewSalesPage(Model model)
  {
    List<Sale> saleList = saleService.getAll();
    model.addAttribute("saleList", saleList);
    return "Sales/sales";
  }

}
