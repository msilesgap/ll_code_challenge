package model;

import com.google.common.base.MoreObjects;


public class UserModel extends Entity{
    public String firstName;
    public String lastName;
    public String userName;
    public String password;
    public Customer customer;
    public Roles role;
    public String email;
    public String cellphone;

    public UserModel(){
        firstName = "";
        lastName = "";
        userName = "";
        password = "";
        customer = Customer.CompanyA;
        role = role.Admin;
        email = "";
        cellphone = "";
    }

    public enum Customer {
        CompanyA,
        CompanyB
    }

    public enum Roles {
        SalesTeam,
        Customer,
        Admin
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("firstName", firstName)
                .add("lastName", lastName)
                .add("userName", userName)
                .add("password", password)
                .add("email", email)
                .add("cellphone", cellphone)
                .toString();
    }
}
