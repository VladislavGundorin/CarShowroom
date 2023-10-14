package com.example.CarShowroom.models;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "car")
public class Car extends BaseEntity {
    private String carBrand;
    private String typeOfBody;
    private int yearOfRelease;
    private String producingCountry;
    private int price;

    @OneToMany(mappedBy = "car", fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<CarKomplektatsiya> carKomplektatsiyas;

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Client client;

    public Car(String carBrand, String typeOfBody, int yearOfRelease, String producingCountry, int price) {
        this.carBrand = carBrand;
        this.typeOfBody = typeOfBody;
        this.yearOfRelease = yearOfRelease;
        this.producingCountry = producingCountry;
        this.price = price;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getTypeOfBody() {
        return typeOfBody;
    }

    public void setTypeOfBody(String typeOfBody) {
        this.typeOfBody = typeOfBody;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public String getProducingCountry() {
        return producingCountry;
    }

    public void setProducingCountry(String producingCountry) {
        this.producingCountry = producingCountry;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Set<CarKomplektatsiya> getCarKomplektatsiyas() {
        return carKomplektatsiyas;
    }

    public void setCarKomplektatsiyas(Set<CarKomplektatsiya> carKomplektatsiyas) {
        this.carKomplektatsiyas = carKomplektatsiyas;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    protected Car() {
    }

    @Override
    public String toString() {
        return "Car{" +
                "carBrand='" + carBrand + '\'' +
                ", typeOfBody='" + typeOfBody + '\'' +
                ", yearOfRelease=" + yearOfRelease +
                ", producingCountry='" + producingCountry + '\'' +
                ", price=" + price +
                ", carKomplektatsiyas=" + carKomplektatsiyas +
                ", id=" + id +
                "} " + super.toString();
    }
}
