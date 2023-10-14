package com.example.CarShowroom.dtos;

public class KomplektatsiyaDto {
    private int id;
    private String engine;
    private String typeOfConfiguration;
    private String transmissionType;
    private boolean airbag;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public KomplektatsiyaDto(int id, String engine, String typeOfConfiguration, String transmissionType, boolean airbag) {
        this.id = id;
        this.engine = engine;
        this.typeOfConfiguration = typeOfConfiguration;
        this.transmissionType = transmissionType;
        this.airbag = airbag;
    }
    public KomplektatsiyaDto(){

    }

    @Override
    public String toString() {
        return "KomplektatsiyaDto{" +
                "id=" + id +
                ", engine='" + engine + '\'' +
                ", typeOfConfiguration='" + typeOfConfiguration + '\'' +
                ", transmissionType='" + transmissionType + '\'' +
                ", airbag=" + airbag +
                '}';
    }
}
