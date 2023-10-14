package com.example.CarShowroom.models;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

@Entity
@IdClass(CarKomplektatsiyaId.class)
@Table(name = "car_komplektatsiya")
public class CarKomplektatsiya {
    @Basic
    @Column(insertable=false, updatable=false)
    private int car_id;
    @Basic
    @Column(insertable=false, updatable=false)
    private int komplektatsiy_id;
    @Id
    @ManyToOne
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Car car;

    @Id
    @ManyToOne
    @JoinColumn(name = "komplektatsiy_id", referencedColumnName = "id")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Komplektatsiya komplektatsiya;

    public CarKomplektatsiya(Car car, Komplektatsiya komplektatsiya) {
        this.car = car;
        this.komplektatsiya = komplektatsiya;
    }

    protected CarKomplektatsiya() {

    }
}
