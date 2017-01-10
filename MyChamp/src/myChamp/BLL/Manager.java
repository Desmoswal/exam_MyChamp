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
    
    public void addNewTeam(String name) {
        Teams.getInstance().addTeam(new Team(name));
    }
    
    public ArrayList<Team> getTeams() {
        return Teams.getInstance().getTeams();
    }
    
    public void removeTeam(Team team) {
        Teams.getInstance().getTeams().remove(team);
    }
    
    public List<Group> getGroups() {
        return Groups.getInstance().getGroups();
    }
}
