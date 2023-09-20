package com.example.multipleds.Repository.commonN4;

import com.example.multipleds.Model.commonN4.ArgoCalEventType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ArgoCalEventTypeRepository extends JpaRepository<ArgoCalEventType, Long> {

    @Query("SELECT a FROM ArgoCalEventType a WHERE a.gkey = 182")
    List<ArgoCalEventType> findUsingJPQL();

    @Query("SELECT max(gkey) FROM ArgoCalEventType a")
    Integer highestArgoCalEventTypeGkey();


}
