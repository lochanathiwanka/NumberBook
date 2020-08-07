package controller;

import view.DBData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;

import javax.swing.*;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class ViewContactFormController extends StageList implements Initializable {

    @FXML
    private TableView<DBData> contactTable;

    @FXML
    private TableColumn<DBData, String> colFirstName;

    @FXML
    private TableColumn<DBData, String> colLastName;

    @FXML
    private TableColumn<DBData, String> colAddress;

    @FXML
    private TableColumn<DBData, String> colContact;

    @FXML
    private TableColumn<DBData, String> colEmail;

    ObservableList<DBData> row= FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        editableColumns();
        String SQl = "select * from contactdetails order by firstName asc,lastName asc";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/numberbook", "root", "1234");
            Statement stm = connection.createStatement();
            ResultSet rst = stm.executeQuery(SQl);
            while (rst.next()){
                row.add(new DBData(rst.getString("firstName"),rst.getString("lastName"),
                        rst.getString("address"),rst.getString("contact"),
                        rst.getString("email")));
            }
        }catch (ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null,"Driver Not Found");
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Duplicate Entry","",JOptionPane.WARNING_MESSAGE);
        }

        colFirstName.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
        colLastName.setCellValueFactory(new PropertyValueFactory<>("LastName"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("Address"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("Contact"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
        contactTable.setItems(row);
        contactTable.getSelectionModel().getSelectedItem();
    }

    public void editableColumns(){
        colFirstName.setCellFactory(TextFieldTableCell.forTableColumn());
        colFirstName.setOnEditCommit(e->{
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setFirstName(e.getNewValue());
        });

        contactTable.setEditable(true);
    }

    public void backOnAction(MouseEvent mouseEvent) {
        mainMenuStage.show();
        viewContactStage.close();
    }

    public void cancelOnAction(ActionEvent actionEvent) {
        System.exit(0);
    }
}
