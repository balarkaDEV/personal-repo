package com.fotos.photographer.master.service.business;

import com.fotos.photographer.master.service.model.PhotographerMaster;
import com.fotos.photographer.master.service.repository.PhotoGMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PhotoGMasterBusiness {

    @Autowired
    private PhotoGMasterRepository photoGMasterRepository;

    public List<PhotographerMaster> findAllRecords(){
        return photoGMasterRepository.findAll();
    }

    public Optional<PhotographerMaster> findRecordById(long id){
        return photoGMasterRepository.findById(id);
    }

    public PhotographerMaster save(PhotographerMaster photographerMaster) {
        return photoGMasterRepository.save(photographerMaster);
    }

    /*public List<PhotographerMaster> findRecordsByName(String name){
        return photoGMasterRepository.findByName(name);
    }*/

    public List<PhotographerMaster> findRecordsByQuery(Map<String, String> queryParams){
        if (queryParams.get("name") != null && queryParams.get("city") != null)
            return photoGMasterRepository.findByNameAndCity(queryParams.get("name"), queryParams.get("city"));
        if (queryParams.get("name") != null)
            return photoGMasterRepository.findByName(queryParams.get("name"));
        else
            return photoGMasterRepository.findByCity(queryParams.get("city"));
    }

    /*public List<PhotographerMaster> findRecordsByNameAndCity(String name, String city){
        return photoGMasterRepository.findByNameAndCity(name,city);
    }

    public List<PhotographerMaster> findRecordsByName(String name){
        return photoGMasterRepository.findByName(name);
    }

    public List<PhotographerMaster> findRecordsByCity(String city){
        return photoGMasterRepository.findByCity(city);
    }*/
}
