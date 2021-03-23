package com.project.restaurant.models;

public class ClientAvaSpend
{
  private String type;
  private double average;

  public ClientAvaSpend()
  {
  }

  public ClientAvaSpend(String type, double average)
  {
    this.type = type;
    this.average = average;
  }

  public String getType()
  {
    return type;
  }

  public void setType(String type)
  {
    this.type = type;
  }

  public double getAverage()
  {
    return average;
  }

  public void setAverage(double average)
  {
    this.average = average;
  }
}
