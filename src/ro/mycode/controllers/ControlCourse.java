package ro.mycode.controllers;

import ro.mycode.models.Course;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ControlCourse {
    private ArrayList<Course> courses;
    private String FILE_PATH="C:\\mycode\\OOP\\Incapsularea\\Teorie2\\src\\ro\\mycode\\data\\courses.txt";

    public ControlCourse() {
        this.courses = new ArrayList<>();
        load(FILE_PATH);
    }

    public ControlCourse(ArrayList<Course> courses){
        this.courses=courses;
    }

    public void load(String path) {
        try {
            File file = new File(path);
            Scanner scanner = new Scanner(file);
            courses.clear();
            while (scanner.hasNextLine()) {
                String linie = scanner.nextLine();
                Course course = new Course(linie);
                this.courses.add(course);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //todo: CRUD
    //functie ce arata daca exista un curs in lista, primeste curs ca parametru
    public boolean findByNameBoolean(String nume) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getName().equals(nume)) {
                return true;
            }
        }
        return false;
    }

    //functie ce adauga un curs in lista, primeste constructor ca parametru
    public boolean create(Course course) {
        return findByNameBoolean(course.getName()) == false ? this.courses.add(course) : false;
    }

    //functie ce afiseaza cursurile din lista
    public void read() {
        for (int i = 0; i < courses.size(); i++) {
            System.out.println(courses.get(i).descriere());
        }
    }

    //functie ce face update informatiilor, primeste constructor ca parametru
    public void update(Course course) {
        Course update = findByName(course.getName());

        if (course.getDepartment().equals("") == false) {
            update.setDepartment(course.getDepartment());
        }
        if ((course.getId() == 0) == false) {
            update.setId(course.getId());
        }
    }

    //todo: functie ce elimina cusruri din lista
    public Course delete(String nume) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getName().equals(nume)) {
                return courses.remove(i);
            }
        }
        return null;
    }

    //todo:functie ce primeste ca parametru  id curs si returneaza cursul cu id respectiv
    public Course findById(int idCurs) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getId() == idCurs) {
                return courses.get(i);
            }
        }
        return null;
    }

    //todo:functie care returneaza dupa nume un curs
    public Course findByName(String nume) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getName().equals(nume)) {
                return courses.get(i);
            }
        }
        return null;
    }

    //todo: functie ce returneaza id-ul cursului, primeste nume ca parametru
    public int returnIdCurs(String name) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getName().equals(name)) {
                return courses.get(i).getId();
            }
        }
        return -1;
    }


    //todo: functie ce returneaza departament, primeste nume curs ca parametru
    public Course findByDepartment(String department) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getDepartment().equals(department)) {
                return courses.get(i);
            }
        }
        return null;
    }


    //todo: functie ce face update numelui cursului, primeste constructor ca parametru
    public void updateName(Course course) {
        Course update = findByDepartment(course.getDepartment());
        if (course.getName().equals("") == false) {
            update.setName(course.getName());
        }
    }

    //todo: functie ce adauga un curs in lista, primeste constructor ca parametru
    public void add(Course course) {
        this.courses.add(course);
    }

    //todo: functie ce returneaza toate cursurile
    public String toSave(){
        if (courses.size()==0){
            return "";
        }
        int i=0;
        String cursuri="";
        for (i=0; i<courses.size()-1; i++){
            cursuri+=courses.get(i).toSave()+"\n";
        }
        cursuri+=courses.get(i).toSave();
        return cursuri;
    }

    //todo: functie ce salveaza in fisierul text courses
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

}

