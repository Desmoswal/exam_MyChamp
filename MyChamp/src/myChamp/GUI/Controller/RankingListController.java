/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myChamp.GUI.Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import myChamp.BE.Group;
import myChamp.BE.Groups;
import myChamp.BE.Team;
import myChamp.GUI.Model.MyChampModel;

/**
 * FXML Controller class
 *
 * @author Desmoswal
 */
public class RankingListController implements Initializable {

    @FXML
    private TableView<Team> tblGroupA;
    @FXML
    private TableColumn<Team, String> colTeamsGroupA;
    @FXML
    private TableColumn<Team, String> colPointsGroupA;
    @FXML
    private TableView<Team> tblGroupC;
    @FXML
    private TableColumn<Team, String> colTeamsGroupC;
    @FXML
    private TableColumn<Team, String> colPointsGroupC;
    @FXML
    private TableView<Team> tblGroupD;
    @FXML
    private TableColumn<Team, String> colTeamsGroupD;
    @FXML
    private TableColumn<Team, String> colPointsGroupD;
    @FXML
    private TableView<Team> tblGroupB;
    @FXML
    private TableColumn<Team, String> colTeamsGroupB;
    @FXML
    private TableColumn<?, ?> colPointsGroupB;
    
    
    private MyChampModel model = new MyChampModel();
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
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
                colTeamsGroupA.setCellValueFactory(new PropertyValueFactory("name"));
                colPointsGroupA.setCellValueFactory(new PropertyValueFactory("score"));
                
                colPointsGroupA.setSortable(true);
                colPointsGroupA.setSortType(TableColumn.SortType.ASCENDING);
                break;
            case "b":
                colTeamsGroupB.setCellValueFactory(new PropertyValueFactory("name"));
                colPointsGroupB.setCellValueFactory(new PropertyValueFactory("score"));
                break;
            case "c":
                colTeamsGroupC.setCellValueFactory(new PropertyValueFactory("name"));
                colPointsGroupC.setCellValueFactory(new PropertyValueFactory("score"));
                break;
            case "d":
                colTeamsGroupD.setCellValueFactory(new PropertyValueFactory("name"));
                colPointsGroupD.setCellValueFactory(new PropertyValueFactory("score"));
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
