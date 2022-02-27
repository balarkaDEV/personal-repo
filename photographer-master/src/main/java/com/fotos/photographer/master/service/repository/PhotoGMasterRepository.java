package com.fotos.photographer.master.service.repository;

import com.fotos.photographer.master.service.model.PhotographerMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhotoGMasterRepository extends JpaRepository<PhotographerMaster, Long> {

    @Query(value = "SELECT * FROM photographer_master f WHERE f.name = ?1", nativeQuery = true)
    public List<PhotographerMaster> findByName(String name);
}
