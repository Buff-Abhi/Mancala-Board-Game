package com.example.springboottutorial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DemoController {
    @Autowired
    public GameRepository gameRepository;

    @Autowired
    private MongoOperations mongoOperations;

    @GetMapping("beadcount")
    public Game getBeadCount() {
        List<Game> l = gameRepository.findAll();
        Game l2 = l.get((l.size()-1));
        int maxId = l2.getGameId();
        Query query = Query.query(Criteria.where("gameId").is(maxId));
        return mongoOperations.findOne(query, Game.class);
    }

    @GetMapping("/refreshrepository")
    public void refreshRepository() {
        gameRepository.deleteAll();
        Game g = new Game(1);
        gameRepository.save(g);
    }

    @PostMapping("/gameaction")
    public void gameAction(@RequestParam(required = false) String cupId) {
        List<Game> l = gameRepository.findAll();
        int l2;
        if(l.isEmpty()){
            l2 = 0;
        }
        else {
            l2 = l.get((l.size()-1)).getGameId();
        }

        Game g = new Game(l2+1);
        g.playGame(cupId);
        gameRepository.save(g);
    }
}