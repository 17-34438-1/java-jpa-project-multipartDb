package com.example.multipleds.Repository.sparcsn4;

import com.example.multipleds.Model.sparcsn4.InvUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InvUnitRepository extends JpaRepository<InvUnit, Long> {
    List<InvUnit> findByIdAndInvUnitFcyVisitTransitState(String id, String transitStatus);

    @Query("select i from InvUnit i where i.id='BERU2619095'")
    public List<InvUnit> getListWithBothDB();
}
