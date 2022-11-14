package com.stevedev.service;

import com.stevedev.configuration.AppSecrets;

public class MyService {

    public MyService(AppSecrets appSecrets) {
        System.out.println(appSecrets);
    }
}
