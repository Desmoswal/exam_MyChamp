/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myChamp.DAL;

import myChamp.GUI.Controller.SchedulesController;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import myChamp.BE.*;

/**
 *  Comma separated saving and reading
 * @author Desmoswal
 */
public class TextFileHandler extends FileManager
{
    
    /**
     * Saves every team in Teams to a textfile
     * @param teamList 
     */
    @Override
    public void saveTeams(List<Team> teamList)
    {
        String csvString = "";
        for (Team team : teamList)
        {
            csvString += team.getName() + "," + team.getScore() + "," + team.getGroup() + "," + team.getGoals() + "," + team.getMatchesPlayed() + "," + team.getPlayedTeams() + "," + team.getUUID() + String.format("%n");
        }
        
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("TeamList.txt")))
        {
            bw.write(csvString);
        } 
        
        catch (IOException ex)
        {
            Logger.getLogger(SchedulesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Reads every line from Team library text file
     * @return 
     */
    @Override
    public List<Team> getTeams()
    {
        List<Team> teamlist = new ArrayList();
        
        try(BufferedReader br = new BufferedReader(new FileReader("TeamList.txt")))
        {
            Scanner scanner = new Scanner(br);
            
            while(scanner.hasNext())
            {
                //Gets next line in file
                String line = scanner.nextLine();
                //Separates line into array by comma
                String[] fields = line.split(",");
                
                teamlist.add(new Team(fields[0], Integer.parseInt(fields[1]), fields[2], Integer.parseInt(fields[3]), Integer.parseInt(fields[4]) , UUID.fromString(fields[6])));
                
            }
        }
        
        catch(IOException ioe)
        {
            System.out.println("Something went horribly wrong during reading from TeamList.txt");
        }
        
        System.out.println(teamlist);
        return teamlist;
    }
    
    /**
     * Comma separated saving of Groups
     * Gets every group in every Group
     * @param groupList 
     */
    @Override
    public void saveGroups(List<Group> groupList)
    {
        String csvString = "";
        for (Group group : groupList)
        {
            csvString += group.getName() + "," + group.getUuid();
            for (Team team : group.getTeams()) {
                csvString += "," + team.getUUID();
            }
            csvString += String.format("%n");
        }
        
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("GroupList.txt")))
        {
            bw.write(csvString);
        } 
        
        catch (IOException ex)
        {
            Logger.getLogger(SchedulesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Reads every Group from GroupList.txt
     * @return 
     */
    public List<Group> getGroups()
    {
        Groups groups = Groups.getInstance();
        Teams teams = Teams.getInstance();
        List<Group> groupList = new ArrayList<>();
        
        try(BufferedReader br = new BufferedReader(new FileReader("GroupList.txt")))
        {
            Scanner scanner = new Scanner(br);
            
            while(scanner.hasNext())
            {
                //Gets next line in file
                String line = scanner.nextLine();
                //Separates line into array by comma
                //fields[0] is name
                //fields[1] is uuid
                //fields after them are the teams in the group
                String[] fields = line.split(",");
                
                
                if(fields.length == 2) {
                    groupList.add(new Group(fields[0],UUID.fromString(fields[1])));
                } else {
                    List<Team> teamsInGroup = new ArrayList<>();
                    for (int i = 0; i < fields.length; i++) {
                        if((i!=0 && i!=1 ) && !teams.getTeams().isEmpty()) {
                            for (Team team : teams.getTeams()) {
                                if(team.getUUID().equals(UUID.fromString(fields[i]))) {
                                    teamsInGroup.add(team);
                                }
                            }
                            
                        }
                    }
                    Group toAdd = new Group(fields[0],UUID.fromString(fields[1]));
                    toAdd.getTeams().addAll(teamsInGroup);
                    groupList.add(toAdd);
                }
            }
        }
        
        catch(IOException ioe)
        {
            System.out.println("Something went horribly wrong during reading from GroupList.txt");
        }
        
        System.out.println(groupList);
        return groupList;
    }
    
    /**
     * Saves every Match
     * @param matchList 
     */
    @Override
    public void saveMatches(List<Match> matchList)
    {
        String csvString = "";
        int isFinal;
        for (Match match : matchList) {
            csvString += match.getHomeTeam().getUUID() + "," + match.getGuestTeam().getUUID()+ "," + match.getGroup().getName() + "," + match.getHomeTeamGoals() + "," + match.getGuestTeamGoals() + "," + match.getUuid() + "," + match.getRound() + "," + match.isFinal() + String.format("%n");          
        }
        
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("MatchList.txt")))
        {
            bw.write(csvString);
        } 
        
        catch (IOException ex)
        {
            Logger.getLogger(SchedulesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Reads every line from MatchList
     * @return 
     */
    @Override
    public List<Match> getMatches()
    {
        List<Match> matchList = new ArrayList();
        
        
        try(BufferedReader br = new BufferedReader(new FileReader("MatchList.txt")))
        {
            Scanner scanner = new Scanner(br);
            
            while(scanner.hasNext())
            {
                //Gets next line in file
                String line = scanner.nextLine();
                //Separates line into array by comma
                String[] fields = line.split(",");
                
                //matchList.add(new Match(fields[0], fields[1], fields[2], Integer.parseInt(fields[3]), Integer.parseInt(fields[4]), UUID.fromString(fields[5])));
                Team homeTeam = null;
                Team guestTeam = null;
                Group matchGroup = null;
                for(Team team : this.getTeams())
                {
                    if(team.getUUID().equals(UUID.fromString(fields[0])))
                    {
                        homeTeam = team;
                    }
                    if(team.getUUID().equals(UUID.fromString(fields[1]))) {
                        guestTeam = team;
                    }
                }
                
                for(Group group : this.getGroups()) {
                    if(group.getName().equals(fields[2])) {
                        matchGroup = group;
                    }
                }
                
                matchList.add(new Match(homeTeam, guestTeam, matchGroup, Integer.parseInt(fields[6]), Integer.parseInt(fields[7]), Integer.parseInt(fields[3]), Integer.parseInt(fields[4]), UUID.fromString(fields[5])));
                //matchList.add(new Match(fields[0], fields[1], fields[2], Integer.parseInt(fields[3]), Integer.parseInt(fields[4]), UUID.fromString(fields[5])));
            }
        }
        catch(IOException ioe)
        {
            System.out.println("Something went horribly wrong during reading from TeamList.txt");
        }
        
        System.out.println(matchList);
        return matchList;
    }
}
