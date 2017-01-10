/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myChamp.BE;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kristof
 */
public class Matches {
    private List<Match> matches = new ArrayList<>();
    
    private static Matches self;
    
    private Matches() {
        
    }
    
    public static Matches getInstance() {
        if(self == null) {
            self = new Matches();
        }
        return self;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }
}
