/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.reto3completoMiguel.servicios;

import com.usa.reto3completoMiguel.modelentidades.Lib;
import com.usa.reto3completoMiguel.repository.crud.libRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author USER
 */
@Service
public class libService {

    @Autowired
    libRepository libRepo;

    public Lib guardar(Lib lib) {
        if (lib.getId() == null) {
            return libRepo.save(lib);
        } else {
            Optional<Lib> libaux = libRepo.findById(lib.getId());
            if (libaux.isEmpty()) {
                return libRepo.save(lib);
            } else {
                return lib;
            }
        }
    }

    public List<Lib> buscarTodo() {
        return (List<Lib>) libRepo.findAll();
    }

    public Lib update(Lib c) {
        if (c.getId() != null) {
            Optional<Lib> g = libRepo.findById(c.getId());
            if (!g.isEmpty()) {

                if (c.getCapacity() != null) {
                    g.get().setCapacity(c.getCapacity());
                }
                if (c.getCategory() != null) {
                    g.get().setCategory(c.getCategory());
                }
                if (c.getDescription() != null) {
                    g.get().setDescription(c.getDescription());
                }
                if (c.getMessages() != null) {
                    g.get().setMessages(c.getMessages());
                }
                if (c.getName() != null) {
                    g.get().setName(c.getName());
                }
                if (c.getReservations() != null) {
                    g.get().setReservations(c.getReservations());
                }
                if (c.getTarget() != null) {
                    g.get().setTarget(c.getTarget());
                }
                return libRepo.save(g.get());
            }
        }
        return c;
    }

    public boolean delete(Integer c) {
        Optional<Lib> g = libRepo.findById(c);
        if (!g.isEmpty()) {
            libRepo.deleteById(g.get().getId());
            return true;
        }
        return false;
    }

}
