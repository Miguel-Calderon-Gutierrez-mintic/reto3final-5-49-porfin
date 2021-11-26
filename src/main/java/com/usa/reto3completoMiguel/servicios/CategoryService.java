/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.reto3completoMiguel.servicios;

import com.usa.reto3completoMiguel.modelentidades.Category;
import com.usa.reto3completoMiguel.repository.crud.CategoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USER
 */
@Service
public class CategoryService {

    @Autowired
    CategoryRepository CategoryRepo;

    public Category guardar(Category category) {
        if (category.getId() == null) {
            return CategoryRepo.save(category);
        } else {
            Optional<Category> Categoryaux = CategoryRepo.findById(category.getId());
            if (Categoryaux.isEmpty()) {
                return CategoryRepo.save(category);
            } else {
                return category;
            }
        }
    }

    public List<Category> buscarTodo() {
        return (List<Category>) CategoryRepo.findAll();
    }

    public Category update(Category c) {
        if (c.getId() != null) {
            Optional<Category> g = CategoryRepo.findById(c.getId());
            if (!g.isEmpty()) {
                System.out.println("saludo desde actualizar");
                if (c.getName() != null) {
                    System.out.println("saludo desde actualizar nombre");
                    g.get().setName(c.getName());
                }
                if (c.getDescription() != null) {
                     System.out.println("saludo desde actualizar descrip");
                    g.get().setDescription(c.getDescription());
                }
                if (c.getLibs() != null) {
                    g.get().setLibs(c.getLibs());
                }
                return CategoryRepo.save(g.get());
            }
        }
        return c;
    }

    public boolean delete(Integer c) {
        Optional<Category> g = CategoryRepo.findById(c);
        if (!g.isEmpty()) {
            CategoryRepo.deleteById(g.get().getId());
            return true;
        }
        return false;
    }

}
