package com.example.multipleds.Model.commonN4;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "argo_report_defn_roles_map")
public class ArgoReportDefinitionRolesMap {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long repdefrole_gkey;

    @Column(name = "role_gkey")
    private Long roleGkey;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "report_definition_gkey") //setting the name of the joining column
    private ArgoReportDefinitions argoReportDefinitions;

}
