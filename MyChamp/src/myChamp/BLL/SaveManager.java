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
import myChamp.BE.Match;

/**
 *  Connected to the BusinessEntities and to the Data Access Layer
 * and helps saving and reading from files.
 * @author Desmoswal
 */
public class SaveManager
{
    private FileManager fileManager = new TextFileHandler();
    
    /** Saves a given list of Team in a textfile */
    public void saveTeams(List<Team> teamList)
    {
        fileManager.saveTeams(teamList);
    }
    
    /** Returns a List of teams from the textfile */
    public List<Team> getTeams()
    {
        return fileManager.getTeams();
    }
    
    /** Saves a given list of Group in a textfile */
    public void saveGroups(List<Group> groupList)
    {
        fileManager.saveGroups(groupList);
    }
    
    /** Returns a List of Group from the textfile */
    public List<Group> getGroups()
    {
        return fileManager.getGroups();
    }
    
    /** Saves a given list of Match in a textfile */
    public void saveMatches(List<Match> matchList)
    {
        fileManager.saveMatches(matchList);
    }
    
    /** Returns a List of Match from the textfile */
    public List<Match> getMatches() {
        return fileManager.getMatches();
    }
}
