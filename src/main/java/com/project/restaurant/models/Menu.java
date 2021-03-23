package com.project.restaurant.models;

public class Menu
{
  private int     id;
  private String  dishesName;
  private double  price;
  private int     weight;
  private int     quantity;

  public Menu(int id, String dishesName, double price, int weight, int quantity)
  {
    this.id = id;
    this.dishesName = dishesName;
    this.price = price;
    this.weight = weight;
    this.quantity = quantity;
  }

  public Menu()
  {
  }


  public int getId()
  {
    return id;
  }

  public void setId(int id)
  {
    this.id = id;
  }

  public String getDishesName()
  {
    return dishesName;
  }

  public void setDishesName(String dishesName)
  {
    this.dishesName = dishesName;
  }

  public double getPrice()
  {
    return price;
  }

  public void setPrice(double price)
  {
    this.price = price;
  }

  public int getWeight()
  {
    return weight;
  }

  public void setWeight(int weight)
  {
    this.weight = weight;
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
    return "Menu{" +
        "id=" + id +
        ", dishesName='" + dishesName + '\'' +
        ", price=" + price +
        ", weight=" + weight +
        ", quantity=" + quantity +
        '}';
  }
}
