package com.project.restaurant.models;

public class Order
{
  private int id;
  private int clientId;
  private int waitressId;
  private int menuId;

  public Order()
  {
  }

  public Order(int id, int clientId, int waitressId, int menuId)
  {
    this.id = id;
    this.clientId = clientId;
    this.waitressId = waitressId;
    this.menuId = menuId;
  }

  public int getId()
  {
    return id;
  }

  public void setId(int id)
  {
    this.id = id;
  }

  public int getClientId()
  {
    return clientId;
  }

  public void setClientId(int clientId)
  {
    this.clientId = clientId;
  }

  public int getWaitressId()
  {
    return waitressId;
  }

  public void setWaitressId(int waitressId)
  {
    this.waitressId = waitressId;
  }

  public int getMenuId()
  {
    return menuId;
  }

  public void setMenuId(int menuId)
  {
    this.menuId = menuId;
  }
}
