package org.example.lld.carRentalSystem;

import java.util.List;
public class User {
    int userId;

    String userName;
    int drivingLicense;

    public User(int userId, String userName, int drivingLicense) {
        this.userId = userId;
        this.userName = userName;
        this.drivingLicense = drivingLicense;
    }

    List<Vehicle> rental;
    List<Vehicle> published;

}
