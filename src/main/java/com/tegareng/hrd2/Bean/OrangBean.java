/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tegareng.hrd2.Bean;

import com.tegareng.hrd2.Model.OrangModel;
import com.tegareng.hrd2.Model.ResponseModel;
import com.tegareng.hrd2.entity.Orang;
import com.tegareng.hrd2.facade.OrangFacadeLocal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Singleton;

/**
 *
 * @author Tegareng
 */
@Singleton
public class OrangBean implements OrangBeanLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @EJB
    private OrangFacadeLocal orangFacade;
    
    @Override
    public List<OrangModel> getList() throws Exception {
        
        List<OrangModel> models = new ArrayList<>();
        List<Orang> entityList = orangFacade.findAll();
        
        for(Orang entity : entityList){
            OrangModel model = new OrangModel();
            model.setId(entity.getId());
            model.setNama(entity.getNama());
            model.setEmail(entity.getEmail());
            
            models.add(model);
        }
        return models;
    }

    @Override
    public OrangModel getSingle(String id) throws Exception {
        
        Orang entity = orangFacade.find(id);
        OrangModel model = new OrangModel(entity);
        return model;
    }

    @Override
    public ResponseModel create(OrangModel model) throws Exception {
        
        ResponseModel response = new ResponseModel();
        Orang entity = new Orang(model);
        try{
            orangFacade.create(entity);
            response.setResponseCode(200);
            response.setMessage("Success");
            return response;
        }catch(Exception e){
            response.setMessage("Failed");
            response.setResponseCode(500);
            return response;
        }
    }
    
    @Override
    public OrangModel edit(OrangModel model, String id) throws Exception {
        
        Orang entity = orangFacade.find(id);
        entity.setNama(model.getNama());
        entity.setEmail(model.getEmail());
        
        orangFacade.edit(entity);
        return new OrangModel(entity);
    }

    @Override
    public ResponseModel delete(String id) throws Exception {
        
        ResponseModel response = new ResponseModel();
        
        try{
            Orang entity = orangFacade.find(id);
            orangFacade.remove(entity);
            response.setResponseCode(200);
            response.setMessage("Success");
            
            return response;
        }catch(Exception e){
            response.setMessage("Failed");
            response.setResponseCode(500);
            return response;
        }
    }
}
