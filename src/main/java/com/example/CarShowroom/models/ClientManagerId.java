package com.example.CarShowroom.models;

import java.io.Serializable;
import java.util.Objects;

public class ClientManagerId implements Serializable {

    private int client;
    private int manager;

    public ClientManagerId() {

    }

    public ClientManagerId(int client, int manager) {
        this.client = client;
        this.manager = manager;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClientManagerId)) return false;
        ClientManagerId that = (ClientManagerId) o;
        return client == that.client &&
                manager == that.manager;
    }

    @Override
    public int hashCode() {
        return Objects.hash(client, manager);
    }
}
