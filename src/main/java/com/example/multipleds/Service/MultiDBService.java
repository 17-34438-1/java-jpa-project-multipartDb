package com.example.multipleds.Service;

import com.example.multipleds.Model.cchaportdb.VehicleFeesReg;
import com.example.multipleds.Model.commonN4.ArgoCalEventType;
import com.example.multipleds.Model.commonN4.ArgoReportDefinitions;
import com.example.multipleds.Model.oracle.ActiveMqLock;
import com.example.multipleds.Model.sparcsn4.InvUnit;
import com.example.multipleds.Model.sparcsn4.InvUnitFcyVisit;
import com.example.multipleds.Repository.cchaportdb.VehicleFeesRegRepository;
import com.example.multipleds.Repository.commonN4.ArgoCalEventTypeRepository;
import com.example.multipleds.Repository.commonN4.ArgoReportDefinitionsRepository;
import com.example.multipleds.Repository.oracle.ActiveMqLockRepository;
import com.example.multipleds.Repository.sparcsn4.InvUnitFcyVisitRepository;
import com.example.multipleds.Repository.sparcsn4.InvUnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MultiDBService {
    @Autowired
    private InvUnitRepository invUnitRepository;

    @Autowired
    private InvUnitFcyVisitRepository invUnitFcyVisitRepository;

    @Autowired
    private VehicleFeesRegRepository vehicleFeesRegRepository;

    @Autowired
    private ActiveMqLockRepository activeMqLockRepository;

    @Autowired
    private ArgoCalEventTypeRepository argoCalEventTypeRepository;

    @Autowired
    private ArgoReportDefinitionsRepository argoReportDefinitionsRepository;

    public List<InvUnit> findById(String id, String transitStatus){
        List<InvUnit> findById = invUnitRepository.findByIdAndInvUnitFcyVisitTransitState(id,transitStatus);
        //List<InvUnit> findById = invUnitRepository.getListWithBothDB();
        return findById;
    }

    public List<InvUnitFcyVisit> findByTransitStateAndId(String transitStatus, String id){
        //List<InvUnitFcyVisit> findByTransitStateAndId = invUnitFcyVisitRepository.findByTransitStateAndInvUnitId(transitStatus,id);
        List<InvUnitFcyVisit> findByTransitStateAndId = invUnitFcyVisitRepository.findByInvUnitIdAndTransitState(id,transitStatus);
        return findByTransitStateAndId;
    }

    public List<VehicleFeesReg> vehicleFeesRegList(){
        return vehicleFeesRegRepository.findAll();
    }

    public List<ActiveMqLock> activeMqLockList(){ return activeMqLockRepository.findAll(); }

    public List<ArgoCalEventType> argoCalEventTypes(){ return argoCalEventTypeRepository.findAll(); }

    public List<ArgoCalEventType> argoCalEventTypesUsingJPQL(){ return argoCalEventTypeRepository.findUsingJPQL(); }

    public Integer highestArgoCalEventTypeGkey(){ return argoCalEventTypeRepository.highestArgoCalEventTypeGkey(); }

    public List<ArgoReportDefinitions> argoReportDefinitionsList(){ return argoReportDefinitionsRepository.findAll(); }

    public List<ArgoReportDefinitions> listUsingInnerJoinJPQL(){ return argoReportDefinitionsRepository.listUsingInnerJoinJPQL(); }

}
