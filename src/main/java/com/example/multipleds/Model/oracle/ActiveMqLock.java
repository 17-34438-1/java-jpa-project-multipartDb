package com.example.multipleds.Model.oracle;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "ACTIVEMQ_LOCK")
public class ActiveMqLock {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "TIME")
    private Long time;

    @Column(name = "BROKER_NAME")
    private String brokerTime;
}
