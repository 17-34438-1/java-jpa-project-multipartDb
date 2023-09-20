package com.example.multipleds.Repository.commonN4;

import com.example.multipleds.Model.commonN4.ArgoReportDefinitions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ArgoReportDefinitionsRepository extends JpaRepository<ArgoReportDefinitions,Long> {

    @Query("SELECT d FROM ArgoReportDefinitionRolesMap e INNER JOIN e.argoReportDefinitions d")
    List<ArgoReportDefinitions> listUsingInnerJoinJPQL();

}
