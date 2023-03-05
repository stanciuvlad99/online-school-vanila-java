package ro.mycode.view;

import ro.mycode.controllers.*;
import ro.mycode.models.*;

import java.util.Scanner;

public class ViewAdmin {


    private Admin admin;
    private ControlAdmin controlAdmin;
    private ControlBook controlBook;
    private ControlCourse controlCourse;
    private ControlEnrolment controlEnrolment;
    private ControlStudent controlStudent;


    public ViewAdmin(){
        this.controlAdmin=new ControlAdmin();
        this.controlBook=new ControlBook();
        this.controlCourse=new ControlCourse();
        this.controlEnrolment=new ControlEnrolment();
        this.controlStudent=new ControlStudent();
        play();
    }

    private void menu(){
        System.out.println("Apasati tasta 1 pentru a vedea toti studentii");
        System.out.println("Apasati tasta 2 pentru a elimina un student");
        System.out.println("Apasati tasta 3 pentru a vedea toate cursurile");
    }

    private void play(){
        menu();
        boolean running=true;
        while (running){
            Scanner scanner = new Scanner(System.in);
            int alegere=Integer.parseInt(scanner.nextLine());
            switch (alegere){
                case 1:afisareStudenti();
                    break;
                case 2:eliminareStudent();
                break;
                default:break;
            }
        }
    }


    private void afisareStudenti(){
        controlStudent.read();
    }

    private void eliminareStudent(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti prenumele Studentului");
        String firstName=scanner.nextLine();
        System.out.println("Introduceti numele de familie al studentului");
        String lastName=scanner.nextLine();
        Student student=controlStudent.findByFirstNameLastName(firstName,lastName);
        if (student!=null){
            controlStudent.removeFirstNameLastName(firstName,lastName);
            System.out.println("Studentul " + firstName + " " + lastName + ", a fost elminat din baza de date");
        }else {
            System.out.println("Studentul" + firstName + " " + lastName + " nu exista in baza de date");
        }
    }

    private void afisareCursuri(){
        controlCourse.read();
    }

    private void eliminareCurs(){
        System.out.println("Introduceti numele cursului");
        Scanner scanner = new Scanner(System.in);
        String numeCurs = scanner.nextLine();
        Course course = controlCourse.findByName(numeCurs);
        if (course!=null){

        }
    }
}
