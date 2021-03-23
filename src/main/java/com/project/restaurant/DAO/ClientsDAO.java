package com.project.restaurant.DAO;

import com.project.restaurant.models.Client;

import java.util.List;


public interface ClientsDAO
{
  List<Client> getAll();

  void save(Client client);

  Client getById(int id);

  void update(Client client);

  void delete(int id);
}
