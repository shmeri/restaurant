package com.project.restaurant.models;


public class Waiter
{
  private int     id;
  private String  name;
  private double  tip;
  private boolean activ;

  public Waiter()
  {
  }


  public Waiter(int id, String name, double tip, boolean activ)
  {
    this.id = id;
    this.name = name;
    this.tip = tip;
    this.activ = activ;
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

  public double getTip()
  {
    return tip;
  }

  public void setTip(double tip)
  {
    this.tip = tip;
  }

  public boolean isActiv()
  {
    return activ;
  }

  public void setActiv(boolean activ)
  {
    this.activ = activ;
  }

  @Override
  public String toString()
  {
    return "Waitress{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", tip=" + tip +
        ", activ=" + activ +
        '}';
  }
}
