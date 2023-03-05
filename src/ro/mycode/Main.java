package ro.mycode;

import ro.mycode.controllers.ControlBook;
import ro.mycode.controllers.ControlCourse;
import ro.mycode.controllers.ControlEnrolment;
import ro.mycode.controllers.ControlStudent;
import ro.mycode.models.Book;
import ro.mycode.models.Course;
import ro.mycode.models.Enrolment;
import ro.mycode.models.Student;
import ro.mycode.view.ViewAdmin;
import ro.mycode.view.ViewStudent;

public class Main {

    public static void main(String[] args) {
//        Student student = new Student("4,Cristian,Dragomir,cristiandrag2005@yahoo.com,18,jordan23@");
//        System.out.println(student.descriere());

//        ControlStudent controlStudent= new ControlStudent();
//        controlStudent.create(new Student(6, "Ana", "Marinescu", "test@gmail.com", 30, "dsadsad"));
//        controlStudent.update(new Student(5, "", "", "raduenescu12@gmail.com", 23, "dsadsad"));
//        controlStudent.delete("test@gmail.com");
//        controlStudent.read();


//        ControlBook controlBook = new ControlBook();
//        controlBook.create(new Book(10,10,2010,"Camuflaj", "Joe Haldeman"));
//        controlBook.update(new Book(0, 3, 0, "Ana are mere", "Mircea Eliade" ));
//        controlBook.delete(2);
//        controlBook.read();


//        ControlCourse controlCourse = new ControlCourse();
//        controlCourse.create(new Course(6, "Qa Engineer", "Departament de informatica"));
//        controlCourse.update(new Course(10,"Programare in Python", ""));
//        controlCourse.delete("Programare in Python");
//        controlCourse.read();


//        ControlEnrolment controlEnrolment = new ControlEnrolment();
//        controlEnrolment.create(new Enrolment(10,20,30));
//        controlEnrolment.update(new Enrolment(20,4,20));
//        controlEnrolment.delete(5);
//        controlEnrolment.read();


//        ViewStudent viewStudent = new ViewStudent();
//        System.out.println(viewStudent);

        ViewAdmin viewAdmin= new ViewAdmin();
        System.out.println(viewAdmin);
    }
}