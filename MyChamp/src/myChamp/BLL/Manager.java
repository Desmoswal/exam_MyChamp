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
import myChamp.BE.Team;
import myChamp.BE.Teams;

/**
 *
 * @author Kristof
 */
public class Manager {
    private final Teams teams = Teams.getInstance();
    private final Groups groups = Groups.getInstance();
    
    public void addNewTeam(String name) {
        teams.addTeam(new Team(name));
    }
    
    public ArrayList<Team> getTeams() {
        return teams.getTeams();
    }
    
    public void removeTeam(Team team) {
        teams.getTeams().remove(team);
    }
    
    public List<Group> getGroups() {
        return groups.getGroups();
    }
}
