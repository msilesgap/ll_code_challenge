package commons;

import model.UserModel;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UsersCommons {

    /**
     * Set the users data
     * @return
     */
    public static UserModel setUsersData(){
        UserModel userModel = new UserModel();

        String timestamp = generateTimestamp();
        userModel.firstName = "First_" + timestamp;
        userModel.lastName = "Last_" + timestamp;
        userModel.userName = timestamp;

        userModel.password = timestamp;
        userModel.customer = UserModel.Customer.CompanyA;
        userModel.role = UserModel.Roles.Customer;
        userModel.email = timestamp + "@test.com";
        userModel.cellphone = timestamp;

        return  userModel;
    }

    /**
     * Will generate a timestamp
     * @return
     */
    public static String generateTimestamp() {
        try {

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddhhmmssSS");
            String value = simpleDateFormat.format(new Date());
            if (value.length() < 17) {
                value = simpleDateFormat.format(new Date());
            }
            return value;
        } catch (Exception ex) {
            throw ex;
        }
    }
}
