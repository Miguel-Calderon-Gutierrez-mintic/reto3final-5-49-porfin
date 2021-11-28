/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.reto3completoMiguel.repository.crud;

import com.usa.reto3completoMiguel.modelentidades.Category;
import com.usa.reto3completoMiguel.interfaz.CategoryInterfaz;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author USER
 */

@Repository
public class CategoryRepository {
    
    @Autowired
    private CategoryInterfaz repo; 
    
    public List<Category> getAll(){
        return (List<Category>) repo.findAll();
    }
    
    public Optional<Category> getById(int id){
        return repo.findById(id);
    }
    
    public Category save (Category category){
        return repo.save(category);
    }
    
    public void delete(Category category){
        repo.delete(category);
    }

    
}
