package ro.mycode;

import ro.mycode.controllers.*;
import ro.mycode.models.*;
import ro.mycode.view.ViewAdmin;
import ro.mycode.view.ViewLogin;
import ro.mycode.view.ViewStudent;

public class Main {

    public static void main(String[] args) {

//        ControlStudent controlStudent =new ControlStudent();
//        controlStudent.add(new Student("10,Marcel,Pandele,marcelpandele@gmail.com,p@nd3le112,23"));
//        controlStudent.save();

//        ControlEnrolment controlEnrolment = new ControlEnrolment();
//        controlEnrolment.add(new Enrolment("10,10,10"));
//        controlEnrolment.save();

//        ControlCourse controlCourse = new ControlCourse();
//        controlCourse.add(new Course("10,Drept penal,Departamentul de drept"));
//        controlCourse.save();

//        ControlBook controlBook = new ControlBook();
//        controlBook.add(new Book("10,10,2022,To Kill a Mockingbird,Harper Lee"));
//        controlBook.save();

//        ControlAdmin controlAdmin = new ControlAdmin();
//        controlAdmin.add(new Admin("10,ioanacojocareu@hotmail.com,1i@n@cojoc@ru123,Ioana,Cojocaru"));
//        controlAdmin.save();

      ControlCourse course = new ControlCourse();
      course.read();





    }
}