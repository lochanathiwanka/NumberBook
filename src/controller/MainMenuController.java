package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

public class MainMenuController extends StageList {

    public void createNewContactOnAction(ActionEvent actionEvent) throws Exception {
        createContactStage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/CreateNewContactForm.fxml"))));
        createContactStage.show();
        mainMenuStage.close();
    }
    

    public void searchContactOnAction(ActionEvent actionEvent) throws Exception {
        searchContactStage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/SearchContactForm.fxml"))));
        searchContactStage.show();
        mainMenuStage.close();
    }

    public void updateContactOnAction(ActionEvent actionEvent) throws Exception {
        updateContactStage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/UpdateContactForm.fxml"))));
        updateContactStage.show();
        mainMenuStage.close();
    }

    public void deleteContactOnAction(ActionEvent actionEvent) throws Exception {
        deleteContactStage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/DeleteContactForm.fxml"))));
        deleteContactStage.show();
        mainMenuStage.close();
    }

    public void viewContactOnAction(ActionEvent actionEvent) throws Exception {
        viewContactStage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/ViewContactForm.fxml"))));
        viewContactStage.show();
        mainMenuStage.close();
    }

    public void closeOnAction(ActionEvent actionEvent){
        System.exit(0);
    }

}
