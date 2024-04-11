package com.fwrp.userFactory;
import com.fwrp.model.User;
import com.fwrp.model.Retailer;
import com.fwrp.model.Consumer;
import com.fwrp.model.CharitableOrganization;

public class UserFactory {
    public static User createUser(String userType) {
        switch (userType) {
            case "Retailer":
                return new Retailer();
            case "Consumer":
                return new Consumer();
            case "CharitableOrganization":
                return new CharitableOrganization();
            default:
                throw new IllegalArgumentException("Unknown user type: " + userType);
        }
    }
}
