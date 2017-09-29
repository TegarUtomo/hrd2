/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tegareng.hrd2.facade;

import java.util.List;

/**
 *
 * @author Tegareng
 * @param <T>
 */
public interface DatabaseFacadeLocal<T> {
    
    void create(T entity);

    void edit(T entity);

    void remove(T Entity);

    T find(Object id);

    List<T> findAll();

    List<T> findRange(int[] range);

    int count();
    
}
