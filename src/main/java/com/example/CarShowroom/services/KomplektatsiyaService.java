package com.example.CarShowroom.services;

import com.example.CarShowroom.dtos.KomplektatsiyaDto;
import com.example.CarShowroom.models.Komplektatsiya;

import java.util.List;
import java.util.Optional;

public interface KomplektatsiyaService {
    List<KomplektatsiyaDto> getAllKomplektatsiyas();

    Optional<KomplektatsiyaDto> getKomplektatsiyaById(int id);

    KomplektatsiyaDto createKomplektatsiya (KomplektatsiyaDto komplektatsiyaDto);

    KomplektatsiyaDto updateKomplektatsiya(int id, KomplektatsiyaDto komplektatsiyaDto);

    void deleteKomplektatsiya(int id);

    List<KomplektatsiyaDto> findKomplektatsiyaByTransmissionType(String transmissionType);
}
