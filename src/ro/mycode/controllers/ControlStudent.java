package ro.mycode.controllers;

import ro.mycode.models.Student;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ControlStudent {


    private ArrayList<Student> students;

    public ControlStudent() {
        this.students = new ArrayList<>();

        load();
    }


    public void load() {

        try {

            File file = new File("C:\\mycode\\OOP\\Incapsularea\\Teorie2\\src\\ro\\mycode\\data\\studenti.txt");


            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {

                String linie = scanner.nextLine();


                Student student = new Student(linie);


                this.students.add(student);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }


    //todo:CRUD
    //functie ce arata daca este un email existent in lista, primeste ca parematru email
    public boolean findStudentByEmail(String email){
        for (int i=0; i<students.size(); i++){
            if (students.get(i).getEmail().equals(email)){
                return true;
            }
        }
        return false;
    }

    //functie ce creaza un student, primeste constructor ca parametru
    public boolean create(Student student) {
        return  findStudentByEmail(student.getEmail())==false?this.students.add(student):false;
    }

    //functie ce afisera studentii din lista
    public void read() {
        for (int i = 0; i < this.students.size(); i++) {
            System.out.println(this.students.get(i).descriere());
        }
    }

    //functie ce returneza studentul, primeste email ca parametru
    public Student emailStudent(String email) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getEmail().equals(email)) {
                return students.get(i);
            }
        }
        return null;
    }

    //functie ce face update informatiilor studentilor, primeste constructor ca parametru
    public void update(Student student){
        Student update = emailStudent(student.getEmail());

        if ((student.getAge()==0)==false){
            update.setAge(student.getAge());
        }
        if ((student.getId()==0)==false){
            update.setId(student.getId());
        }
        if (student.getPassword().equals("")==false){
            update.setPassword(student.getPassword());
        }
        if (student.getFirstName().equals("")==false){
            update.setFirstName(student.getFirstName());
        }
        if (student.getLastName().equals("")==false){
            update.setLastName(student.getLastName());
        }
    }

    //functie ce elimina student din lista, primeste email ca parametru
    public void delete(String email){
        for (int i=0; i<students.size(); i++){
            if (students.get(i).getEmail().equals(email)){
                students.remove(i);
            }
        }
    }

    //todo: functie ce returnaza studentul, primeste student id ca parametru
    public Student findByFirstNameLastName(String firstName, String lastName){
        for (int i=0; i<students.size(); i++){
            if (students.get(i).getFirstName().equals(firstName) && students.get(i).getLastName().equals(lastName)){
                return students.get(i);
            }
        }
        return null;
    }

    //todo: functie ce eliminna un student, primeste student id ca parametru
    public Student removeFirstNameLastName(String firstName, String lastName){
        for (int i=0; i<students.size(); i++){
            if (students.get(i).getFirstName().equals(firstName) && students.get(i).getLastName().equals(lastName)){
                return students.remove(i);
            }
        }
        return null;
    }

    //todo: functie ce elimina un student, primeste constructor ca parametru
    public void removeStudent(Student student){
        this.students.remove(student);
    }

    //todo: functie ce returneaza id valabil
    public int nextId(){
        if (students.size()==0){
            return -1;
        }
        return students.get(students.size()-1).getId()+1;
    }

    //todo: functie ce adauga un stududent in lista, primeste constructor ca parametru
    public void add(Student student){
        this.students.add(student);
    }

    //todo: functie ce returneaza id-ul studentului, primeste ca parametru firstName si lastName
    public int returnIdStudent(String firstName, String lastname){
        for (int i=0; i<students.size(); i++){
            if (students.get(i).getFirstName().equals(firstName) && students.get(i).getLastName().equals(lastname)){
                return students.get(i).getId();
            }
        }
        return -1;
    }
}

