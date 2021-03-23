package com.project.restaurant.models;

public class Restaurant
{
  private int    id;
  private String name;
  private String address;
  private double money;

  public Restaurant()
  {
  }

  public Restaurant(int id, String name, String address, double money)
  {
    this.id = id;
    this.name = name;
    this.address = address;
    this.money = money;
  }

  public int getId()
  {
    return id;
  }

  public void setId(int id)
  {
    this.id = id;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getAddress()
  {
    return address;
  }

  public void setAddress(String address)
  {
    this.address = address;
  }

  public double getMoney()
  {
    return money;
  }

  public void setMoney(double money)
  {
    this.money = money;
  }
}
