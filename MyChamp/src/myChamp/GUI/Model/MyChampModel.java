/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myChamp.GUI.Model;

import java.util.ArrayList;
import java.util.List;
import myChamp.BE.Groups;
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
    
    public void saveGroups(List<Groups> groupList) {
        saveManager.saveGroups(groupList);
    }
    
    public List<Groups> getGroups() {
        return saveManager.getGroups();
    }
}
