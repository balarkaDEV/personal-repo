package com.fotos.photographer.master.service.repository;

import com.fotos.photographer.master.service.model.PhotographerMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhotoGMasterRepository extends JpaRepository<PhotographerMaster, Long> {

    @Query(value = "from PhotographerMaster p where p.name like :name%")
    public List<PhotographerMaster> findByName(@Param("name") String name);

    @Query(value = "from PhotographerMaster p where p.city = :city")
    public List<PhotographerMaster> findByCity(@Param("city") String city);

    @Query(value = "from PhotographerMaster p where p.name like :name% AND p.city = :city")
    public List<PhotographerMaster> findByNameAndCity(@Param("name") String name, @Param("city") String city);
}
