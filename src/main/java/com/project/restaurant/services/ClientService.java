package com.project.restaurant.services;


import com.project.restaurant.models.Client;

import java.util.List;

public interface ClientService
{
  List<Client> getAll();

  void save(Client client);
}
