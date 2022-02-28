package com.fotos.photographer.master.service.repository;

import com.fotos.photographer.master.service.model.PhotographerMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhotoGMasterRepository extends JpaRepository<PhotographerMaster, Long> {

    @Query(value = "from PhotographerMaster p where p.name like :nameValue%")
    public List<PhotographerMaster> findByName(@Param("nameValue") String nameValue);
}
