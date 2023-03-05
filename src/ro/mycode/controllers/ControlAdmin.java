package ro.mycode.controllers;

import ro.mycode.models.Admin;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ControlAdmin {

    private ArrayList<Admin> admins;

    public ControlAdmin(){
        this.admins=new ArrayList<>();
        load();
    }

    private void load(){
        try {
            File file = new File("C:\\mycode\\OOP\\Incapsularea\\Teorie2\\src\\ro\\mycode\\data\\admin.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                String text=scanner.nextLine();
                Admin admin = new Admin(text);
                this.admins.add(admin);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //todo:functie ce afiseasa toi adminii
    public void read(){
        for (int i=0; i<admins.size(); i++){
            System.out.println(admins.get(i).descriere());
        }
    }

}
