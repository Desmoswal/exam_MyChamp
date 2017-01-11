package myChamp.GUI.Controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.UUID;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import myChamp.BE.Group;
import myChamp.BE.Match;
import myChamp.BE.Matches;
import myChamp.BE.Team;
import myChamp.GUI.Model.MyChampModel;

/**
 *
 * @author Desmoswal
 */
public class SchedulesController implements Initializable
{    
    @FXML
    private Label label;
    @FXML
    private TableColumn<Match, String> colGroupAHomeTeam;
    @FXML
    private TableColumn<Match, String> colGroupAGuestTeam;
    @FXML
    private TableColumn<Match, String> colGroupADate;
    @FXML
    private TableColumn<Match, String> colGroupBHomeTeam;
    @FXML
    private TableColumn<Match, String> colGroupBGuestTeam;
    @FXML
    private TableColumn<Match, String> colGroupBDate;
    @FXML
    private TableColumn<Match, String> colGroupCHomeTeam;
    @FXML
    private TableColumn<Match, String> colGroupCGuestTeam;
    @FXML
    private TableColumn<Match, String> colGroupCDate;
    @FXML
    private TableColumn<Match, String> colGroupDHomeTeam;
    @FXML
    private TableColumn<Match, String> colGroupDGuestTeam;
    @FXML
    private TableColumn<Match, String> colGroupDDate;
    @FXML
    private TableView<Match> tblGroupA;
    @FXML
    private TableView<Match> tblGroupB;
    @FXML
    private TableView<Match> tblGroupC;
    @FXML
    private TableView<Match> tblGroupD;
    
    private MyChampModel model = new MyChampModel();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        /**
         * PUZZLE PIECES
         * 
         * Latest ultimate programming skills.
         * We have actually no idea what to do..
         * but.. we have a lot of fors .. which is nice.
         */
       /* for (Group group : model.getGroups()) {
            for (Team team : group.getTeams()) {
                for (Match match : model.getMatches()) {
                    match.getGroup().equals(group)
                            match.getHomeTeam().equals(team)
                                    match.getGuestTeam().equals(team)
                }
            }
        }*/
        
        for (Group group : model.getGroups()) {
            Random rand = new Random();
            Random rand2 = new Random();
            ArrayList<Match> temp = new ArrayList<>();
            if(!model.getMatches().isEmpty()) {
                temp = new ArrayList<>();
                for (Match match : model.getMatches()) {
                    if(match.getGroup().equals(group)) {
                        temp.add(match);
                    }
                }
            } else {
                temp = (ArrayList<Match>) model.getMatches();
            }
            while(temp.size() < group.getTeams().size()) {
                int random = 0;
                int random2 = 0;
                while(random == random2) {
                    random = rand.nextInt(group.getTeams().size());
                    random2 = rand2.nextInt(group.getTeams().size());
                }
                model.getMatches().add(new Match(group.getTeams().get(random),group.getTeams().get(random2),group));
                model.getMatches().add(new Match(group.getTeams().get(random2),group.getTeams().get(random),group));
                temp = (ArrayList<Match>) model.getMatches();
            }
        }
        
        for (Group group : model.getGroups()) {
            setTableProperties(group);
            
            setTableItems(group);
        }
    }
    
    /**
     * Sets table colmn properies for a specified group's table
     * @param group 
     */
    private void setTableProperties(Group group) {
        switch(group.getName()) {
            case "a":
                colGroupAHomeTeam.setCellValueFactory(new PropertyValueFactory("homeTeamName"));
                colGroupAGuestTeam.setCellValueFactory(new PropertyValueFactory("guestTeamName"));
                break;
            case "b":
                colGroupBHomeTeam.setCellValueFactory(new PropertyValueFactory("homeTeamName"));
                colGroupBGuestTeam.setCellValueFactory(new PropertyValueFactory("guestTeamName"));
                break;
            case "c":
                colGroupCHomeTeam.setCellValueFactory(new PropertyValueFactory("homeTeamName"));
                colGroupCGuestTeam.setCellValueFactory(new PropertyValueFactory("guestTeamName"));
                break;
            case "d":
                colGroupDHomeTeam.setCellValueFactory(new PropertyValueFactory("homeTeamName"));
                colGroupDGuestTeam.setCellValueFactory(new PropertyValueFactory("guestTeamName"));
                break;
        }
    }
    
    /**
     * Sets the table items for a specified group's table.
     * @param group 
     */
    private void setTableItems(Group group) {
        ArrayList<Match> temp = new ArrayList<>();
        switch(group.getName()) {
                case "a":
                    temp = new ArrayList<>();
                    for (Match match : model.getMatches()) {
                        if(match.getGroup().getName().equals("a")) {
                            temp.add(match);
                        }
                    }
                    tblGroupA.setItems(FXCollections.observableArrayList(temp));
                    break;
                case "b":
                    temp = new ArrayList<>();
                    for (Match match : model.getMatches()) {
                        if(match.getGroup().getName().equals("b")) {
                            temp.add(match);
                        }
                    }
                    tblGroupB.setItems(FXCollections.observableArrayList(temp));
                    break;
                case "c":
                    temp = new ArrayList<>();
                    for (Match match : model.getMatches()) {
                        if(match.getGroup().getName().equals("c")) {
                            temp.add(match);
                        }
                    }
                    tblGroupC.setItems(FXCollections.observableArrayList(temp));
                    break;
                case "d":
                    temp = new ArrayList<>();
                    for (Match match : model.getMatches()) {
                        if(match.getGroup().getName().equals("d")) {
                            temp.add(match);
                        }
                    }
                    tblGroupD.setItems(FXCollections.observableArrayList(temp));
                    break;
        }
    }
    
    @FXML
    private void pressedTableDebug(MouseEvent event) {
        System.out.println("source: "+event.getSource());
        System.out.println("target: "+event.getTarget());
        System.out.println(colGroupAHomeTeam.getCellValueFactory());
        System.out.println(colGroupAHomeTeam.getCellData(tblGroupA.getSelectionModel().getSelectedItem()));
        System.out.println(model.getMatches());
    }
}
