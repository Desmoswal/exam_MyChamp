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
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import myChamp.BE.Group;
import myChamp.BE.Team;
import myChamp.GUI.Model.MyChampModel;

/**
 *
 * @author Desmoswal
 */
public class GroupViewController implements Initializable
{    
    @FXML
    private Label label;
    @FXML
    private TableColumn<Team, String> colGroupAHomeTeam;
    @FXML
    private TableColumn<Team, String> colGroupAGuestTeam;
    @FXML
    private TableColumn<Team, String> colGroupADate;
    @FXML
    private TableColumn<Team, String> colGroupBHomeTeam;
    @FXML
    private TableColumn<Team, String> colGroupBGuestTeam;
    @FXML
    private TableColumn<Team, String> colGroupBDate;
    @FXML
    private TableColumn<Team, String> colGroupCHomeTeam;
    @FXML
    private TableColumn<Team, String> colGroupCGuestTeam;
    @FXML
    private TableColumn<Team, String> colGroupCDate;
    @FXML
    private TableColumn<Team, String> colGroupDHomeTeam;
    @FXML
    private TableColumn<Team, String> colGroupDGuestTeam;
    @FXML
    private TableColumn<Team, String> colGroupDDate;
    @FXML
    private TableView<Team> tblGroupA;
    @FXML
    private TableView<Team> tblGroupB;
    @FXML
    private TableView<Team> tblGroupC;
    @FXML
    private TableView<Team> tblGroupD;
    
    private MyChampModel model = new MyChampModel();
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        assignGroups(model.getTeams(),model.getGroups());
        
        //after assigning the teams randomly, we set the table properties and then the table items for each group's table.
        for (Group group : model.getGroups()) {
            setTableProperties(group);
            
            setTableItems(group);
        }
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
                
                while(teamlist.get(randomTeam).getGroup() == null) {
                    grouplist.get(y).getTeams().add(teamlist.get(randomTeam));
                    teamlist.get(randomTeam).setGroup(grouplist.get(y).getName());
                    y++;
                    i++;
                }               
            }
        }
        model.saveTeams(teamlist);
    }
    
    /**
     * Sets table colmn properies for a specified group's table
     * @param group 
     */
    private void setTableProperties(Group group) {
        switch(group.getName()) {
            case "a":
                colGroupAHomeTeam.setCellValueFactory(new PropertyValueFactory("name"));
                break;
            case "b":
                colGroupBHomeTeam.setCellValueFactory(new PropertyValueFactory("name"));
                break;
            case "c":
                colGroupCHomeTeam.setCellValueFactory(new PropertyValueFactory("name"));
                break;
            case "d":
                colGroupDHomeTeam.setCellValueFactory(new PropertyValueFactory("name"));
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
}
