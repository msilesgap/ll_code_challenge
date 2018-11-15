package usersfeature;

import commons.UsersCommons;
import model.UserModel;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.AddUserModal;
import pages.UsersPage;
import setup.TestCase;

public class UsersTests extends TestCase {

    @Test(description = "Scenario: Add a user and validate the user has been added to the table", groups = {"add_user", "users"})
    public void addNewValidUser(){
        UserModel userModel = UsersCommons.setUsersData();

        UsersPage usersPage = new UsersPage(getDriverInstance());
        AddUserModal addUserModal = usersPage.clickAddUser();
        addUserModal.createUser(userModel);
        Assert.assertTrue(usersPage.executeSearch(userModel.userName),
                "Looks like the results are empty.");
        Assert.assertTrue(usersPage.doesUserExist(userModel.userName),
                "Can't find the added user on the table, username: " + userModel.userName);
    }


    @Test(description = "Scenario: Delete user User Name: novak and validate user has been deleted", groups = {"delete_user", "users"})
    @Parameters(value = {"username"})
    public void deleteExistingUserWithinSearch(String userName){
        UsersPage usersPage = new UsersPage(getDriverInstance());
        Assert.assertTrue(usersPage.executeSearch(userName),
                "Looks like the results are empty.");
        Assert.assertTrue(usersPage.doesUserExist(userName),
                "Can't find the added user on the table, username: " + userName);
        usersPage.deleteUserByName(userName);
        Assert.assertFalse(usersPage.executeSearch(userName),
                "Results are not empty, make sure the user was deleted.");
    }

    @Test(description = "Scenario: Delete user User Name: novak and validate user has been deleted", groups = {"delete_user", "users"})
    @Parameters(value = {"username"})
    public void deleteExistingUserWithoutSearch(String userName){
        UsersPage usersPage = new UsersPage(getDriverInstance());
        usersPage.deleteUserByName(userName);
        Assert.assertFalse(usersPage.executeSearch(userName),
                "Results are not empty, make sure the user was deleted.");
    }
}
