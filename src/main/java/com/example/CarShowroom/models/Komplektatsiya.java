package com.example.CarShowroom.models;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import org.hibernate.annotations.Cascade;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "komplektatsiya")
public class Komplektatsiya extends BaseEntity {
    private String engine;
    private String typeOfConfiguration;
    private String transmissionType;
    private boolean airbag;

    @OneToMany(mappedBy = "komplektatsiya", fetch = FetchType.LAZY)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<CarKomplektatsiya> carKomplektatsiyas;

    public Komplektatsiya(String engine, String typeOfConfiguration, String transmissionType, boolean airbag) {
        this.engine = engine;
        this.typeOfConfiguration = typeOfConfiguration;
        this.transmissionType = transmissionType;
        this.airbag = airbag;
    }

    protected Komplektatsiya() {
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getTypeOfConfiguration() {
        return typeOfConfiguration;
    }

    public void setTypeOfConfiguration(String typeOfConfiguration) {
        this.typeOfConfiguration = typeOfConfiguration;
    }

    public String getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(String transmissionType) {
        this.transmissionType = transmissionType;
    }

    public boolean isAirbag() {
        return airbag;
    }

    public void setAirbag(boolean airbag) {
        this.airbag = airbag;
    }

    public Set<CarKomplektatsiya> getCarKomplektatsiyas() {
        return carKomplektatsiyas;
    }

    public void setCarKomplektatsiyas(Set<CarKomplektatsiya> carKomplektatsiyas) {
        this.carKomplektatsiyas = carKomplektatsiyas;
    }

    public void addCarKomplektatsiya(CarKomplektatsiya carKomplektatsiya) {
        if (this.carKomplektatsiyas == null) {
            this.carKomplektatsiyas = new HashSet<>();
        }
        this.carKomplektatsiyas.add(carKomplektatsiya);
    }

    @Override
    public String toString() {
        return "Komplektatsiya{" +
                "engine='" + engine + '\'' +
                ", typeOfConfiguration='" + typeOfConfiguration + '\'' +
                ", transmissionType='" + transmissionType + '\'' +
                ", airbag=" + airbag +
                ", carKomplektatsiyas=" + carKomplektatsiyas +
                ", id=" + id +
                "} " + super.toString();
    }
}
