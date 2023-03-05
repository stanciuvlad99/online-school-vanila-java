package ro.mycode.controllers;

import ro.mycode.models.Enrolment;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ControlEnrolment {

    private ArrayList<Enrolment> enrolments;

    public ControlEnrolment() {
        this.enrolments = new ArrayList<>();
        load();
    }

    private void load() {
        try {
            File file = new File("C:\\mycode\\OOP\\Incapsularea\\Teorie2\\src\\ro\\mycode\\data\\enrolment.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String linie = scanner.nextLine();
                Enrolment enrolment = new Enrolment(linie);
                this.enrolments.add(enrolment);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //todo: CRUD

    //functie ce arata daca exist in lista o anumita inscriere, primeste id student ca paramatru
    public boolean findByIdStudent(int idStudent) {
        for (int i = 0; i < enrolments.size(); i++) {
            if (enrolments.get(i).getStudentId() == idStudent) {
                return true;
            }
        }
        return false;
    }

    //functie ce adauga o inscriere pe lista, primeste constructor ca parametru
    public boolean create(Enrolment enrolment) {
        return findByIdStudent(enrolment.getStudentId()) == false ? this.enrolments.add(enrolment) : false;
    }

    //functie ce afiseaza lista de inscrieri
    public void read() {
        for (int i = 0; i < enrolments.size(); i++) {
            System.out.println(enrolments.get(i).descriere());
        }
    }

    //functie ce returnaza inscrierea dupa id student, primeste constructoe ca parametru
    public Enrolment idStudent(int idStudent) {
        for (int i = 0; i < enrolments.size(); i++) {
            if (enrolments.get(i).getStudentId() == idStudent) {
                return enrolments.get(i);
            }
        }
        return null;
    }

    //functie ce face update informatiilor, primeste constructor parametru
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
    public ArrayList<Enrolment> inscriereStudent(int idStudent) {
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
            return 1;
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


    public int idCelMaiFrecventatcurs(){

        return  pozitieElementMaxim(frecventaCursurilor());
    }




}
