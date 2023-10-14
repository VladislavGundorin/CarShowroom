package com.example.CarShowroom.models;

import jakarta.persistence.*;

@Entity
@IdClass(ClientManagerId.class)
@Table(name = "client_manager")
public class ClientManager {

    @Id
    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;

    @Id
    @ManyToOne
    @JoinColumn(name = "manager_id", referencedColumnName = "id")
    private Manager manager;

    public ClientManager(Client client, Manager manager) {
        this.client = client;
        this.manager = manager;
    }

    protected ClientManager() {

    }
}
