package com.project.restaurant.models;

public class Sale
{
  private int     id;
  private String  clientName;
  private String  waitersName;
  private String  dishes;
  private double  price;
  private int quantity;

  public Sale()
  {
  }

  public Sale(int id, String clientName, String waitersName, String dishes, double price, int quantity)
  {
    this.id = id;
    this.clientName = clientName;
    this.waitersName = waitersName;
    this.dishes = dishes;
    this.price = price;
    this.quantity = quantity;
  }

  public int getId()
  {
    return id;
  }

  public void setId(int id)
  {
    this.id = id;
  }

  public String getClientName()
  {
    return clientName;
  }

  public void setClientName(String clientName)
  {
    this.clientName = clientName;
  }



  public String getDishes()
  {
    return dishes;
  }

  public void setDishes(String dishes)
  {
    this.dishes = dishes;
  }

  public String getWaitersName()
  {
    return waitersName;
  }

  public void setWaitersName(String waitersName)
  {
    this.waitersName = waitersName;
  }

  public double getPrice()
  {
    return price;
  }

  public void setPrice(double price)
  {
    this.price = price;
  }

  public int getQuantity()
  {
    return quantity;
  }

  public void setQuantity(int quantity)
  {
    this.quantity = quantity;
  }

  @Override
  public String toString()
  {
    return "Sale{" +
        "id=" + id +
        ", clientName='" + clientName + '\'' +
        ", waitersName='" + waitersName + '\'' +
        ", dishes='" + dishes + '\'' +
        ", price=" + price +
        ", quantity=" + quantity +
        '}';
  }
}
