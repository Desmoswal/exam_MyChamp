/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myChamp.DAL;

import myChamp.BE.Team;
import java.util.List;
import myChamp.BE.Group;
import myChamp.BE.Groups;
import myChamp.BE.Match;


/**
 *  Abstract class which helps dealing with saving and reading files
 * @author Desmoswal
 */
public abstract class FileManager
{
    
    public FileManager()
    {
        
    }
    
    public abstract void saveTeams(List<Team> teamList);
    
    public abstract List<Team> getTeams(); 
    
    public abstract void saveGroups (List<Group> groupList);
    
    public abstract List<Group> getGroups(); 
    
    public abstract void saveMatches(List<Match> matchList);
    
    public abstract List<Match> getMatches();
    
}