/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.reto3completoMiguel.webcontroladores;

import com.usa.reto3completoMiguel.modelentidades.Client;
import com.usa.reto3completoMiguel.servicios.ClientService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author USER
 */
@RestController
@RequestMapping("/api/Client")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ClientRestController {

    @Autowired
    ClientService Clientserver;

    @GetMapping("/all")
    public List<Client> list() {
        return Clientserver.buscarTodo();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void post(@RequestBody Client Client) {
        Clientserver.guardar(Client);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public void put(@RequestBody Client Client) {
        Clientserver.update(Client);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        Clientserver.delete(id);
    }
}
