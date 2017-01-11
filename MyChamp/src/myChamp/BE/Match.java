/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myChamp.BE;

import java.util.UUID;

/**
 *
 * @author Kristof
 */
public class Match {
    private Team homeTeam;
    private Team guestTeam;
    private String homeTeamName;
    private String guestTeamName;
    private int homeTeamGoals = 0;
    private int guestTeamGoals = 0;
    private UUID uuid;
    private Group group;
    
    public Match(Team homeTeam, Team guestTeam, Group group) {
        this.homeTeam = homeTeam;
        this.guestTeam = guestTeam;
        this.homeTeamName = homeTeam.getName();
        this.guestTeamName = guestTeam.getName();
        this.group = group;
        this.uuid = UUID.randomUUID();
    }
    
    public Match(Team homeTeam, Team guestTeam, Group group, UUID uuid) {
        this.homeTeam = homeTeam;
        this.guestTeam = guestTeam;
        this.homeTeamName = homeTeam.getName();
        this.guestTeamName = guestTeam.getName();
        this.group = group;
        this.uuid = uuid;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public Team getGuestTeam() {
        return guestTeam;
    }

    public int getHomeTeamGoals() {
        return homeTeamGoals;
    }

    public int getGuestTeamGoals() {
        return guestTeamGoals;
    }

    public Group getGroup() {
        return group;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getHomeTeamName() {
        return homeTeamName;
    }

    public String getGuestTeamName() {
        return guestTeamName;
    }

    public void setHomeTeamGoals(int homeTeamGoals) {
        this.homeTeamGoals = homeTeamGoals;
    }

    public void setGuestTeamGoals(int guestTeamGoals) {
        this.guestTeamGoals = guestTeamGoals;
    }
}
