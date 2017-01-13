/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myChamp.GUI.Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import myChamp.BE.Team;

/**
 * FXML Controller class
 *
 * @author Kristof
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
    private TableColumn<Team, String> colPoinstGroupB;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
