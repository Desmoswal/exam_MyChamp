/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myChamp.GUI.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.stage.Modality;
import javafx.stage.Stage;
import myChamp.BE.Groups;
import myChamp.BE.Matches;
import myChamp.BE.Teams;
import myChamp.GUI.Model.MyChampModel;

/**
 * FXML Controller class
 *
 * @author Desmoswal
 */
public class MainMenuController implements Initializable
{

    @FXML
    private Button btnTeamManagement;
    @FXML
    private Button btnRanking;
    @FXML
    private Button btnSchedules;
    @FXML
    private Button btnResults;
    @FXML
    private Button btnFinals;
    @FXML
    private Button btnGroups;
    @FXML
    private Button btnNewTournament;
    @FXML
    private Button btnLoadTournament;

    private MyChampModel model = new MyChampModel();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        //create all singleton instances just to be safe
        Groups.getInstance();
        Teams.getInstance();
        Matches.getInstance();
        
        //load data back from files if any
        if(!model.getTeamsFromFile().isEmpty()) {
            model.getTeams().addAll(model.getTeamsFromFile());
        }
        
        if(!model.getGroupsFromFile().isEmpty()) {
            model.getGroups().addAll(model.getGroupsFromFile());
        }
        
        if(!model.getMatchesFromFile().isEmpty()) {
            model.getMatches().addAll(model.getMatchesFromFile());
        }
        
    }    
    
    @FXML
    private void pressedBtnTeamManagement(ActionEvent event) throws IOException {
        //OpenNewWindow.openWindowInParent(mainPane, getClass().getResource("/myChamp/GUI/View/FXMLDocument.fxml"));
        Stage primStage = (Stage)btnTeamManagement.getScene().getWindow(); //getting the primary stage from any object of the fxml
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/myChamp/GUI/View/AddTeam.fxml"));
        Parent root = loader.load(); //load the fxml from the URL

        loader.getController(); //get he controller of the loaded fxml
        
        Stage stageView = new Stage();
        stageView.setScene(new Scene(root));
        stageView.getIcons().add(new Image("/Images/icon.png"));
        stageView.initModality(Modality.WINDOW_MODAL);
        stageView.initOwner(primStage);
        stageView.show();
    }
    
    @FXML
    private void pressedBtnGroups(ActionEvent event) throws IOException {
        //OpenNewWindow.openWindowInParent(mainPane, getClass().getResource("/myChamp/GUI/View/FXMLDocument.fxml"));
        Stage primStage = (Stage)btnGroups.getScene().getWindow(); //getting the primary stage from any object of the fxml
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/myChamp/GUI/View/GroupView.fxml"));
        Parent root = loader.load(); //load the fxml from the URL

        loader.getController(); //get he controller of the loaded fxml

        // this is a popup, we will create a new window for it
        Stage stageView = new Stage();
        stageView.setScene(new Scene(root));
        stageView.getIcons().add(new Image("/Images/icon.png"));
        stageView.initModality(Modality.WINDOW_MODAL);
        stageView.initOwner(primStage);
        stageView.show();
    }
    
    @FXML
    private void pressedBtnSchedules(ActionEvent event) throws IOException {
        //OpenNewWindow.openWindowInParent(mainPane, getClass().getResource("/myChamp/GUI/View/FXMLDocument.fxml"));
        Stage primStage = (Stage)btnSchedules.getScene().getWindow(); //getting the primary stage from any object of the fxml
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/myChamp/GUI/View/Schedules.fxml"));
        Parent root = loader.load(); //load the fxml from the URL

        loader.getController(); //get he controller of the loaded fxml

        Stage stageView = new Stage();
        stageView.setScene(new Scene(root));
        stageView.getIcons().add(new Image("/Images/icon.png"));
        stageView.initModality(Modality.WINDOW_MODAL);
        stageView.initOwner(primStage);
        stageView.show();
    }
    
    @FXML
    private void pressedBtnResults(ActionEvent event) throws IOException {
        //OpenNewWindow.openWindowInParent(mainPane, getClass().getResource("/myChamp/GUI/View/FXMLDocument.fxml"));
        Stage primStage = (Stage)btnResults.getScene().getWindow(); //getting the primary stage from any object of the fxml
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/myChamp/GUI/View/MatchResults.fxml"));
        Parent root = loader.load(); //load the fxml from the URL

        loader.getController(); //get he controller of the loaded fxml

        Stage stageView = new Stage();
        stageView.setScene(new Scene(root));
        stageView.getIcons().add(new Image("/Images/icon.png"));
        stageView.initModality(Modality.WINDOW_MODAL);
        stageView.initOwner(primStage);
        stageView.show();
    }
    
    @FXML
    private void pressedBtnRanking(ActionEvent event) throws IOException {
        //OpenNewWindow.openWindowInParent(mainPane, getClass().getResource("/myChamp/GUI/View/FXMLDocument.fxml"));
        Stage primStage = (Stage)btnRanking.getScene().getWindow(); //getting the primary stage from any object of the fxml
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/myChamp/GUI/View/RankingList.fxml"));
        Parent root = loader.load(); //load the fxml from the URL

        loader.getController(); //get he controller of the loaded fxml

        Stage stageView = new Stage();
        stageView.setScene(new Scene(root));
        stageView.getIcons().add(new Image("/Images/icon.png"));
        stageView.initModality(Modality.WINDOW_MODAL);
        stageView.initOwner(primStage);
        stageView.show();
    }
    
    @FXML
    private void pressedBtnFinals(ActionEvent event) throws IOException {
        //OpenNewWindow.openWindowInParent(mainPane, getClass().getResource("/myChamp/GUI/View/FXMLDocument.fxml"));
        Stage primStage = (Stage)btnFinals.getScene().getWindow(); //getting the primary stage from any object of the fxml
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/myChamp/GUI/View/Finals.fxml"));
        Parent root = loader.load(); //load the fxml from the URL

        loader.getController(); //get he controller of the loaded fxml

        Stage stageView = new Stage();
        stageView.setScene(new Scene(root));
        stageView.getIcons().add(new Image("/Images/icon.png"));
        stageView.initModality(Modality.WINDOW_MODAL);
        stageView.initOwner(primStage);
        stageView.show();
    }
    
    @FXML
    private void pressedBtnNewTournament(ActionEvent event) throws IOException {
        //OpenNewWindow.openWindowInParent(mainPane, getClass().getResource("/myChamp/GUI/View/FXMLDocument.fxml"));
        Stage primStage = (Stage)btnNewTournament.getScene().getWindow(); //getting the primary stage from any object of the fxml
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/myChamp/GUI/View/GroupView.fxml"));
        Parent root = loader.load(); //load the fxml from the URL

        loader.getController(); //get he controller of the loaded fxml

        Stage stageView = new Stage();
        stageView.setScene(new Scene(root));
        stageView.getIcons().add(new Image("/Images/icon.png"));
        stageView.initModality(Modality.WINDOW_MODAL);
        stageView.initOwner(primStage);
        stageView.show();
    }
}
