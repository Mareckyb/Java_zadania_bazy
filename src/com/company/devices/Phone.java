package com.company.devices;

import com.company.creatures.Human;

import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class Phone extends Device implements Saleable {

    public final Double screenSize;
    public Set<Application> apps = new TreeSet<>();

    public static final String DEFAULT_APP_VERSION = "LATEST";
    public static final String DEFAULT_SERVER_ADDRESS = "appserver.me.com";

    public Phone(Integer yearOfProduction, String producer, String model, Double screenSize) {
        super(yearOfProduction, producer, model);
        this.screenSize = screenSize;
    }


    @Override
    public void turnOn() {
        System.out.println("you pushed the button");
        System.out.println("black screen");
        System.out.println("black screen");
        System.out.println("black screen");
        System.out.println("beeep");
        System.out.println("helou");
        System.out.println("producer logo");
    }

    @Override
    public void sell(Human seller, Human buyer, Double price) throws Exception {
        if (seller.getCash() == null || buyer.getCash() == null) {
            throw new Exception("Musisz zdefiniować stan portfela ");
        }
        if (seller.phone == null) {
            System.out.println("Sorry nie masz telefonu");
            throw new Exception("Brak telefonu");
        }
        if (buyer.getCash() < price) {
            System.out.println("Sorry, nie masz kasy");
            throw new Exception("Brak pieniędzy");
        }
        buyer.setCash(buyer.getCash() - price);
        seller.setCash(seller.getCash() + price);
        buyer.phone = seller.phone;
        seller.phone = null;
        System.out.println("telefon sprzedano za " + price + " od " + seller.firstName + " do " + buyer.firstName);
    }

    public boolean installedApp(Application app){
        if (apps.contains(app)){ return true;}
        else return false;
    }

    public void showFreeAplications(){
        Object apk = new ArrayList();
        apk= apps.toArray();
        for (int i=0; i< apps.size(); i++) {
            System.out.println(apk);

        }
    }


    public boolean installAnApp(Human owner,Application app) {

        if (owner.getCash()>=app.price){
            apps.add(app);
            owner.setCash(owner.getCash()-app.price);
            return true;
        }
        else System.out.println("Wyhacz trochę kasy na apke biedaku :-)");
        return false;
    }



}
