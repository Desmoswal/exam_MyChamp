/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myChamp.GUI.Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import myChamp.BE.Team;
import myChamp.BE.Teams;
import myChamp.GUI.Model.MyChampModel;

/**
 * FXML Controller class
 *
 * @author Kristof
 */
public class AddTeamController implements Initializable {

    @FXML
    private TableView<Team> addTeamTable;
    @FXML
    private TextField addTeamName;
    @FXML
    private Button addTeamButton;
    @FXML
    private TableColumn<Team, String> addTeamColTeams;
    
    private MyChampModel model = new MyChampModel();
    //private Teams allTeams = Teams.getInstance();
    //private ObservableList<Team> teams = FXCollections.observableArrayList(allTeams.getTeams());
    private ObservableList<Team> teamList;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        addTeamColTeams.setCellValueFactory(new PropertyValueFactory("name"));
        addTeamTable.setItems(FXCollections.observableArrayList(model.getTeamsFromFile()));
    }
    
    @FXML
    private void pressedAddButton(ActionEvent event) {
        model.addNewTeam(addTeamName.getText());
        System.out.println("Added?");
        System.out.println(model.getTeams().toString());
        
        addTeamTable.setItems(FXCollections.observableArrayList(model.getTeams()));
        
        
        teamList = FXCollections.observableArrayList(model.getTeams());
        model.saveTeams(teamList);
        addTeamName.clear();
    }
}
