package com.example.multipleds.Model.commonN4;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "argo_report_definitions")
public class ArgoReportDefinitions {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long gkey;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "title")
    private String title;

    @Column(name = "design_gkey")
    private Long designGkey;

    @Column(name = "output_type")
    private String outputType;

    @Column(name = "filter_gkey")
    private Long filterGkey;

    @Column(name = "sort_field_1")
    private String sortFieldOne;

    @Column(name = "sort_field_1_order")
    private String sortFieldOneOrder;

    @Column(name = "sort_field_2")
    private String sortFieldTwo;

    @Column(name = "sort_field_2_order")
    private String sortFieldTwoOrder;

    @Column(name = "sort_field_3")
    private String sortFieldThree;

    @Column(name = "sort_field_3_order")
    private String sortFieldThreeOrder;

    @Column(name = "user_gkey")
    private Long userGkey;

    @Column(name = "created")
    private Date created;

    @Column(name = "creator")
    private String creator;

    @Column(name = "changed")
    private Date changed;

    @Column(name = "changer")
    private String changer;

    @OneToMany(mappedBy = "argoReportDefinitions",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ArgoReportDefinitionRolesMap> argoReportDefinitionRolesMaps = new ArrayList<>();

}
