package com.example.titleapi.controllers;

import com.example.titleapi.DTOModels.AnimeModelDTO;
import com.example.titleapi.DTOModels.AnimeTitleDto;
import com.example.titleapi.DTOModels.TitleModelDTO;
import com.example.titleapi.models.AnimeModel;
import com.example.titleapi.models.TitleModel;
import com.example.titleapi.repository.AnimeRepository;
import com.example.titleapi.repository.TitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api-anime")
public class AnimeController {
    @Autowired
    AnimeRepository animeRepository;
    @Autowired
    TitleRepository titleRepository;
    @GetMapping
    public List<AnimeTitleDto> getAnimes(){
        List<AnimeModel> animesToGet = animeRepository.findAll();
        List<AnimeTitleDto> animeAndTitle = new ArrayList<>();
        for (int i = 0; i< animeRepository.findAll().size(); i++){
            AnimeModel x = animesToGet.get(i);
            TitleModel y = titleRepository.findById(x.getTitle().getID()).orElse(null);
            AnimeModelDTO anim = new AnimeModelDTO(x.getID(), x.getName(), x.getSeasons(), x.getEpisodes(), x.getTitle().getID());
            TitleModelDTO titl = new TitleModelDTO(y.getID(), y.getName());
            animeAndTitle.add(new AnimeTitleDto(anim, titl));
        }
        return animeAndTitle;
    }
    @PreAuthorize("hasAuthority('WORKER')")
    @PostMapping
    public String setAnimes(@RequestBody AnimeModelDTO anime){
        TitleModel title = titleRepository.findById(anime.getTitleID()).orElse(null);
        AnimeModel anim = new AnimeModel(anime.getID(),anime.getName(), anime.getSeasons(), anime.getEpisodes(), title);
        animeRepository.save(anim);
        return "Success!";
    }
    @PreAuthorize("hasAuthority('WORKER')")
    @PutMapping("/{ID}")
    public String updateAnime(@PathVariable long ID, @RequestBody AnimeModelDTO anime){
        AnimeModel anim = animeRepository.findById(ID).orElse(null);
        anim.setName(anime.getName());
        anim.setEpisodes(anime.getEpisodes());
        anim.setSeasons(anime.getSeasons());
        animeRepository.save(anim);
        return "Success";
    }
    @PreAuthorize("hasAuthority('WORKER')")
    @DeleteMapping("/{ID}")
    public String deleteAnime(@PathVariable long ID){
        AnimeModel animeModel = animeRepository.findById(ID).orElse(null);
        TitleModel title = titleRepository.findById(animeModel.getTitle().getID()).orElse(null);
        title.getAnimes().remove(animeModel);
        System.out.println(title.getAnimes().size());
        titleRepository.save(title);
        animeModel.setTitle(null);
        animeRepository.save(animeModel);
        animeRepository.delete(animeModel);
        return "Success!";
    }
}
