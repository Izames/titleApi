package com.example.titleapi.controllers;

import com.example.titleapi.DTOModels.*;
import com.example.titleapi.models.*;
import com.example.titleapi.repository.MangaRepository;
import com.example.titleapi.repository.TitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api-title")
public class TitleController {
    @Autowired
    private TitleRepository titleRepository;
    @PreAuthorize("hasAuthority('WORKER')")
    @PostMapping
    public String createTitle(@RequestBody TitleModelDTO titleModelDTO){
        TitleModel title = new TitleModel(0, titleModelDTO.getName(), null, null, null, null, null);
        titleRepository.save(title);
        return "success!";
    }
    @GetMapping
    public List<TitleModelDTO> getTitles(){
        List<TitleModelDTO> tmara = new ArrayList<>();
        List<TitleModel> titlesGet = titleRepository.findAll();
        for (int i = 0; i<titlesGet.size(); i++){
            TitleModel title = titlesGet.get(i);
            TitleModelDTO titleDTO = new TitleModelDTO(title.getID(), title.getName());
            tmara.add(titleDTO);
        }
        return tmara;
    }
    @PreAuthorize("hasAuthority('WORKER')")
    @PutMapping("/{ID}")
    public String updateTitle(@PathVariable long ID, @RequestBody TitleModelDTO title){
        TitleModel titleModel = titleRepository.findById(ID).orElse(null);
        titleModel.setName(title.getName());
        titleRepository.save(titleModel);
        return "success!";
    }
    @PreAuthorize("hasAuthority('WORKER')")
    @DeleteMapping("/{ID}")
    public String deleteTitle(@PathVariable long ID){
        TitleModel title = titleRepository.findById(ID).orElse(null);
        titleRepository.delete(title);
        return "success!";
    }
}
