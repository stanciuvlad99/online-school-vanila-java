package ro.mycode.view;

import ro.mycode.controllers.ControlBook;
import ro.mycode.controllers.ControlCourse;
import ro.mycode.controllers.ControlEnrolment;
import ro.mycode.models.Book;
import ro.mycode.models.Course;
import ro.mycode.models.Enrolment;
import ro.mycode.models.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class ViewStudent {


    private Student student;
    private ControlCourse controlCourse;
    private ControlBook controlBook;
    private ControlEnrolment controlEnrolment;


    public ViewStudent(Student student) {
        this.student=student;
        this.controlCourse = new ControlCourse();
        this.controlBook = new ControlBook();
        this.controlEnrolment = new ControlEnrolment();
        play();
    }


    private void meniu() {
        System.out.println("Apasati tasta 1 pentru a vedea cursurile");
        System.out.println("Apasati tasta 2 pentru a vedea cursurile l-a care sunteti inscris");
        System.out.println("Apasati tasta 3 pentru a te inscrie la un curs");
        System.out.println("Apasati tasta 4 pentru a renunta la un curs");
        System.out.println("Apasati tasta 5 pentru a vedea lista de carti");
        System.out.println("Apasati tasta 6 pentru a vedea ce carti aveti");
        System.out.println("Apasati tasta 7 pentru a adauga o carte in baza de date");
        System.out.println("Apasati tasta 8 pentru a elimina o carte din baza de date");
        System.out.println("Apasati tasta 9 pentru a face update");
        System.out.println("Apasati tasta 10 pentru a vedea cel mai frecventat curs");
    }

    private void play() {
        meniu();
        boolean running = true;
        while (running) {

            Scanner scanner = new Scanner(System.in);
            int numar = Integer.parseInt(scanner.nextLine());
            switch (numar) {
                case 1:
                    afisareCusrsuri();
                    break;
                case 2:
                    afisareEnrolments();
                    break;
                case 3:
                    inscriereCurs();
                    break;
                case 4:
                    dezabonareCurs();
                    break;
                case 5:
                    afisareCarti();
                    break;
                case 6:
                    cartiStudent();
                    break;
                case 7:
                    adaugareCarte();
                    break;
                case 8:
                    eliminareCarte();
                    break;
                case 9:
                    update();
                    break;
                case 10:
                    cursFrecventat();
                default:
                    break;

            }
        }
    }


    private void afisareCusrsuri() {
        controlCourse.read();
    }

    private void afisareEnrolments() {
        ArrayList<Enrolment> enrolments = controlEnrolment.inscriereStudent(student.getId());
        for (int i = 0; i < enrolments.size(); i++) {
            Course course = controlCourse.findByid(enrolments.get(i).getCourseId());
            System.out.println(course.descriere());
        }

    }

    private void inscriereCurs() {
        System.out.println("La ce cusrs doriti sa va inscrieti?");
        Scanner scanner = new Scanner(System.in);
        String numeCurs = scanner.nextLine();

        Course course = controlCourse.findByName(numeCurs);

        if (course != null) {
            Enrolment enrolment = new Enrolment(
                    controlEnrolment.nextId(),
                    this.student.getId(),
                    course.getId());

            this.controlEnrolment.add(enrolment);
            System.out.println("Inscriere cu succes!");

        } else {

            System.out.println("cursul nu exista");
        }
    }

    private void dezabonareCurs() {
        System.out.println("Intreoduceti numele cursrului");
        Scanner scanner = new Scanner(System.in);
        String numeCurs = scanner.nextLine();

        Course course = controlCourse.findByName(numeCurs);

        if (course != null) {

            Enrolment enrolment = controlEnrolment.enrolmentIdCursIdStudent(course.getId(), this.student.getId());

            if (enrolment != null) {

                this.controlEnrolment.eraseEnrolment(enrolment);
                System.out.println("dezabonare cu succes");
            } else {
                System.out.println("Nu sunteti inscris la acest curs " + course.getName());
            }
        } else {
            System.out.println("Cursul nu exista");
        }
    }

    private void afisareCarti() {
        controlBook.read();
    }

    private void cartiStudent() {
        ArrayList<Book> cartiStudent = controlBook.cartiStudent(student.getId());
        for (int i = 0; i < cartiStudent.size(); i++) {
            Book book = controlBook.findById(cartiStudent.get(i).getId());
            System.out.println(book.descriere());
        }
    }

    private void adaugareCarte() {
        System.out.println("Introduceti numele carii pe care doriti sa o adaugati in baza de date");
        Scanner scanner = new Scanner(System.in);
        String titluCarte = scanner.nextLine();
        Book book = controlBook.findByName(titluCarte);
        if (book == null) {
            System.out.println("Introduceti anul cartii");
            int bookYear = Integer.parseInt(scanner.nextLine());

            System.out.println("Introduceti titlul cartii");
            String bookTitle = scanner.nextLine();

            System.out.println("Introduceti autorul");
            String bookAuthor = scanner.nextLine();

            Book book1 = new Book(controlBook.nextId(), this.student.getId(), bookYear, bookTitle, bookAuthor);
            this.controlBook.add(book1);
            System.out.println("Cartea a fost introdusa in baza ta de date");
        } else {
            System.out.println("Cartea cu numele introdus deja exista");
        }
    }

    private void eliminareCarte() {
        System.out.println("Inroduceti numele carii pe care doriti sa o eliminati din baza de date");
        Scanner scanner = new Scanner(System.in);
        String titluCarte = scanner.nextLine();

        Book book = controlBook.findByName(titluCarte);
        if (book != null) {
            controlBook.eraseBook(book.getTitle(), book.getStudentId());
            System.out.println("Cartea a fost eliminata din baza de date");
        } else {
            System.out.println("Cartea nu exista in baza de date ");
        }
    }

    private void update() {
        System.out.println("Introduceti titlul cartii");
        Scanner scanner = new Scanner(System.in);
        String titluCarte = scanner.nextLine();

        Book book = controlBook.findByName(titluCarte);
        if (book != null) {
            System.out.println("Introduceti anul cartii, daca nu doriti sa il schimabti apasati 0");
            int year = Integer.parseInt(scanner.nextLine());
            System.out.println("Introduceti autorul, nu doriti sa il schimbati apasati enter");
            String autor = scanner.nextLine();
            controlBook.update(new Book(book.getId(), book.getStudentId(), year, book.getTitle(), autor));
            System.out.println("Cartii is s-a facut update cu succes");
        } else {
            System.out.println("Cartea nu exista");
        }
    }


    private void cursFrecventat() {
        Course course = controlCourse.findByid(controlEnrolment.idCelMaiFrecventatcurs());
        System.out.println(course.descriere());

    }
}




