/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myChamp.BLL;

import java.util.ArrayList;
import java.util.List;
import myChamp.BE.Group;
import myChamp.BE.Groups;
import myChamp.BE.Match;
import myChamp.BE.Matches;
import myChamp.BE.Team;
import myChamp.BE.Teams;

/**
 *
 * @author Kristof
 */
public class Manager {
    
    /** Adds a new team in BE */
    public void addNewTeam(String name) {
        Teams.getInstance().addTeam(new Team(name));
    }
    
    /** Returns an ArrayList of teams in program (RAM) */
    public ArrayList<Team> getTeams() {
        return Teams.getInstance().getTeams();
    }
    
    /** Removes team from program (RAM) */
    public void removeTeam(Team team) {
        Teams.getInstance().getTeams().remove(team);
    }
    
    /** Returns a List of groups in program (RAM) */
    public List<Group> getGroups() {
        return Groups.getInstance().getGroups();
    }
    
    /** Returns a List of matches in program (RAM) */
    public List<Match> getMatches() {
        return Matches.getInstance().getMatches();
    }
}
