package com.company;

import com.company.connection.Connect;
import com.company.creatures.Animal;
import com.company.creatures.Human;
import com.company.creatures.ListAnimal;
import com.company.creatures.Pet;
import com.company.devices.Car;

import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;


public class Main {

    public static void main(String[] args) throws SQLException {


        Human me = new Human("Kacper", "Warda");
        me.setSalary(5000.0);

        Car opel = new Car(1988, "Opel", "Vectra", "brown", -200.0);

        me.setCar(opel, 0);

        Human brotherInLow = new Human("Pioter", "Szfagier");
        brotherInLow.setCash(500.0);

        Human marek = new Human("Marek", "Koszmarek");
        marek.setCash(4000.0);
        marek.setSalary(5000.0);

        Human stefan = new Human("Stefan", "Lotniskowiec");
        stefan.setCash(300.50);
        stefan.setSalary(2700.0);



        try {
            opel.sell(me, brotherInLow, 300.0);
        } catch (Exception e) {
            System.out.println("niestety nie udało się sprzedać");
            e.printStackTrace();
        }

        System.out.println("Liczba transakcji: " + opel.numberOfTransactions());

        try {
            Connect.connect();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
/*
        try {
            me.save();
            brotherInLow.save();
            stefan.save();
            marek.save();
        } catch (SQLClientInfoException throwables) {
            throwables.printStackTrace();
        }
*/
        Pet zuza = new Pet("pterodaktyl");
        zuza.isAlive=true;
        zuza.feed(300.0);
        zuza.name="Zuzanna";

        Pet tutu = new Pet("bazyl");
        tutu.isAlive=true;
        tutu.feed(300.0);
        tutu.name="Tutu";

        try {
            zuza.save();
        } catch (SQLClientInfoException throwables) {
            throwables.printStackTrace();
        }

        /*
        ListAnimal animals= new ListAnimal();
        try {
            animals.getListFromSelect();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        */



        LinkedList <Animal> listAnimal = new LinkedList<>();
        String sql = "SELECT * FROM public.animal";
        ResultSet rs;

            rs = Connect.executeSQL(sql);


        while(rs.next()) {
            Pet ani = new Pet("jakistam");
            ani.name = (rs.getString("name"));
            ani.isAlive = (rs.getBoolean("isAlive"));
            ani.setWeight(rs.getDouble("weight"));
            listAnimal.add(ani);
        }
        System.out.println("Wielkość tablicy to: "+listAnimal.size());





        /*
        animals.addToList(zuza);
        animals.addToList(tutu);
        animals.showListSize();
        */

        Map<String, Car> carslist = new HashMap<>();

        carslist.put("Mercedes", new Car(1997, "Mercedes", "ML", "Brown", 100000.00));
        carslist.put("Opel", new Car(1998, "Opel", "Astra", "White", 9000.00));
        carslist.put("Fiat", new Car(2007, "Fiat", "Tip", "Red", 4000.00));

        System.out.println(
        carslist.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList()));


        for (Car samochod : carslist.values()) {
            System.out.println(samochod);
        }

        TreeMap<String, Integer> countries = new TreeMap<>();
        countries.put("Polska", 3000);
        countries.put("Niemcy", 4000);
        countries.put("Rumunia",2000);
        countries.put("Słowacja", 1500);
        countries.put("Czechy", 1900);


        System.out.println("Najmniejsze państwo: ");
        countries.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .limit(1)
                .forEach(System.out::println);

        System.out.println("Największe państwo: ");
                 countries.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(1)
                .forEach(System.out::println);






    }
}
