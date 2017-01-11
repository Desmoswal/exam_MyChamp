/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myChamp.GUI.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import myChamp.BE.Group;
import myChamp.BE.Groups;
import myChamp.BE.Match;
import myChamp.BE.Team;
import myChamp.BLL.Manager;
import myChamp.BLL.SaveManager;

/**
 *
 * @author Desmoswal
 */
public class MyChampModel
{
    private Manager manager = new Manager();
    private SaveManager saveManager = new SaveManager();
    
    public void addNewTeam(String name) {
        manager.addNewTeam(name);
    }
    
    public ArrayList<Team> getTeams() {
        return manager.getTeams();
    }
    
    public void saveTeams(List<Team> teamList)  {
        saveManager.saveTeams(teamList);
    }
    
    public List<Team> getTeamsFromFile() {
        return saveManager.getTeams();
    }
    
    public void saveGroups(List<Group> groupList) {
        saveManager.saveGroups(groupList);
    }
    
    public List<Group> getGroups() {
        return manager.getGroups();
    }
    public List<Group> getGroupsFromFile() {
        return saveManager.getGroups();
    }
    
    public void removeTeam(Team team) {
        manager.removeTeam(team);
    }
    
    public List<Match> getMatches() {
        return manager.getMatches();
    }
}
