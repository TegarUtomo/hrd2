/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tegareng.hrd2.facade;

import com.tegareng.hrd2.entity.Orang;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Tegareng
 */
@Stateless
public class OrangFacade extends AbstractFacade<Orang> implements OrangFacadeLocal {
    @PersistenceContext(unitName = "HRD_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrangFacade() {
        super(Orang.class);
    }
}
