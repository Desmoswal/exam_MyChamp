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
import javafx.stage.Modality;
import javafx.stage.Stage;
import myChamp.BE.Group;
import myChamp.GUI.Model.MyChampModel;

/**
 * FXML Controller class
 *
 * @author Kristof
 */
public class MatchResultsController implements Initializable {

    @FXML
    private Button btnResultsGroupA;
    @FXML
    private Button btnResultsGroupB;
    @FXML
    private Button btnResultsGroupC;
    @FXML
    private Button btnResultsGroupD;
    
    private MyChampModel model = new MyChampModel();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void pressedGroupA(ActionEvent event) throws IOException 
    {
        Stage primStage = (Stage)btnResultsGroupA.getScene().getWindow(); //getting the primary stage from any object of the fxml
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/myChamp/GUI/View/MatchGroupRounds.fxml"));
        Parent root = loader.load(); //load the fxml from the URL

        MatchGroupRoundsController controller = loader.getController(); //get he controller of the loaded fxml
        for(Group group : model.getGroups()) {
            if(group.getName().equals("a")) {
                    controller.setRounds(group, model.getMatchesFromFile());
            }
        }

        Stage stageView = new Stage();
        stageView.setScene(new Scene(root));

        stageView.initModality(Modality.WINDOW_MODAL);
        stageView.initOwner(primStage);
        
        stageView.show();
    }

    @FXML
    private void pressedGroupB(ActionEvent event) throws IOException 
    {
        Stage primStage = (Stage)btnResultsGroupB.getScene().getWindow(); //getting the primary stage from any object of the fxml
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/myChamp/GUI/View/MatchGroupRounds.fxml"));
        Parent root = loader.load(); //load the fxml from the URL

        MatchGroupRoundsController controller = loader.getController(); //get he controller of the loaded fxml
        for(Group group : model.getGroupsFromFile()) {
            if(group.getName().equals("b")) {
                    controller.setRounds(group, model.getMatchesFromFile());
            }
        }
        
        Stage stageView = new Stage();
        stageView.setScene(new Scene(root));

        stageView.initModality(Modality.WINDOW_MODAL);
        stageView.initOwner(primStage);
        
        stageView.show();
    }

    @FXML
    private void pressedGroupC(ActionEvent event) throws IOException 
    {
        Stage primStage = (Stage)btnResultsGroupC.getScene().getWindow(); //getting the primary stage from any object of the fxml
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/myChamp/GUI/View/MatchGroupRounds.fxml"));
        Parent root = loader.load(); //load the fxml from the URL

        MatchGroupRoundsController controller = loader.getController(); //get he controller of the loaded fxml
        for(Group group : model.getGroups()) {
            if(group.getName().equals("c")) {
                    controller.setRounds(group, model.getMatchesFromFile());
            }
        }
        
        Stage stageView = new Stage();
        stageView.setScene(new Scene(root));

        stageView.initModality(Modality.WINDOW_MODAL);
        stageView.initOwner(primStage);
        
        stageView.show();
    }

    @FXML
    private void pressedGroupD(ActionEvent event) throws IOException 
    {
        Stage primStage = (Stage)btnResultsGroupD.getScene().getWindow(); //getting the primary stage from any object of the fxml
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/myChamp/GUI/View/MatchGroupRounds.fxml"));
        Parent root = loader.load(); //load the fxml from the URL

        MatchGroupRoundsController controller = loader.getController(); //get he controller of the loaded fxml
        for(Group group : model.getGroups()) {
            if(group.getName().equals("d")) {
                    controller.setRounds(group, model.getMatchesFromFile());
            }
        }
        
        Stage stageView = new Stage();
        stageView.setScene(new Scene(root));

        stageView.initModality(Modality.WINDOW_MODAL);
        stageView.initOwner(primStage);
        
        stageView.show();
    }
    
}
