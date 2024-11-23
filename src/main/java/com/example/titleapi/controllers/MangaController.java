package com.example.titleapi.controllers;

import com.example.titleapi.DTOModels.*;
import com.example.titleapi.models.AnimeModel;
import com.example.titleapi.models.MangaModel;
import com.example.titleapi.models.TitleModel;
import com.example.titleapi.repository.AnimeRepository;
import com.example.titleapi.repository.MangaRepository;
import com.example.titleapi.repository.TitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api-manga")
public class MangaController {
    @Autowired
    MangaRepository mangaRepository;
    @Autowired
    TitleRepository titleRepository;
    @GetMapping
    public List<MangaTitleDTO> getMangas(){
        List<MangaModel> mangasToGet = mangaRepository.findAll();
        List<MangaTitleDTO> mangaAndTitle = new ArrayList<>();
        for (int i = 0; i< mangasToGet.size(); i++){
            MangaModel x = mangasToGet.get(i);
            TitleModel y = titleRepository.findById(x.getTitle().getID()).orElse(null);
            MangaModelDTO mang = new MangaModelDTO(x.getID(), x.getName(), x.getChapters(), x.getTitle().getID());
            TitleModelDTO titl = new TitleModelDTO(y.getID(), y.getName());
            mangaAndTitle.add(new MangaTitleDTO(mang, titl));
        }
        return mangaAndTitle;
    }
    @PreAuthorize("hasAuthority('WORKER')")
    @PostMapping
    public String setManga(@RequestBody MangaModelDTO manga){
        TitleModel title = titleRepository.findById(manga.getTitleID()).orElse(null);
        MangaModel mang = new MangaModel(manga.getID(), manga.getName(), manga.getChapters(), title);
        mangaRepository.save(mang);
        return "Success!";
    }
    @PreAuthorize("hasAuthority('WORKER')")
    @PutMapping("/{ID}")
    public String updateManga(@PathVariable long ID, @RequestBody MangaModelDTO manga){
        MangaModel mang = mangaRepository.findById(ID).orElse(null);
        mang.setName(manga.getName());
        mang.setChapters(manga.getChapters());
        mangaRepository.save(mang);
        return "Success";
    }
    @PreAuthorize("hasAuthority('WORKER')")
    @DeleteMapping("/{ID}")
    public String deleteManga(@PathVariable long ID){
        MangaModel mangaModel = mangaRepository.findById(ID).orElse(null);
        TitleModel title = titleRepository.findById(mangaModel.getTitle().getID()).orElse(null);
        title.getMangas().remove(mangaModel);
        titleRepository.save(title);
        mangaModel.setTitle(null);
        mangaRepository.save(mangaModel);
        mangaRepository.delete(mangaModel);
        return "Success!";
    }
}
