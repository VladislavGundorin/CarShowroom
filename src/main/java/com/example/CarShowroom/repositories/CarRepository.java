package com.example.CarShowroom.repositories;

import com.example.CarShowroom.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository <Car, Integer> {
    List<Car> findCarsByYearOfReleaseGreaterThan(int yearOfRelease);

    @Query("select c FROM Car c WHERE c.typeOfBody = :typeOfBody")
    List<Car> findCarsByTypeOfBody(@Param("typeOfBody") String typeOfBody);

    @Query("SELECT c FROM Car c JOIN c.carKomplektatsiyas komp WHERE komp.komplektatsiya.transmissionType = :transmissionType")
    List<Car> findAllCarsWithAutomaticTransmission(@Param("transmissionType") String transmissionType);

    Car findCarById(Integer car_id);

}