/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myChamp.BE;

import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * @author Desmoswal
 */
public class Team
{
    private String name;
    private int score;
    private Group group;
    private int goals;
    private int matchesPlayed;
    private ArrayList<Team> playedTeams;
    private boolean isHome;
    private final UUID uuid;

    public Team(String name, UUID uuid) {
        this.name = name;
        this.uuid = uuid;
    }
    
    public Team(String name) {
        this.name = name;
        this.uuid = UUID.randomUUID();
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public void setMatchesPlayed(int matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }

    public void setIsHome(boolean isHome) {
        this.isHome = isHome;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public Group getGroup() {
        return group;
    }

    public int getGoals() {
        return goals;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public ArrayList<Team> getPlayedTeams() {
        return playedTeams;
    }

    public boolean isIsHome() {
        return isHome;
    }
}
