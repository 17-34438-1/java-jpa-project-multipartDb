package com.example.multipleds.Repository.sparcsn4;


import com.example.multipleds.Model.sparcsn4.InvUnitFcyVisit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvUnitFcyVisitRepository extends JpaRepository<InvUnitFcyVisit, Long> {

    List<InvUnitFcyVisit> findByTransitStateAndInvUnitId(String transitStatus, String id);

    List<InvUnitFcyVisit> findByInvUnitIdAndTransitState(String id, String transitStatus);
}



//   @Column(name = "transit_state")
//     private String transitState;

//     @JsonIgnore
//     @ManyToOne
//     @JoinColumn(name = "unit_gkey") //setting the name of the joining column
//     private InvUnit invUnit;
