/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myChamp.BE;

import java.util.ArrayList;

/**
 *
 * @author Kristof
 */
public class Groups {
    
    private ArrayList<Group> groups = new ArrayList<>();
    private static Groups self;

    private Groups() {
        
    }
    
    public static Groups getInstance() {
        if(self == null) {
            self = new Groups();
        }
        return self;
    }

    public ArrayList<Group> getGroups() {
        return groups;
    }

    public void setGroups(ArrayList<Group> groups) {
        this.groups = groups;
    }
    
    public void addGroup(Group group) {
        this.groups.add(group);
    }
}
