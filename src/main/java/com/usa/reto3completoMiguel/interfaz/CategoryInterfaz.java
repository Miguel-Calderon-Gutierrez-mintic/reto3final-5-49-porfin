/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.reto3completoMiguel.interfaz;

/**
 *
 * @author Administrador
 */

import com.usa.reto3completoMiguel.modelentidades.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryInterfaz extends CrudRepository<Category, Integer> {
    
}
