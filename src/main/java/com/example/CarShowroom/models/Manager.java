package com.example.CarShowroom.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import org.hibernate.annotations.Cascade;

import java.util.Set;

@Entity
public class Manager extends BaseEntity {
    private int numberOfClients;
    private int skidkaKliyentu;
    private String nameBadge;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    Set<ClientManager> clientManager;

    public Manager(int numberOfClients, int skidkaKliyentu, String nameBadge) {
        this.numberOfClients = numberOfClients;
        this.skidkaKliyentu = skidkaKliyentu;
        this.nameBadge = nameBadge;
    }
    protected Manager(){
    }

    public int getNumberOfClients() {
        return numberOfClients;
    }

    public void setNumberOfClients(int numberOfClients) {
        this.numberOfClients = numberOfClients;
    }

    public int getSkidkaKliyentu() {
        return skidkaKliyentu;
    }

    public void setSkidkaKliyentu(int skidkaKliyentu) {
        this.skidkaKliyentu = skidkaKliyentu;
    }

    public String getNameBadge() {
        return nameBadge;
    }

    public void setNameBadge(String nameBadge) {
        this.nameBadge = nameBadge;
    }

    public Set<ClientManager> getClientManager() {
        return clientManager;
    }

    public void setClientManager(Set<ClientManager> clientManager) {
        this.clientManager = clientManager;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "numberOfClients=" + numberOfClients +
                ", skidkaKliyentu=" + skidkaKliyentu +
                ", nameBadge='" + nameBadge + '\'' +
                ", clientManager=" + clientManager +
                ", id=" + id +
                "} " + super.toString();
    }
}
