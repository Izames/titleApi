package com.example.titleapi.controllers;

import com.example.titleapi.DTOModels.*;
import com.example.titleapi.models.MangaModel;
import com.example.titleapi.models.RanobeModel;
import com.example.titleapi.models.TitleModel;
import com.example.titleapi.repository.MangaRepository;
import com.example.titleapi.repository.RanobeRepository;
import com.example.titleapi.repository.TitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api-ranobe")
public class RanobeController {
    @Autowired
    RanobeRepository ranobeRepository;
    @Autowired
    TitleRepository titleRepository;
    @GetMapping
    public List<RanobeTitleDTO> getRanobes(){
        List<RanobeModel> ranobesToGet = ranobeRepository.findAll();
        List<RanobeTitleDTO> ranobeAndTitle = new ArrayList<>();
        for (int i = 0; i< ranobesToGet.size(); i++){
            RanobeModel x = ranobesToGet.get(i);
            TitleModel y = titleRepository.findById(x.getTitle().getID()).orElse(null);
            RanobeModelDTO ranob = new RanobeModelDTO(x.getID(), x.getName(), x.getChapters(), x.getTitle().getID());
            TitleModelDTO titl = new TitleModelDTO(y.getID(), y.getName());
            ranobeAndTitle.add(new RanobeTitleDTO(ranob, titl));
        }
        return ranobeAndTitle;
    }
    @PreAuthorize("hasAuthority('WORKER')")
    @PostMapping
    public String setRanobe(@RequestBody RanobeModelDTO ranobe){
        TitleModel title = titleRepository.findById(ranobe.getTitleID()).orElse(null);
        RanobeModel ranob = new RanobeModel(ranobe.getID(), ranobe.getName(), ranobe.getChapters(), title);
        ranobeRepository.save(ranob);
        return "Success!";
    }
    @PreAuthorize("hasAuthority('WORKER')")
    @PutMapping("/{ID}")
    public String updateRanobe(@PathVariable long ID, @RequestBody RanobeModelDTO ranobe){
        RanobeModel ranob = ranobeRepository.findById(ID).orElse(null);
        ranob.setName(ranobe.getName());
        ranob.setChapters(ranobe.getChapters());
        ranobeRepository.save(ranob);
        return "Success";
    }
    @PreAuthorize("hasAuthority('WORKER')")
    @DeleteMapping("/{ID}")
    public String deleteRanobee(@PathVariable long ID){
        RanobeModel ranobeModel = ranobeRepository.findById(ID).orElse(null);
        TitleModel title = titleRepository.findById(ranobeModel.getTitle().getID()).orElse(null);
        title.getRanobes().remove(ranobeModel);
        titleRepository.save(title);
        ranobeModel.setTitle(null);
        ranobeRepository.save(ranobeModel);
        ranobeRepository.delete(ranobeModel);
        return "Success!";
    }
}
