package com.example.CarShowroom.dtos;

public class CarDto {
    private int id;
    private String carBrand;
    private String typeOfBody;
    private int yearOfRelease;
    private String producingCountry;
    private int price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public CarDto(int id, String carBrand, String typeOfBody, int yearOfRelease, String producingCountry, int price) {
        this.id = id;
        this.carBrand = carBrand;
        this.typeOfBody = typeOfBody;
        this.yearOfRelease = yearOfRelease;
        this.producingCountry = producingCountry;
        this.price = price;
    }
    public CarDto(){

    }

    @Override
    public String toString() {
        return "CarDto{" +
                "id=" + id +
                ", carBrand='" + carBrand + '\'' +
                ", typeOfBody='" + typeOfBody + '\'' +
                ", yearOfRelease=" + yearOfRelease +
                ", producingCountry='" + producingCountry + '\'' +
                ", price=" + price +
                '}';
    }
}
