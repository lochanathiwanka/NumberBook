package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import javax.swing.*;
import java.sql.*;
import java.util.logging.Logger;

public class UpdateContactFormController extends StageList {
    public JFXTextField txtSearch;
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
    private JFXButton btnUpdateContact;

    @FXML
    public void initialize() {
        btnUpdateContact.disableProperty().bind(
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

    public void updateContactOnAction(ActionEvent actionEvent) {
        String SQl = "Update contactdetails set lastName=?,address=?,contact=?,email=? where firstName=?";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/numberbook", "root", "1234");
            PreparedStatement stm = connection.prepareStatement(SQl);
            stm.setObject(1,txtLastName.getText());
            stm.setObject(2,txtAddress.getText());
            stm.setObject(3,txtContact.getText());
            stm.setObject(4,txtEmail.getText());
            stm.setObject(5,txtFirstName.getText());
            int res = stm.executeUpdate();
            if (res>0){
                JOptionPane.showMessageDialog(null,"Contact Updated Successfully","",JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null,"Contact couldn't Updated","",JOptionPane.ERROR_MESSAGE);
            }

        }catch (ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null,"Driver Not Found");
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Duplicate Entry","",JOptionPane.WARNING_MESSAGE);
        }
    }

    public void searchOnAction(MouseEvent mouseEvent) {
        String searchFirstName = txtSearch.getText();
        String SQl = "select * from contactdetails where firstName=?";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/numberbook", "root", "1234");
            PreparedStatement stm = connection.prepareStatement(SQl);
            stm.setObject(1,searchFirstName);
            ResultSet rst = stm.executeQuery();
            if (rst.next()){
                txtFirstName.setText(rst.getString("firstName"));
                txtLastName.setText(rst.getString("lastName"));
                txtAddress.setText(rst.getString("address"));
                txtContact.setText(rst.getString("contact"));
                txtEmail.setText(rst.getString("email"));
            }else {
                JOptionPane.showMessageDialog(null,"Contact Not Found","",JOptionPane.ERROR_MESSAGE);
            }
        }catch (ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null,"Driver Not Found");
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Duplicate Entry","",JOptionPane.WARNING_MESSAGE);
        }
    }

    public void backOnAction(MouseEvent mouseEvent) {
        mainMenuStage.show();
        updateContactStage.close();
    }

    public void cancelOnAction(ActionEvent actionEvent) {
        System.exit(0);
    }

}
