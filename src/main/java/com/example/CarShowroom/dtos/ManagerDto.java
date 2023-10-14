package com.example.CarShowroom.dtos;

public class ManagerDto {
    private int id;
    private int numberOfClients;
    private int skidkaKliyentu;
    private String nameBadge;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public ManagerDto(int id, int numberOfClients, int skidkaKliyentu, String nameBadge) {
        this.id = id;
        this.numberOfClients = numberOfClients;
        this.skidkaKliyentu = skidkaKliyentu;
        this.nameBadge = nameBadge;
    }
    public ManagerDto(){

    }

    @Override
    public String toString() {
        return "ManagerDto{" +
                "id=" + id +
                ", numberOfClients=" + numberOfClients +
                ", skidkaKliyentu=" + skidkaKliyentu +
                ", nameBadge='" + nameBadge + '\'' +
                '}';
    }
}
