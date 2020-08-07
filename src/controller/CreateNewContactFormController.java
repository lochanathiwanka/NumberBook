package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import model.Contact;

import javax.swing.*;
import java.sql.*;
import java.util.logging.Logger;

public class CreateNewContactFormController extends StageList {

    public JFXTextField txtFirstName;
    public JFXTextField txtLastName;
    public JFXTextField txtAddress;
    public JFXTextField txtEmail;


    private Logger logger = Logger.getLogger("ConfirmController");

    @FXML
    private JFXTextField txtContact;

    @FXML
    private GridPane gridPane;

    @FXML
    private JFXButton btnAddContact;

    @FXML
            public void initialize() {
        btnAddContact.disableProperty().bind(
                txtContact.textProperty().isEqualTo(txtContact.textProperty()).not()
                        .or(
                                txtContact.textProperty().isEmpty()
                        )
        );
    }

    @FXML
    public void save(ActionEvent evt) {
        logger.info("confirmed " + txtContact.getText());
        hide(evt);
    }

    @FXML
    public void cancel(ActionEvent evt) {
        hide(evt);
    }

    private void hide(ActionEvent evt) {
        ((Node)evt.getSource()).getScene().getWindow().hide();
    }

    public void addContactOnAction(ActionEvent actionEvent) {
        String firstName=txtFirstName.getText();
        String lastname=txtLastName.getText();
        String address=txtAddress.getText();
        String contactNumber=txtContact.getText();
        String email=txtEmail.getText();
        try {
            Contact contact = new Contact(firstName,lastname,address,contactNumber,email);
            boolean isAdded = ContactController.addContact(contact);
            if (isAdded){
                    JOptionPane.showMessageDialog(null, "Contact added Successfully", "", JOptionPane.INFORMATION_MESSAGE);
                    txtFirstName.setText(null);
                    txtLastName.setText(null);
                    txtAddress.setText(null);
                    txtContact.setText(null);
                    txtEmail.setText(null);
            }else {
                JOptionPane.showMessageDialog(null,"Error","",JOptionPane.ERROR_MESSAGE);
            }
        }catch (ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null,"Driver Not Found");
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Duplicate Entry","",JOptionPane.WARNING_MESSAGE);
        }
    }

    public void cancelOnAction(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void backOnAction(MouseEvent mouseEvent) {
        mainMenuStage.show();
        createContactStage.close();
    }
}
