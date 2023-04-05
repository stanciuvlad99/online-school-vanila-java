package ro.mycode.controllers;

import ro.mycode.models.Enrolment;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ControlEnrolment {

    private ArrayList<Enrolment> enrolments;
    private final String FILE_PATH="C:\\mycode\\OOP\\Incapsularea\\Teorie2\\src\\ro\\mycode\\data\\enrolment.txt";

    public ControlEnrolment() {
        this.enrolments = new ArrayList<>();
        load(FILE_PATH);
    }

    public ControlEnrolment(ArrayList<Enrolment> enrolments){
        this.enrolments=enrolments;
    }

    public void load(String path) {
        try {
            File file = new File(path);
            Scanner scanner = new Scanner(file);
            enrolments.clear();
            while (scanner.hasNextLine()) {
                String linie = scanner.nextLine();
                Enrolment enrolment = new Enrolment(linie);
                this.enrolments.add(enrolment);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //todo: functie ce arata daca exist in lista o anumita inscriere, primeste id student ca paramatru
    public boolean findByIdStudent(int idStudent) {
        for (int i = 0; i < enrolments.size(); i++) {
            if (enrolments.get(i).getStudentId() == idStudent) {
                return true;
            }
        }
        return false;
    }

    //todo: functie ce adauga o inscriere pe lista, primeste constructor ca parametru
    public boolean create(Enrolment enrolment) {
        return findByIdStudent(enrolment.getStudentId()) == false ? this.enrolments.add(enrolment) : false;
    }

    //todo: functie ce afiseaza lista de inscrieri
    public void read(String path) {
        for (int i = 0; i < enrolments.size(); i++) {
            System.out.println(enrolments.get(i).descriere());
        }
    }

    //todo: functie ce returnaza inscrierea dupa id student, primeste constructoe ca parametru
    public Enrolment idStudent(int idStudent) {
        for (int i = 0; i < enrolments.size(); i++) {
            if (enrolments.get(i).getStudentId() == idStudent) {
                return enrolments.get(i);
            }
        }
        return null;
    }

    //todo: functie ce face update informatiilor, primeste constructor parametru
    public void update(Enrolment enrolment) {
        Enrolment update = idStudent(enrolment.getStudentId());

        if ((enrolment.getId() == 0) == false) {
            update.setId(enrolment.getId());
        }
        if ((enrolment.getCourseId() == 0) == false) {
            update.setCourseId(enrolment.getCourseId());
        }
    }


    //todo:funcntie ce primeste ca parametru id unui student si returneaza toate enrolmenturile studentului
    public ArrayList<Enrolment> studentEnrolmentsFindById(int idStudent) {
        ArrayList<Enrolment> enrolmentsStudent = new ArrayList<>();
        for (int i = 0; i < enrolments.size(); i++) {
            if (enrolments.get(i).getStudentId() == idStudent) {
                enrolmentsStudent.add(enrolments.get(i));
            }
        }
        return enrolmentsStudent;
    }


    //todo:functie ce genereaza un nou id valabil
    public int nextId() {
        if (this.enrolments.size() == 0) {
            return -1;
        }
        return this.enrolments.get(this.enrolments.size() - 1).getId() + 1;
    }


    //todo:functie ce primeste ca parametru idcurs si idstudent iar returneaza enrolmentul cu  parametri introdusi
    public Enrolment enrolmentIdCursIdStudent(int idCurs, int idStudent) {
        for (int i = 0; i < enrolments.size(); i++) {
            if (enrolments.get(i).getStudentId() == idStudent && enrolments.get(i).getCourseId() == idCurs) {
                return enrolments.get(i);
            }
        }
        return null;
    }

    //todo: functie ce elimna abonarea la curs
    public void eraseEnrolment(Enrolment enrolment) {
        this.enrolments.remove(enrolment);
    }

    //todo: functie ce adauga inscriere in lista
    public void add(Enrolment enrolment) {
        this.enrolments.add(enrolment);
    }


    public int[] frecventaCursurilor(){

        int[] frecventaCursuri= new int[10000];


        for(int i=0;i<enrolments.size();i++){
            frecventaCursuri[enrolments.get(i).getCourseId()]++;
        }

        return  frecventaCursuri;
    }


    //todo:functie ce  primeste ca parametru un vector de numere intregi si returneaza pozitia elemntului maxim
    public int pozitieElementMaxim(int []vector){
        int max = vector[0];
        int maxIndex = 0;

        for (int i = 0; i < vector.length; i++) {
            if (vector[i] > max) {
                max = vector[i];
                maxIndex = i;
            }
        }

        return maxIndex;
    }


    //todo:functie ce returneaza id cursului cu frecventa maxima


    public int idCelMaiFrecventatCurs(){

        return  pozitieElementMaxim(frecventaCursurilor());
    }

    //todo: functie ce returneaza daca studentii participa la un curs, primeste curs id ca parametru
    public boolean studentiCursanti(int cursId){
        for (int i=0; i<enrolments.size(); i++){
            if (enrolments.get(i).getCourseId()==cursId){
                return true;
            }
        }
        return false;
    }

    //todo: functie ce returnaza toate inscrierile
    public String toSave(){
        if (enrolments.size()==0){
            return "";
        }
        int i=0;
        String enrolments="";
        for (i = 0; i< this.enrolments.size()-1; i++){
            enrolments+= this.enrolments.get(i).toSave()+"\n";
        }
        enrolments+= this.enrolments.get(i).toSave();
        return enrolments;
    }

    //todo: functie ce salveaza in fisier text enrolment
    public void save(String path){
        try {
            File file = new File(path);
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print(this.toSave());
            printWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //todo: functie ce returneaza toate inscrierile
    public int numarInscrieri(){
        return this.enrolments.size();
    }

}
