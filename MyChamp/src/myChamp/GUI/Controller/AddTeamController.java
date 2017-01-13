/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myChamp.GUI.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
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
    @FXML
    private Button btnClose;
    @FXML
    private Button addTeamRemoveButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        addTeamColTeams.setCellValueFactory(new PropertyValueFactory("name"));
        
        addTeamTable.setItems(FXCollections.observableArrayList(model.getTeams()));
        
       // System.out.println("ezaszar"+model.getTeams());
       // model.getTeams().removeAll(FXCollections.observableArrayList(model.getTeams()));
       // model.getTeams().addAll(FXCollections.observableArrayList(model.getTeamsFromFile()));
       // System.out.println("ezaszar2"+model.getTeams());

        
    }
    
    @FXML //adds team to the Teams object and saves it to te textfile
    private void pressedAddButton(ActionEvent event) {
       if(!addTeamName.getText().isEmpty()) {
            model.addNewTeam(addTeamName.getText());
            System.out.println("Added: " + addTeamName.getText());
            System.out.println(model.getTeams().toString());

            addTeamTable.setItems(FXCollections.observableArrayList(model.getTeams()));


            //teamList = FXCollections.observableArrayList(model.getTeams());
            model.saveTeams(model.getTeams());
            addTeamName.clear();
        }
    }
    
    @FXML //removes team from the Teams object and saves modifications to file
    private void pressedRemoveButton(ActionEvent event) {
        Team selected = addTeamTable.getSelectionModel().getSelectedItem();
        model.removeTeam(selected);
        model.saveTeams(model.getTeams());
        addTeamTable.setItems(FXCollections.observableArrayList(model.getTeams()));
        System.out.println(model.getTeams());
    }

    @FXML
    private void pressedCloseButton(ActionEvent event)
    {
        Stage primStage = (Stage)addTeamName.getScene().getWindow();
        
        primStage.close();
    }
}