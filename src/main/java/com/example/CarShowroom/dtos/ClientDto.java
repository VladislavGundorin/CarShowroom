package com.example.CarShowroom.dtos;

public class ClientDto {
    private int id;
    private int cash;
    private String clientStatus;
    private boolean tradeIn;
    private String clientName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCash() {
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

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public ClientDto(int id, int cash, String clientStatus, boolean tradeIn, String clientName) {
        this.id = id;
        this.cash = cash;
        this.clientStatus = clientStatus;
        this.tradeIn = tradeIn;
        this.clientName = clientName;
    }
    public ClientDto(){

    }

    @Override
    public String toString() {
        return "ClientDto{" +
                "id=" + id +
                ", cash=" + cash +
                ", clientStatus='" + clientStatus + '\'' +
                ", tradeIn=" + tradeIn +
                ", clientName='" + clientName + '\'' +
                '}';
    }
}
