package com.fotos.photographer.master.service.controller;

import com.fotos.photographer.master.service.business.PhotoGMasterBusiness;
import com.fotos.photographer.master.service.exception.PhotoGMasterBusinessException;
import com.fotos.photographer.master.service.model.PhotographerMaster;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value="${root.service.baseurl}")
public class PhotoGMasterController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PhotoGMasterController.class);

    @Autowired
    private PhotoGMasterBusiness photoGMasterBusiness;

    @Value("${root.correlationid}")
    private String correlationId;

    @GetMapping(value="/")
    public ResponseEntity<List<PhotographerMaster>> getAllItem(){
        LOGGER.info("{} : getAllItem started", correlationId);
        List<PhotographerMaster> list = photoGMasterBusiness.findAllRecords();

        if (list.size() == 0)
            throw new PhotoGMasterBusinessException("No Records Found");

        LOGGER.info("{} : getAllItem ended", correlationId);
        return new ResponseEntity<List<PhotographerMaster>>(list, HttpStatus.OK);
    }

    @GetMapping(value="/{id}")
    public Optional<PhotographerMaster> getItemById(@PathVariable long id){
        LOGGER.info("{} : getItemById started", correlationId);
        return photoGMasterBusiness.findRecordById(id);
    }

    @PostMapping(value="/save")
    public ResponseEntity<PhotographerMaster> saveItem(@RequestBody final PhotographerMaster photographerMaster){
        PhotographerMaster response = photoGMasterBusiness.save(photographerMaster);
        return new ResponseEntity<PhotographerMaster>(response, HttpStatus.OK);
    }
}
