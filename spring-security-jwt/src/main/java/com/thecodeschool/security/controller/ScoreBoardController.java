package com.thecodeschool.security.controller;

import com.thecodeschool.security.model.Scoreboard;
import com.thecodeschool.security.service.ScoreboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ScoreBoardController {

    @Autowired
    ScoreboardService scoreboardService;

    @GetMapping("/scoreboard")
    public ResponseEntity<List<Scoreboard>> scoreboard() {
        List<Scoreboard> scoreboardList = scoreboardService.fetchScoreboard();
        return ResponseEntity.ok(scoreboardList);
    }
}
