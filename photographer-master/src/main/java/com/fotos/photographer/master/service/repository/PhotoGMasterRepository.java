package com.fotos.photographer.master.service.repository;

import com.fotos.photographer.master.service.model.PhotographerMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoGMasterRepository extends JpaRepository<PhotographerMaster, Integer> {
}
