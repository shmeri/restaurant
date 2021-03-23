package com.project.restaurant.services.Impl;

import com.project.restaurant.DAO.SalesDAO;
import com.project.restaurant.models.Sale;
import com.project.restaurant.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleServiceImpl implements SaleService
{
  SalesDAO salesDAO;

  @Autowired
  public SaleServiceImpl(SalesDAO salesDAO)
  {
    this.salesDAO = salesDAO;
  }

  @Override
  public List<Sale> getAll()
  {
    List<Sale> saleList = salesDAO.getAll();
    return saleList;
  }

}
