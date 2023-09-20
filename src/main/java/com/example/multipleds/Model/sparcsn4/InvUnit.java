package com.example.multipleds.Model.sparcsn4;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "inv_unit")
public class InvUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long gkey;

    @Column(name = "ID")
    private String id;

    @OneToMany(mappedBy = "invUnit",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<InvUnitFcyVisit> invUnitFcyVisit = new ArrayList<>();
}
