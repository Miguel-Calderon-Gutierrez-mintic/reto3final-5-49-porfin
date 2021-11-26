/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.reto3completoMiguel.servicios;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.usa.reto3completoMiguel.modelentidades.Reservation;
import com.usa.reto3completoMiguel.repository.crud.ReservationRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USER
 */
@Service
@JsonPropertyOrder({"idReservation", "StartDate", "devolutionDate", "status", "score"})
public class ReservationService {

    @Autowired
    ReservationRepository ReservationRepo;

    public Reservation guardar(Reservation Reservation) {
        if (Reservation.getIdReservation() == null) {
            return ReservationRepo.save(Reservation);
        } else {
            Optional<Reservation> libaux = ReservationRepo.findById(Reservation.getIdReservation());
            if (libaux.isEmpty()) {
                return ReservationRepo.save(Reservation);
            } else {
                return Reservation;
            }
        }
    }

    public List<Reservation> buscarTodo() {
        return (List<Reservation>) ReservationRepo.findAll();
    }

    public Reservation update(Reservation c) {
        if (c.getIdReservation() != null) {
            Optional<Reservation> g = ReservationRepo.findById(c.getIdReservation());
            if (!g.isEmpty()) {

                if (c.getClient() != null) {
                    g.get().setClient(c.getClient());
                }

                if (c.getDevolutionDate() != null) {
                    g.get().setDevolutionDate(c.getDevolutionDate());
                }
                if (c.getLib() != null) {
                    g.get().setLib(c.getLib());
                }
                if (c.getScore() != null) {
                    g.get().setScore(c.getScore());
                }
                if (c.getStartDate() != null) {
                    g.get().setStartDate(c.getStartDate());
                }
                if (c.getStatus() != null) {
                    g.get().setStatus(c.getStatus());
                }
                return ReservationRepo.save(g.get());
            }
        }
        return c;
    }

    public boolean delete(Integer c) {
        Optional<Reservation> g = ReservationRepo.findById(c);
        if (!g.isEmpty()) {
            ReservationRepo.deleteById(g.get().getIdReservation());
            return true;
        }
        return false;
    }

}
