package com.example.CarShowroom.controllers.Komplektatsiya;

import com.example.CarShowroom.dtos.KomplektatsiyaDto;
import com.example.CarShowroom.services.KomplektatsiyaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class KomplektatsiyaController {

    private final KomplektatsiyaService komplektatsiyaService;

    @Autowired
    public KomplektatsiyaController(KomplektatsiyaService komplektatsiyaService) {
        this.komplektatsiyaService = komplektatsiyaService;
    }

    @GetMapping("/komplektatsiyas")
    public List<KomplektatsiyaDto> getAllKomplektatsiyas() {
        return komplektatsiyaService.getAllKomplektatsiyas();
    }

    @GetMapping("/komplektatsiyas/{id}")
    public KomplektatsiyaDto getKomplektatsiyaById(@PathVariable int id) {
        return komplektatsiyaService.getKomplektatsiyaById(id).orElseThrow(() -> new KomplektatsiyaNotFoundExeption(id));
    }

    @PostMapping("/komplektatsiyas")
    public KomplektatsiyaDto createKomplektatsiya(@RequestBody KomplektatsiyaDto komplektatsiyaDto) {
        return komplektatsiyaService.createKomplektatsiya(komplektatsiyaDto);
    }

    @PutMapping("/komplektatsiyas/{id}")
    public KomplektatsiyaDto updateKomplektatsiya(@PathVariable int id, @RequestBody KomplektatsiyaDto komplektatsiyaDto) {
        komplektatsiyaDto.setId(id);
        return komplektatsiyaService.updateKomplektatsiya(id, komplektatsiyaDto);
    }

    @DeleteMapping("/komplektatsiyas/{id}")
    public void deleteKomplektatsiya(@PathVariable int id) {
        komplektatsiyaService.deleteKomplektatsiya(id);
    }

    @GetMapping("/komplektatsiyas/transmission/{transmissionType}")
    public List<KomplektatsiyaDto> findKomplektatsiyaByTransmissionType(@PathVariable String transmissionType) {
        return komplektatsiyaService.findKomplektatsiyaByTransmissionType(transmissionType);
    }

}
