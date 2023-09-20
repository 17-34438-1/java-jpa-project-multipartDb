package com.example.multipleds.Model.cchaportdb;

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
@Table(name = "vehicle_fees_reg")
public class VehicleFeesReg {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "veh_type")
    private String vehicleType;

    @Column(name = "veh_charge")
    private String vehicleCharge;

    @Column(name = "vat")
    private String vat;

    @Column(name = "vat_amount")
    private String vatAmount;

    @Column(name = "tot_amount")
    private String totalAmount;

    @Column(name = "login_id")
    private String loginId;

}
