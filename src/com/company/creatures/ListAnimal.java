package com.company.creatures;

import com.company.connection.Connect;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class ListAnimal {
    public LinkedList <Animal> listAnimal = new LinkedList<>();

    public void addToList(Animal animal){
        listAnimal.add(animal);
    }

    public void getListFromSelect() throws SQLException {
        String sql = "select * from animal";
        ResultSet rs = Connect.executeSQL(sql);

        while(rs.next()) {
            Pet ani = new Pet("jakistam");
            ani.name = (rs.getString("name"));
            ani.isAlive = (rs.getBoolean("isAlive"));
            ani.setWeight(rs.getDouble("weight"));
            listAnimal.add(ani);
        }
    }

    public Integer showListSize(){
        System.out.println("Wielkość tablicy to: "+listAnimal.size());
        return listAnimal.size();
    }
}
