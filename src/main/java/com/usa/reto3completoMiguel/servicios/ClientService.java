/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.reto3completoMiguel.servicios;


import com.usa.reto3completoMiguel.modelentidades.Client;
import com.usa.reto3completoMiguel.repository.crud.ClientRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USER
 */
@Service
public class ClientService {

    @Autowired
    ClientRepository ClientRepo;

    public Client guardar(Client client) {
          if (client.getIdClient()== null) {
            return ClientRepo.save(client);
        } else {
            Optional<Client> libaux = ClientRepo.findById(client.getIdClient());
            if (libaux.isEmpty()) {
                return ClientRepo.save(client);
            } else {
                return client;
            }
        }
    }

    public List<Client> buscarTodo() {
        return (List<Client>) ClientRepo.findAll();
    }

    public Client update(Client c) {
        if (c.getIdClient()!= null) {
            Optional<Client> g = ClientRepo.findById(c.getIdClient());
            if (!g.isEmpty()) {
                if (c.getAge() != null) {
                    g.get().setAge(c.getAge());
                }
                if (c.getEmail()!= null) {
                    g.get().setEmail(c.getEmail());
                }
                if (c.getMessages() != null) {
                    g.get().setMessages(c.getMessages());
                }
                if (c.getName() != null) {
                    g.get().setName(c.getName());
                }
                if (c.getPassword() != null) {
                    g.get().setPassword(c.getPassword());
                }
                if (c.getReservations() != null) {
                    g.get().setReservations(c.getReservations());
                }
                return ClientRepo.save(g.get());
            }
        }
        return c;
    }

    public boolean delete(Integer c) {
        Optional<Client> g = ClientRepo.findById(c);
        if (!g.isEmpty()) {
            ClientRepo.deleteById(g.get().getIdClient());
            return true;
        }
        return false;
    }
}
