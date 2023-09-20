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
@Table(name = "argo_cal_event_type")
public class ArgoCalEventType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long gkey;

    @Column(name = "name")
    private String name;

    @Column(name = "partial_day")
    private String partial_day;

    @Column(name = "description")
    private String description;
}
