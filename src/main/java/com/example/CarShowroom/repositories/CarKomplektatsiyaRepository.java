package com.example.CarShowroom.repositories;

import com.example.CarShowroom.models.CarKomplektatsiya;
import com.example.CarShowroom.models.CarKomplektatsiyaId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CarKomplektatsiyaRepository extends JpaRepository<CarKomplektatsiya, CarKomplektatsiyaId> {
}
