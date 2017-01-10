/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myChamp.BE;

/**
 *
 * @author Kristof
 */
public class Match {
    private Team homeTeam;
    private Team guestTeam;
    private int homeTeamGoals = 0;
    private int guestTeamGoals = 0;
    
    public Match(Team homeTeam, Team guestTeam) {
        this.homeTeam = homeTeam;
        this.guestTeam = guestTeam;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public Team getGuestTeam() {
        return guestTeam;
    }

    public int getHomeTeamGoals() {
        return homeTeamGoals;
    }

    public int getGuestTeamGoals() {
        return guestTeamGoals;
    }

    public void setHomeTeamGoals(int homeTeamGoals) {
        this.homeTeamGoals = homeTeamGoals;
    }

    public void setGuestTeamGoals(int guestTeamGoals) {
        this.guestTeamGoals = guestTeamGoals;
    }
    
    
}
