package ro.mycode.view;

import ro.mycode.controllers.ControlAdmin;
import ro.mycode.controllers.ControlStudent;
import ro.mycode.models.Admin;
import ro.mycode.models.Student;

import java.util.Scanner;

public class ViewLogin {

    private ControlAdmin controlAdmin;
    private ControlStudent controlStudent;

    public ViewLogin() {
        this.controlAdmin=new ControlAdmin();
        this.controlStudent=new ControlStudent();
        play();
    }

    private void menu() {
        System.out.println("Apasati tasta 1 pentru a va loga");
    }

    private void play() {
        menu();
        boolean running = true;
        while (running) {
            Scanner scanner = new Scanner(System.in);
            int alegere = Integer.parseInt(scanner.nextLine());
            switch (alegere) {
                case 1:login();
                    break;
                default:
                    break;
            }
        }
    }

    public void login(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti adresa de email");
        String email=scanner.nextLine();
        System.out.println("Introduceti parola");
        String password=scanner.nextLine();
        Admin admin = controlAdmin.findByEmailPassword(email,password);
        if (admin!=null){

            ViewAdmin viewAdmin = new ViewAdmin(admin);
        }
        Student student = controlStudent.findByEmailPassword(email,password);
        if (student!=null){

            ViewStudent viewStudent = new ViewStudent(student);
        }
    }
}
