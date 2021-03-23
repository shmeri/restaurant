package com.project.restaurant.models;

public class VeganWeightPrice
{
  private String type;
  private int    weight;
  private double price;

  public VeganWeightPrice()
  {
  }

  public VeganWeightPrice(String type, int weight, double price)
  {
    this.type = type;
    this.weight = weight;
    this.price = price;
  }

  public String getType()
  {
    return type;
  }

  public void setType(String type)
  {
    this.type = type;
  }

  public int getWeight()
  {
    return weight;
  }

  public void setWeight(int weight)
  {
    this.weight = weight;
  }

  public double getPrice()
  {
    return price;
  }

  public void setPrice(double price)
  {
    this.price = price;
  }
}
