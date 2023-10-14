package com.example.CarShowroom.services.impl;

import com.example.CarShowroom.dtos.KomplektatsiyaDto;
import com.example.CarShowroom.models.Komplektatsiya;
import com.example.CarShowroom.repositories.KomplektatsiyaRepository;
import com.example.CarShowroom.services.KomplektatsiyaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class KomplektatsiyaServiceImpl implements KomplektatsiyaService {

    @Autowired
    private final KomplektatsiyaRepository komplektatsiyaRepository;

    @Autowired
    private final ModelMapper modelMapper;

    @Autowired
    public KomplektatsiyaServiceImpl(KomplektatsiyaRepository komplektatsiyaRepository, ModelMapper modelMapper) {
        this.komplektatsiyaRepository = komplektatsiyaRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<KomplektatsiyaDto> getAllKomplektatsiyas() {
        List<Komplektatsiya> komplektatsiyas = komplektatsiyaRepository.findAll();
        return komplektatsiyas.stream()
                .map(komplektatsiya -> modelMapper.map(komplektatsiya, KomplektatsiyaDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<KomplektatsiyaDto> getKomplektatsiyaById(int id) {
        Optional<Komplektatsiya> optionalKomplektatsiya = komplektatsiyaRepository.findById(id);
        return optionalKomplektatsiya.map(komplektatsiya -> modelMapper.map(komplektatsiya, KomplektatsiyaDto.class));
    }

    @Override
    public KomplektatsiyaDto createKomplektatsiya(KomplektatsiyaDto komplektatsiyaDto) {
        Komplektatsiya komplektatsiya = modelMapper.map(komplektatsiyaDto, Komplektatsiya.class);
        return modelMapper.map(komplektatsiyaRepository.save(komplektatsiya), KomplektatsiyaDto.class);
    }

    @Override
    public KomplektatsiyaDto updateKomplektatsiya(int id, KomplektatsiyaDto komplektatsiyaDto) {
        Optional<Komplektatsiya> optionalKomplektatsiya = komplektatsiyaRepository.findById(id);
        if (optionalKomplektatsiya.isPresent()) {
            Komplektatsiya komplektatsiya = optionalKomplektatsiya.get();
            modelMapper.map(komplektatsiyaDto, komplektatsiya);
            return modelMapper.map(komplektatsiyaRepository.save(komplektatsiya), KomplektatsiyaDto.class);
        } else {
            return null;
        }
    }

    @Override
    public void deleteKomplektatsiya(int id) {
        komplektatsiyaRepository.deleteById(id);
    }

    @Override
    public List<KomplektatsiyaDto> findKomplektatsiyaByTransmissionType(String transmissionType) {
        List<Komplektatsiya> komplektatsiyas = komplektatsiyaRepository.findKomplektatsiyaByTransmissionType(transmissionType);
        return komplektatsiyas.stream()
                .map(komplektatsiya -> modelMapper.map(komplektatsiya,KomplektatsiyaDto.class))
                .collect(Collectors.toList());
    }
}


