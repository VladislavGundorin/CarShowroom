package com.example.CarShowroom.repositories;

import com.example.CarShowroom.dtos.KomplektatsiyaDto;
import com.example.CarShowroom.models.Car;
import com.example.CarShowroom.models.Komplektatsiya;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KomplektatsiyaRepository extends JpaRepository <Komplektatsiya, Integer> {
    List<Komplektatsiya> findKomplektatsiyaByTransmissionType(String Type);

    Komplektatsiya findKomplektatsiyaById(Integer komplektatsiyaId);
}
