package com.thecodeschool.security.service;

import com.thecodeschool.security.model.Scoreboard;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ScoreboardService {
    public List<Scoreboard> fetchScoreboard() {
        List<Scoreboard> scoreboardList = new ArrayList<>();
        Random random = new Random();
        for(int i=0; i<11; i++) {
            Scoreboard scoreboard = new Scoreboard();
            scoreboard.setPlayerName("player"+i);
            scoreboard.setScore(random.ints(0, 100).findFirst().getAsInt());
            scoreboardList.add(scoreboard);
        }

        return scoreboardList;
    }
}
