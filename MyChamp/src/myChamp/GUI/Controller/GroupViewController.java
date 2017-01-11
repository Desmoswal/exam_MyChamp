/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myChamp.GUI.Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import myChamp.BE.Group;
import myChamp.BE.Team;
import myChamp.GUI.Model.MyChampModel;

/**
 * FXML Controller class
 *
 * @author Kristof
 */
public class GroupViewController implements Initializable {

    @FXML
    private TableView<Team> tblTeams;
    @FXML
    private TableColumn<Team, String> tblColTeams;
    @FXML
    private TableView<Team> tblGroupA;
    @FXML
    private TableColumn<Team, String> tblColGroupA;
    @FXML
    private TableView<Team> tblGroupB;
    @FXML
    private TableColumn<Team, String> tblColGroupB;
    @FXML
    private TableView<Team> tblGroupC;
    @FXML
    private TableColumn<Team, String> tblColGroupC;
    @FXML
    private TableView<Team> tblGroupD;
    @FXML
    private TableColumn<Team, String> tblColGroupD;
    @FXML
    private Button btnGroup;
    @FXML
    private Button btnClose;
    
    private MyChampModel model = new MyChampModel();
    private boolean teamsHasGroups = false;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        setTeamTableProperties();
        for (Group group : model.getGroups()) {
            setTableProperties(group);
        }
        
        if(!model.getTeams().isEmpty()) {
            setTeamTableItems();
        }
        
        for (Team team : model.getTeamsFromFile()) {
            if((team.getGroup().equals("a")) || (team.getGroup().equals("b")) || (team.getGroup().equals("c")) || (team.getGroup().equals("d"))) {
                teamsHasGroups = true;
            } else {
                teamsHasGroups = false;
                System.out.println("Groups assignments missing from teams, please assign them!");
                break;
            }
        }
        
        if(teamsHasGroups) {
            for (Group group : model.getGroups()) {
                setTableItems(group);
            }
            btnGroup.setDisable(true);
        }
        
    }    

    @FXML
    private void pressedBtnGroup(ActionEvent event) {
        if(!teamsHasGroups) {
            assignGroups(model.getTeams(),model.getGroups());
            for (Group group : model.getGroups()) {
                setTableItems(group);
            }
            btnGroup.setDisable(true);
        }
    }

    @FXML
    private void pressedBtnClose(ActionEvent event) {
        
        Stage primStage = (Stage)btnClose.getScene().getWindow();
        
        primStage.close();
    }
    
    /**
     * Assigns teams to groups randomly
     * @param teamlist
     * @param grouplist 
     */
    private void assignGroups(List<Team> teamlist, List<Group> grouplist) {
        int i = 0;
        
        while(i < teamlist.size()) {
            for (int y = 0 ; y < grouplist.size() ; ) {
               
                Random rand = new Random();
                int randomTeam = rand.nextInt(teamlist.size());
                
                while(teamlist.get(randomTeam).getGroup() == null || teamlist.get(randomTeam).getGroup().equals("null")) {
                    grouplist.get(y).getTeams().add(teamlist.get(randomTeam));
                    teamlist.get(randomTeam).setGroup(grouplist.get(y).getName());
                    y++;
                    i++;
                }               
            }
        }
        model.saveTeams(teamlist);
        model.saveGroups(grouplist);
    }
    
    /**
     * Sets table colmn properies for a specified group's table
     * @param group 
     */
    private void setTableProperties(Group group) {
        switch(group.getName()) {
            case "a":
                tblColGroupA.setCellValueFactory(new PropertyValueFactory("name"));
                break;
            case "b":
                tblColGroupB.setCellValueFactory(new PropertyValueFactory("name"));
                break;
            case "c":
                tblColGroupC.setCellValueFactory(new PropertyValueFactory("name"));
                break;
            case "d":
                tblColGroupD.setCellValueFactory(new PropertyValueFactory("name"));
                break;
        }
    }
    
    /**
     * Sets the table items for a specified group's table.
     * @param group 
     */
    private void setTableItems(Group group) {
        switch(group.getName()) {
                case "a":
                    tblGroupA.setItems(FXCollections.observableArrayList(model.getGroups().get(model.getGroups().indexOf(group)).getTeams()));
                    break;
                case "b":
                    tblGroupB.setItems(FXCollections.observableArrayList(model.getGroups().get(model.getGroups().indexOf(group)).getTeams()));
                    break;
                case "c":
                    tblGroupC.setItems(FXCollections.observableArrayList(model.getGroups().get(model.getGroups().indexOf(group)).getTeams()));
                    break;
                case "d":
                    tblGroupD.setItems(FXCollections.observableArrayList(model.getGroups().get(model.getGroups().indexOf(group)).getTeams()));
                    break;
        }
    }
    
    /**
     * Sets the all team's table properties to display every team's name
     */
    private void setTeamTableProperties() {
        tblColTeams.setCellValueFactory(new PropertyValueFactory("name"));
    }
    
    /**
     * Sets the all team's table items
     */
    private void setTeamTableItems() {
        tblTeams.setItems(FXCollections.observableArrayList(model.getTeams()));
    }
    
    @FXML
    private void pressedTableDebug(MouseEvent event) {
        System.out.println("source: "+event.getSource());
        System.out.println("target: "+event.getTarget());
    }
}
