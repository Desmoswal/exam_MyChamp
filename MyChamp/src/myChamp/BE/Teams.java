/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myChamp.BE;

import java.util.ArrayList;

/**
 *
 * @author Kristof
 */
public class Teams {
    
    private ArrayList<Team> teams = new ArrayList<>();
    private static Teams self;
    
    private Teams() {
        
    }
    
    public static Teams getInstance() {
        if(self == null) {
            self = new Teams();
        }
        return self;
    }

    public ArrayList<Team> getTeams() {
        return teams;
    }

    public void setTeams(ArrayList<Team> teams) {
        this.teams = teams;
    }

    public void addTeam(Team team) {
        this.teams.add(team);
    }
}
