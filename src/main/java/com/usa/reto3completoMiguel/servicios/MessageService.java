/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.reto3completoMiguel.servicios;

import com.usa.reto3completoMiguel.modelentidades.Message;
import com.usa.reto3completoMiguel.repository.crud.MessageRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USER
 */
@Service
public class MessageService {

    @Autowired
    MessageRepository messageRepo;

    public Message guardar(Message message) {
        if (message.getIdMessage()== null) {
            return messageRepo.save(message);
        } else {
            Optional<Message> libaux = messageRepo.findById(message.getIdMessage());
            if (libaux.isEmpty()) {
                return messageRepo.save(message);
            } else {
                return message;
            }
        }
    }

    public List<Message> buscarTodo() {
        return (List<Message>) messageRepo.findAll();
    }

    public Message update(Message c) {
        if (c.getIdMessage()!= null) {
            Optional<Message> g = messageRepo.findById(c.getIdMessage());
            if (!g.isEmpty()) {

                if (c.getClient()!= null) {
                    g.get().setClient(c.getClient());
                }
               if (c.getLib()!= null) {
                    g.get().setLib(c.getLib());
                }
                if (c.getMessageText()!= null) {
                    g.get().setMessageText(c.getMessageText());
                }        
                return messageRepo.save(g.get());
            }
        }
        return c;
    }

    public boolean delete(Integer c) {
        Optional<Message> g = messageRepo.findById(c);
        if (!g.isEmpty()) {
            messageRepo.deleteById(g.get().getIdMessage());
            return true;
        }
        return false;
    }

}
