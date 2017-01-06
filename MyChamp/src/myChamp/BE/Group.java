/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myChamp.BE;

import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * @author Desmoswal
 */
public class Group
{
    private ArrayList<Team> teams;
    private String name;
    private final UUID uuid;

    public Group(String name, UUID uuid) {
        this.name = name;
        this.uuid = uuid;
    }
    
    public Group(String name) {
        this.name = name;
        this.uuid = UUID.randomUUID();
    }

    public void setTeams(ArrayList<Team> teams) {
        this.teams = teams;
    }
    
    public ArrayList<Team> getTeams() {
        return teams;
    }

    public String getName() {
        return name;
    }

    public UUID getUuid() {
        return uuid;
    }
}
