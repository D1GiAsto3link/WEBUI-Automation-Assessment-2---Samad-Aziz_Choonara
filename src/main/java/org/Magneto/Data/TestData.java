package org.Magneto.Data;

public class TestData {

    private String productName;
    private String firstName;
    private String lastName;
    private String email;

    public TestData(String productName, String firstName, String lastName, String email) {
        this.productName = productName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getProductName() {
        return productName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }
}
