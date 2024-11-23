package com.example.titleapi.controllers;

import com.example.titleapi.DTOModels.FioModelDTO;
import com.example.titleapi.models.FioModel;
import com.example.titleapi.repository.FioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api-fio")
public class FioController {
    @Autowired
    private FioRepository fioRepository;
    @PreAuthorize("hasAuthority('WORKER')")
    @PostMapping
    public String createFio(@RequestBody FioModelDTO fioDTO){
        FioModel fioModel = new FioModel(0, fioDTO.getName(), fioDTO.getSurname(), fioDTO.getLastname(), null);
        fioRepository.save(fioModel);
        return "success";
    }
    @GetMapping
    public List<FioModelDTO> readFio(){
        List<FioModel> fios = fioRepository.findAll();
        List<FioModelDTO> fiosDTo = new ArrayList<>();
        for (int i = 0; i< fios.size(); i++){
            FioModel fio = fios.get(i);
            FioModelDTO fioDTo = new FioModelDTO(fio.getID(), fio.getName(), fio.getSurname(), fio.getLastname());
            fiosDTo.add(fioDTo);
        }
        return fiosDTo;
    }
    @PreAuthorize("hasAuthority('WORKER')")
    @PutMapping("/{ID}")
    public String updateFio(@PathVariable long ID, @RequestBody FioModelDTO fioDTO){
        FioModel fio = fioRepository.findById(ID).orElse(null);
        fio.setName(fioDTO.getName());
        fio.setSurname(fioDTO.getSurname());
        fio.setLastname(fioDTO.getLastname());
        fioRepository.save(fio);
        return "success!";
    }
    @PreAuthorize("hasAuthority('WORKER')")
    @DeleteMapping("/{ID}")
    public String deleteFio(@PathVariable long ID){
        FioModel fio = fioRepository.findById(ID).orElse(null);
        fioRepository.delete(fio);;
        return "success!";
    }
}
