/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myChamp.DAL;

import myChamp.GUI.Controller.FXMLDocumentController;
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
     * Saves every team in Teams
     * @param teamList 
     */
    @Override
    public void saveTeams(List<Team> teamList)
    {
        String csvString = "";
        for (Team team : teamList)
        {
            csvString += team.getName() + "," + team.getScore() + "," + team.getGroup() + "," + team.getGoals() + "," + team.getMatchesPlayed() + "," + team.getPlayedTeams() + "," + team.getUUID() + String.format("%n");
            //csvString += song.getPath() + "," + song.getArtist() + "," + song.getTitle() + "," + song.getGenre() + "," + song.getTime() + "," + song.getUUID() + String.format("%n");//save info and format according to system and localization
        }
        
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("TeamList.txt")))
        {
            bw.write(csvString);
        } 
        
        catch (IOException ex)
        {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Reads every line from Team library
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
                //fields[0] is path
                //fields[1] is artist
                String[] fields = line.split(",");
                //songlist.add(new Song(fields[0].trim(), fields[1].trim(), fields[2], fields[3], fields[4],fields[5].trim()));
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
    public void saveGroups(List<Groups> groupList)
    {
        String csvString = "";
        for (Groups groups : groupList)
        {
           /* 
            csvString += playlist.getName();
            for(Song song : playlist.getSongs()) {
                csvString += "," + song.getUUID(); 
            }
            */
            csvString += String.format("%n");
        }
        
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("GroupList.txt")))
        {
            bw.write(csvString);
        } 
        
        catch (IOException ex)
        {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Reads every Group from GroupList.txt
     * @return 
     */
    @Override
    public List<Groups> getGroups()
    {
        Groups group = Groups.getInstance();
        List<Groups> groupList = new ArrayList<>();
        
        try(BufferedReader br = new BufferedReader(new FileReader("GroupList.txt")))
        {
            Scanner scanner = new Scanner(br);
            
            while(scanner.hasNext())
            {
                //Gets next line in file
                String line = scanner.nextLine();
                //Separates line into array by comma
                //fields[0] is name
                //fields[1] is Songs
                String[] fields = line.split(",");
                
                /*
                if(fields.length == 1) {
                    playList.add(new Playlist(fields[0],new ArrayList<>()));
                } else {
                    ArrayList<Song> songsInPlaylist = new ArrayList<>();
                    for (int i = 0; i < fields.length; i++) {
                        if(i!=0 && !libSong.getSongList().isEmpty()) {
                            for (Song song : libSong.getSongList()) {
                                if(song.getUUID().equals(fields[i])) {
                                    songsInPlaylist.add(song);
                                }
                            }
                            
                        }
                    }
                    playList.add(new Playlist(fields[0],songsInPlaylist));
                }*/
            }
        }
        
        catch(IOException ioe)
        {
            System.out.println("Something went horribly wrong during reading from GroupList.txt");
        }
        
        System.out.println(groupList);
        return groupList;
    }
}
