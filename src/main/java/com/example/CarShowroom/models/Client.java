package com.example.CarShowroom.models;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.Set;

@Entity
@Table(name = "client")
public class Client extends BaseEntity {
    private int cash;
    private String clientStatus;
    private boolean tradeIn;
    private String name;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "manager_id", referencedColumnName = "id")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<ClientManager> clientManager;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<Car> cars;

    public Client(int cash, String clientStatus, boolean tradeIn) {
        this.cash = cash;
        this.clientStatus = clientStatus;
        this.tradeIn = tradeIn;
    }
    protected Client(){
    }

    public String getClientName() {
        return name;
    }

    public void setClientName(String clientName) {
        this.name = clientName;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public String getClientStatus() {
        return clientStatus;
    }

    public void setClientStatus(String clientStatus) {
        this.clientStatus = clientStatus;
    }

    public boolean isTradeIn() {
        return tradeIn;
    }

    public void setTradeIn(boolean tradeIn) {
        this.tradeIn = tradeIn;
    }

    public Set<ClientManager> getClientManager() {
        return clientManager;
    }

    public void setClientManager(Set<ClientManager> clientManager) {
        this.clientManager = clientManager;
    }

    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "Client{" +
                "cash=" + cash +
                ", clientStatus='" + clientStatus + '\'' +
                ", tradeIn=" + tradeIn +
                ", clientName='" + name + '\'' +
                ", clientManager=" + clientManager +
                ", cars=" + cars +
                ", id=" + id +
                "} " + super.toString();
    }
}
