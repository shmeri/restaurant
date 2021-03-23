package com.project.restaurant.services.Impl;

import com.project.restaurant.DAO.ClientsDAO;
import com.project.restaurant.models.Client;
import com.project.restaurant.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService
{

  ClientsDAO clientsDAO;

  @Autowired
  public ClientServiceImpl(ClientsDAO clientsDAO)
  {
    this.clientsDAO = clientsDAO;
  }

  @Override
  public List<Client> getAll()
  {
    List<Client> clientList = clientsDAO.getAll();
    return clientList;
  }

  public void save(Client client)
  {
    clientsDAO.save(client);
  }
}

