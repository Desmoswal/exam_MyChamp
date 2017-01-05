/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myChamp.BLL;

import myChamp.BE.Group;
import myChamp.BE.Groups;
import myChamp.BE.Teams;
import myChamp.BE.Team;
import myChamp.DAL.FileManager;
import myChamp.DAL.TextFileHandler;
import java.util.List;

/**
 *  Connected to the BusinessEntities and to the Data Access Layer
 * and helps saving and reading from files.
 * @author Desmoswal
 */
public class SaveManager
{
    private FileManager fileManager = new TextFileHandler();
    
    public void saveTeams(List<Team> teamList)
    {
        fileManager.saveTeams(teamList);
    }
    
    public List<Team> getTeams()
    {
        return fileManager.getTeams();
    }
    
    public void saveGroups(List<Groups> groupList)
    {
        fileManager.saveGroups(groupList);
    }
    
    public List<Groups> getGroups()
    {
        return fileManager.getGroups();
    }
    
}
