/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tegareng.hrd2.Bean;

import com.tegareng.hrd2.Model.OrangModel;
import com.tegareng.hrd2.Model.ResponseModel;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Tegareng
 */
@Local
public interface OrangBeanLocal {
    
    public List<OrangModel> getList() throws Exception;
    public OrangModel getSingle(String id) throws Exception;
    public ResponseModel create(OrangModel model) throws Exception;
    public OrangModel edit(OrangModel model, String id) throws Exception;
    public ResponseModel delete(String id) throws Exception;
}
