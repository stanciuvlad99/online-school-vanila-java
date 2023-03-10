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


    public ViewAdmin() {
        this.controlAdmin = new ControlAdmin();
        this.controlBook = new ControlBook();
        this.controlCourse = new ControlCourse();
        this.controlEnrolment = new ControlEnrolment();
        this.controlStudent = new ControlStudent();
        play();
    }

    private void menu() {
        System.out.println("Apasati tasta 1 pentru a vedea toti studentii");
        System.out.println("Apasati tasta 2 pentru a elimina un student");
        System.out.println("Apasati tasta 3 pentru a vedea toate cursurile");
        System.out.println("Apasati tasta 4 pentru a elimina un curs");
        System.out.println("Apasati tasta 5 pentru a face update unui curs");
        System.out.println("Apasati tasta 6 pentru a adauga un concurs");
        System.out.println("Apasati tasta 7 pentru a adauga un adauga un nou student in baza de date");
    }

    private void play() {
        menu();
        boolean running = true;
        while (running) {
            Scanner scanner = new Scanner(System.in);
            int alegere = Integer.parseInt(scanner.nextLine());
            switch (alegere) {
                case 1:
                    afisareStudenti();
                    break;
                case 2:
                    eliminareStudent();
                    break;
                case 3:
                    afisareCursuri();
                    break;
                case 4:
                    eliminareCurs();
                    break;
                case 5:
                    updateCurs();
                    break;
                case 6:
                    adugareCurs();
                    break;
                case 7:adaugareStudent();
                break;
                default:
                    break;
            }
        }
    }


    private void afisareStudenti() {
        controlStudent.read();
    }

    private void eliminareStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti prenumele Studentului");
        String firstName = scanner.nextLine();
        System.out.println("Introduceti numele de familie al studentului");
        String lastName = scanner.nextLine();
        Student student = controlStudent.findByFirstNameLastName(firstName, lastName);
        if (student != null) {
            controlStudent.removeFirstNameLastName(firstName, lastName);
            System.out.println("Studentul " + firstName + " " + lastName + ", a fost elminat din baza de date");
        } else {
            System.out.println("Studentul" + firstName + " " + lastName + " nu exista in baza de date");
        }
    }

    private void afisareCursuri() {
        controlCourse.read();
    }

    private void eliminareCurs() {
        System.out.println("Introduceti numele cursului");
        Scanner scanner = new Scanner(System.in);
        String numeCurs = scanner.nextLine();
        Course course = controlCourse.findByName(numeCurs);
        if (course != null) {
            boolean enrolment = controlEnrolment.studentiCursanti(controlCourse.idCurs(numeCurs));
            if (enrolment == false) {
                controlCourse.delete(numeCurs);
                System.out.println("Cursul a fost eliminat din baza de date");
            } else {
                System.out.println("Cursul nu poate fi elimianat din baza de date deoarece exista elevi inscrisi");
            }
        } else {
            System.out.println("Cursul nu exista in baza de date");
        }
    }

    private void updateCurs() {
        System.out.println("Introduceti numele cursului");
        Scanner scanner = new Scanner(System.in);
        String numeCurs = scanner.nextLine();
        Course course = controlCourse.findByName(numeCurs);
        if (course != null) {
            System.out.println("Introcuceti noul nume al cursului");
            String numeNou = scanner.nextLine();
            controlCourse.updateName(new Course(course.getId(), numeNou, course.getDepartment()));
            System.out.println("Inreoduceti noul departament al cursului");
            String departament = scanner.nextLine();
            System.out.println("Introduceti noul id al cursului");
            int id = Integer.parseInt(scanner.nextLine());
            controlCourse.updateIdDepartament(new Course(id, course.getName(), departament));
            System.out.println("Cursului i s-a facut update");
        } else {
            System.out.println("Cursul " + numeCurs + " nu exista");
        }
    }

    public void adugareCurs() {
        System.out.println("Introduceti numele cursului");
        Scanner scanner = new Scanner(System.in);
        String numeCurs = scanner.nextLine();
        Course course = controlCourse.findByName(numeCurs);
        if (course == null) {
            System.out.println("Inroduceti departamentul");
            String department = scanner.nextLine();
            Course course1 = new Course(controlEnrolment.nextId(), numeCurs, department);
            this.controlCourse.add(course1);
            System.out.println("Cursul a fost adugat cu succes in baza de date");
        } else {
            System.out.println("Cursul " + numeCurs + " exista deja in baza de date");
        }
    }

    private void adaugareStudent() {
        System.out.println("Introduceti prenumele studentului");
        Scanner scanner = new Scanner(System.in);
        String prenume = scanner.nextLine();
        System.out.println("Introduceti numele de familie al studentului");
        String nume = scanner.nextLine();
        Student student = controlStudent.findByFirstNameLastName(prenume,nume);
        if (student==null){
            System.out.println("Introduceti adresa de mail a studentului");
            String email=scanner.nextLine();
            System.out.println("Introdduceti parola");
            String password=scanner.nextLine();
            System.out.println("Introduceti varsta studentului");
            int varsta = Integer.parseInt(scanner.nextLine());
            Student student1 = new Student(controlStudent.nextId(),prenume,nume,email,varsta,password);
            controlStudent.add(student1);
            System.out.println("Studentul a fost adugat in baza de date");
        }else {
            System.out.println(prenume + " " + nume + " exista deja in baza de date");
        }

    }

}
