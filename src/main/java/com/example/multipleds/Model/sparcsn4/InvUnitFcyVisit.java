package com.example.multipleds.Model.sparcsn4;

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
@Table(name = "inv_unit_fcy_visit")
public class InvUnitFcyVisit {
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long gkey;

    @Column(name = "transit_state")
    private String transitState;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "unit_gkey") //setting the name of the joining column
    private InvUnit invUnit;
}
