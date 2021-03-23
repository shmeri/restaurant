package com.project.restaurant.Controllers;

import com.project.restaurant.models.Client;
import com.project.restaurant.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ClientController
{

  private ClientService clientService;


  @Autowired
  public ClientController(ClientService ClientService)
  {
    this.clientService = ClientService;
  }

  @RequestMapping("/clients")
  public String viewClientsPage(Model model)
  {
    List<Client> clientList = clientService.getAll();
    model.addAttribute("clientList", clientList);
    return "Clients/clients";
  }

  @RequestMapping("/addNewClient")
  public String showAddNewClient(Model model)
  {
    Client client = new Client();
    model.addAttribute("client", client);
    return "Clients/addNewClient";
  }

  @RequestMapping(value = "/saveClient", method = RequestMethod.POST)
  public String save(@ModelAttribute("client") Client client)
  {
    clientService.save(client);
    return "redirect:/clients";
  }

}