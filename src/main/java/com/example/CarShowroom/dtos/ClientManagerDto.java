package com.example.CarShowroom.dtos;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

public class ClientManagerDto {
    private ClientDto client;
    private ManagerDto manager;

    public ClientManagerDto(ClientDto client, ManagerDto manager) {
        this.client = client;
        this.manager = manager;
    }

    public ClientManagerDto() {
    }

    public ClientDto getClient() {
        return client;
    }

    public void setClient(ClientDto client) {
        this.client = client;
    }

    public ManagerDto getManager() {
        return manager;
    }

    public void setManager(ManagerDto manager) {
        this.manager = manager;
    }

    @Override
    public String toString() {
        return "ClientManagerDto{" +
                "client=" + client +
                ", manager=" + manager +
                '}';
    }
}
