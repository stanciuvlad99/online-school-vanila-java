package ro.mycode.controllers;

import ro.mycode.models.Course;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ControlCourse {
    private ArrayList<Course> courses;

    public ControlCourse() {
        this.courses = new ArrayList<>();
        load();
    }

    private void load() {
        try {
            File file = new File("C:\\mycode\\OOP\\Incapsularea\\Teorie2\\src\\ro\\mycode\\data\\courses.txt");
            Scanner scanner = new Scanner(file);
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

    //functie ce returneaza cursul, primeste nume ca parametru
    public Course numeCurs(String nume) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getName().equals(nume)) {
                return courses.get(i);
            }
        }
        return null;
    }

    //functie ce face update informatiilor, primeste constructor ca parametru
    public void update(Course course) {
        Course update = numeCurs(course.getName());

        if (course.getDepartment().equals("") == false) {
            update.setDepartment(course.getDepartment());
        }
        if ((course.getId() == 0) == false) {
            update.setId(course.getId());
        }
    }

    //functie ce elimina cusruri din lista
    public Course delete(String nume) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getName().equals(nume)) {
                return courses.remove(i);
            }
        }
        return null;
    }

    //todo:functie ce primeste ca parametru  id curs si returneaza cursul cu id respectiv
    public Course findByid(int idCurs) {
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

    //todo:functie ce elimina cursul din baza de date, primeste numele cursului ca parametru
    public Course removeCursByName(String numeCurs) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getName().equals(numeCurs)) {
                return courses.remove(i);
            }
        }
        return null;
    }

    //todo: functie ce returneaza id-ul cursului, primeste nume ca parametru
    public int idCurs(String name) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getName().equals(name)) {
                return courses.get(i).getId();
            }
        }
        return -1;
    }

//    public Course returnIdCurs(String name){
//        for (int i=0; i<courses.size(); i++){
//            if (courses.get(i).getName().equals(name));
//            return courses.get(i).getId()
//        }
//        return null
//    }

    //todo: functie ce face update cursurilor, primeste constructor ca parametru
    public void updateIdDepartament(Course course) {
        Course update=findByName(course.getName());
        if ((course.getId()==0)==false){
            update.setId(course.getId());
        }
        if (course.getDepartment().equals("")==false){
            update.setDepartment(course.getDepartment());
        }
    }

    //todo: functie ce returneaza departament, primeste nume curs ca parametru
    public Course returnNumeCurs(String department) {
        for (int i=0; i<courses.size(); i++){
            if (courses.get(i).getDepartment().equals(department)){
                return courses.get(i);
            }
        }
        return null;
    }


    //todo: functie ce face update numelui cursului, primeste constructor ca parametru
    public void updateName(Course course){
        Course update = returnNumeCurs(course.getDepartment());
        if (course.getName().equals("")==false){
            update.setName(course.getName());
        }
    }

    }
