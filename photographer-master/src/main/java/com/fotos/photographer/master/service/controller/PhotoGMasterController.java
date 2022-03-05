package com.fotos.photographer.master.service.controller;

import com.fotos.photographer.master.service.business.PhotoGMasterBusiness;
import com.fotos.photographer.master.service.exception.PhotoGMasterBusinessException;
import com.fotos.photographer.master.service.model.PhotographerMaster;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping(value="${root.service.moduleurl}")
public class PhotoGMasterController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PhotoGMasterController.class);

    @Autowired
    private PhotoGMasterBusiness photoGMasterBusiness;

    @GetMapping(value="/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PhotographerMaster>> getAllItem(){
        LOGGER.info("getAllItem started");
        List<PhotographerMaster> list = photoGMasterBusiness.findAllRecords();

        if (list.size() == 0)
            throw new PhotoGMasterBusinessException("No Records Found");

        LOGGER.info("getAllItem ended");
        return new ResponseEntity<List<PhotographerMaster>>(list, HttpStatus.OK);
    }

    @GetMapping(value="/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<PhotographerMaster> getItemById(@PathVariable long id){
        LOGGER.info("getItemById started");
        return photoGMasterBusiness.findRecordById(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PhotographerMaster>> getItemsByQuery(@RequestParam Map<String, String> queryParams){
        LOGGER.info("getItemByName started");

        List<PhotographerMaster> list = photoGMasterBusiness.findRecordsByQuery(queryParams);

        if (list.size() == 0)
            throw new PhotoGMasterBusinessException("No Records Found");

        LOGGER.info("getItemByName ended");
        return new ResponseEntity<List<PhotographerMaster>>(list, HttpStatus.OK);
    }

    /*@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PhotographerMaster>> getItemsByCityStateCountry(@RequestParam String city, @RequestParam String state, @RequestParam String country){
        LOGGER.info("{} : getItemsByCityStateCountry started", correlationId);
        List<PhotographerMaster> list = photoGMasterBusiness.findRecordsByCityStateCountry(city,state,country);

        if (list.size() == 0)
            throw new PhotoGMasterBusinessException("No Records Found");

        LOGGER.info("{} : getItemsByCityStateCountry ended", correlationId);
        return new ResponseEntity<List<PhotographerMaster>>(list, HttpStatus.OK);
    }*/

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PhotographerMaster> saveItem(@RequestBody final PhotographerMaster photographerMaster){
        LOGGER.info("saveItem started");
        PhotographerMaster response = photoGMasterBusiness.save(photographerMaster);
        LOGGER.info("saveItem ended");
        return new ResponseEntity<PhotographerMaster>(response, HttpStatus.OK);
    }
}
