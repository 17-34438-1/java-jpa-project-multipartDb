package com.example.multipleds.Controller;

import com.example.multipleds.Model.cchaportdb.VehicleFeesReg;
import com.example.multipleds.Model.commonN4.ArgoCalEventType;
import com.example.multipleds.Model.commonN4.ArgoReportDefinitions;
import com.example.multipleds.Model.oracle.ActiveMqLock;
import com.example.multipleds.Model.sparcsn4.InvUnit;
import com.example.multipleds.Model.sparcsn4.InvUnitFcyVisit;
import com.example.multipleds.Service.MultiDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/db")
public class multiDBController {
    @Autowired
    private MultiDBService multiDBService;

    @GetMapping("/findById/{id}/{transitStatus}")
    public ResponseEntity<List<InvUnit>> findById(@PathVariable String id, @PathVariable String transitStatus){
        List<InvUnit> list = multiDBService.findById(id,transitStatus);
        return new ResponseEntity<List<InvUnit>>(list, HttpStatus.OK);
    }

    @GetMapping("/findByTransitStateAndId/{transitStatus}/{id}")
    public ResponseEntity<List<InvUnitFcyVisit>> findByTransitStateAndId(@PathVariable String transitStatus, @PathVariable String id){
        List<InvUnitFcyVisit> list = multiDBService.findByTransitStateAndId(transitStatus,id);
        return new ResponseEntity<List<InvUnitFcyVisit>>(list, HttpStatus.OK);
    }

    @GetMapping("/vehicleFeesReg/list")
    public ResponseEntity<List<VehicleFeesReg>> vehicleFeesRegList(){
        List<VehicleFeesReg> vehicleFeesRegList = multiDBService.vehicleFeesRegList();
        return new ResponseEntity<List<VehicleFeesReg>>(vehicleFeesRegList,HttpStatus.OK);
    }

    @GetMapping("/activeMqLock/list")
    public ResponseEntity<List<ActiveMqLock>> activeMqLockList(){
        List<ActiveMqLock> activeMqLockList = multiDBService.activeMqLockList();
        return new ResponseEntity<List<ActiveMqLock>>(activeMqLockList,HttpStatus.OK);
    }

    @GetMapping("/argoCalEventType/list")
    public ResponseEntity<List<ArgoCalEventType>> argoCalEventTypes(){
        List<ArgoCalEventType> argoCalEventTypes = multiDBService.argoCalEventTypes();
        return new ResponseEntity<List<ArgoCalEventType>>(argoCalEventTypes,HttpStatus.OK);
    }

    @GetMapping("/argoCalEventType/listUsingJPQL")
    public ResponseEntity<List<ArgoCalEventType>> argoCalEventTypesUsingJPQL(){
        List<ArgoCalEventType> argoCalEventTypes = multiDBService.argoCalEventTypesUsingJPQL();
        return new ResponseEntity<List<ArgoCalEventType>>(argoCalEventTypes,HttpStatus.OK);
    }

    @GetMapping("/argoCalEventType/highestGkey")
    public Integer highestArgoCalEventTypeGkey(){
        return multiDBService.highestArgoCalEventTypeGkey();
    }

    @GetMapping("/argoReportDefinition/list")
    public ResponseEntity<List<ArgoReportDefinitions>> argoReportDefinitionList(){
        List<ArgoReportDefinitions> argoReportDefinitions = multiDBService.argoReportDefinitionsList();
        return new ResponseEntity<List<ArgoReportDefinitions>>(argoReportDefinitions,HttpStatus.OK);
    }

    @GetMapping("/argoReportDefinition/list/jpql/innerjoin")
    public ResponseEntity<List<ArgoReportDefinitions>> listUsingInnerJoinJPQL(){
        List<ArgoReportDefinitions> argoReportDefinitions = multiDBService.listUsingInnerJoinJPQL();
        return new ResponseEntity<List<ArgoReportDefinitions>>(argoReportDefinitions,HttpStatus.OK);
    }




}
