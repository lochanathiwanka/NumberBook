package controller;

import model.*;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContactController {
    public static boolean addContact(Contact contact) throws ClassNotFoundException, SQLException {
        PreparedStatement stm = DBConnection.getInstance().getConnection().prepareStatement("Insert into contactdetails Values(?,?,?,?,?)");
        stm.setObject(1,contact.getFirstName());
        stm.setObject(2,contact.getLastname());
        stm.setObject(3,contact.getAddress());
        stm.setObject(4,contact.getContact());
        stm.setObject(5,contact.getEmail());
        return stm.executeUpdate()>0;
    }
}
