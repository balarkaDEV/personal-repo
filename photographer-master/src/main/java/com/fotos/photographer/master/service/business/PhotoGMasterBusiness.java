package com.fotos.photographer.master.service.business;

import com.fotos.photographer.master.service.model.PhotographerMaster;
import com.fotos.photographer.master.service.repository.PhotoGMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotoGMasterBusiness {

    @Autowired
    private PhotoGMasterRepository photoGMasterRepository;

    public List<PhotographerMaster> findAllRecords(){
        return photoGMasterRepository.findAll();
    }
}
