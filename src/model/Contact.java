package model;

public class Contact {
    private String firstName;
    private String lastname;
    private String address;
    private String contact;
    private String email;

    public Contact() {
    }

    public Contact(String firstName, String lastname, String address, String contact, String email) {
        this.firstName = firstName;
        this.lastname = lastname;
        this.address = address;
        this.contact = contact;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
