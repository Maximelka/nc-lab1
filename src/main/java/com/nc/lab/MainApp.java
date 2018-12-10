package com.nc.lab;

import com.nc.lab.model.Repository;
import com.nc.lab.reflection.Injector;

public class MainApp {

    public static void main(final String... args) throws Exception{
        Repository repository = Injector.inject(new Repository());
    }
}
