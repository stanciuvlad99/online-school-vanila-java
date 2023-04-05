package ro.mycode.controllers;

import ro.mycode.models.Admin;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ControlAdmin {

    private final String FINAL_PATH="C:\\mycode\\OOP\\Incapsularea\\Teorie2\\src\\ro\\mycode\\data\\admin.txt";
    private ArrayList<Admin> admins;

    public ControlAdmin(ArrayList<Admin> admins){
        this.admins=admins;
    }

    public ControlAdmin(){
        this.admins=new ArrayList<>();
        load(FINAL_PATH);
    }

     public void load(String path){
        try {
            File file = new File(path);
            Scanner scanner = new Scanner(file);
            admins.clear();
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

    //todo: functie ce returneaza un admin, primeste email si password ca parametri
    public Admin findByEmailPassword(String email, String password){
        for (int i=0; i<admins.size(); i++){
            if (admins.get(i).getEmail().equals(email) && admins.get(i).getPassword().equals(password)){
                return admins.get(i);
            }
        }
        return null;
    }

    //todo: functie ce returneaza toti adminii
    public String toSave(){
        if (admins.size()==0){
            return "";
        }
        int i=0;
        String admini="";
        for (i=0; i<admins.size()-1; i++){
            admini+=admins.get(i).toSave()+"\n";
        }
        admini+=admins.get(i).toSave();
        return admini;
    }

    //todo: functie ce salveaza in fiser text admin
    public void save(String path){
        try {
            File file = new File(path);
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print(toSave());
            printWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //todo:functie ce adauga admini in lista, primeste constructor ca parametru
    public void add(Admin admin){
        this.admins.add(admin);
    }


}
