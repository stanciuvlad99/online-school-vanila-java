package ro.mycode.controllers;

import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.Test;
import ro.mycode.models.Student;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import static org.testng.Assert.assertEquals;


public class ControlStudentTest {

    private ControlStudent controlStudent;

    @Test
    public void testEmailStudent(){
        ArrayList<Student> students=new ArrayList<>();
        Student student = new Student("1,Labus,Georgescu,test@gmail.com,pass1234!,22");
        students.add(student);
        this.controlStudent=new ControlStudent(students);

        String expectation=String.valueOf(student.descriere());
        assertEquals(controlStudent.emailStudent("test@gmail.com").descriere(),expectation);

    }

    @Test
    public void testEmailStudentNull(){
        ArrayList<Student> students = new ArrayList<>();
        Student student = new Student("1,Labus,Georgescu,test@gmail.com,pass1234!,22");
        students.add(student);
        this.controlStudent=new ControlStudent(students);

        String expectation=null;
        assertEquals(controlStudent.emailStudent("test@gmail."),expectation);
    }

    @Test
    public void testFindStudentByEmail(){
        ArrayList<Student> students = new ArrayList<>();
        Student student = new Student("1,Labus,Georgescu,test@gmail.com,pass1234!,22");
        students.add(student);
        this.controlStudent= new ControlStudent(students);

        boolean expextation=true;
        assertEquals(controlStudent.findStudentByEmail("test@gmail.com"),expextation);
    }

    @Test
    public void testFindStudentByEmailFalse(){
        ArrayList<Student> students = new ArrayList<>();
        Student student = new Student("1,Labus,Georgescu,test@gmail.com,pass1234!,22");
        students.add(student);
        this.controlStudent=new ControlStudent(students);

        boolean expectation=false;
        assertEquals(controlStudent.findStudentByEmail("test@gmail."),expectation);
    }

    @Test
    public void testFindByFirstNameLastName(){
        ArrayList<Student> students= new ArrayList<>();
        Student student = new Student("1,Labus,Georgescu,test@gmail.com,pass1234!,22");
        students.add(student);
        this.controlStudent=new ControlStudent(students);

        String expectation=String.valueOf(student.descriere());
        assertEquals(controlStudent.findByFirstNameLastName("Labus", "Georgescu").descriere(),expectation);
    }

    @Test
    public void testFindByFirstNameLastNameNull(){
        ArrayList<Student> students = new ArrayList<>();
        Student student = new Student("1,Labus,Georgescu,test@gmail.com,pass1234!,22");
        students.add(student);
        this.controlStudent=new ControlStudent(students);

        String expectation=null;
        assertEquals(controlStudent.findByFirstNameLastName("qwert", "asdfg"),expectation);
    }

    @Test
    public void testFindByEmailPassword(){
        ArrayList<Student> students = new ArrayList<>();
        Student student = new Student("1,Labus,Georgescu,test@gmail.com,pass1234!,22");
        students.add(student);
        this.controlStudent=new ControlStudent(students);

        String expectation=String.valueOf(student.descriere());
        assertEquals(controlStudent.findByEmailPassword("test@gmail.com","pass1234!").descriere(),expectation);
    }

    @Test
    public void testFindByEmailPasswordNull(){
        ArrayList<Student> students = new ArrayList<>();
        Student student = new Student("1,Labus,Georgescu,test@gmail.com,pass1234!,22");
        students.add(student);
        this.controlStudent=new ControlStudent(students);

        String expectation=null;
        assertEquals(controlStudent.findByEmailPassword("qwert", "asdfg"),expectation);
    }

    @Test
    public void testToSave(){
        ArrayList<Student> students = new ArrayList<>();
        Student student = new Student("1,Labus,Georgescu,test@gmail.com,pass1234!,22");
        Student student1 = new Student("2,Alexandru,Pitesteanu,alexpit@gmail.com,alexp2000,21");
        students.add(student);
        students.add(student1);
        this.controlStudent=new ControlStudent(students);

        String expectation=student.toSave() + "\n" + student1.toSave();
        assertEquals(controlStudent.toSave(),expectation);

    }

    @Test
    public void testNextId(){
        ArrayList<Student> students = new ArrayList<>();
        Student student = new Student("1,Labus,Georgescu,test@gmail.com,pass1234!,22");
        students.add(student);
        this.controlStudent=new ControlStudent(students);

        int expectation=2;
        assertEquals(controlStudent.nextId(),expectation);
    }

    @Test
    public void testNextIdNull(){
        ArrayList<Student> students = new ArrayList<>();
        this.controlStudent= new ControlStudent(students);

        int expectation=-1;
        assertEquals(controlStudent.nextId(),expectation);
    }

    @Test
    public void testReturnIdStudent(){
        ArrayList<Student> students = new ArrayList<>();
        Student student = new Student("1,Labus,Georgescu,test@gmail.com,pass1234!,22");
        students.add(student);
        this.controlStudent= new ControlStudent(students);

        int expectation=1;
        assertEquals(controlStudent.returnIdStudent("Labus", "Georgescu"),expectation);
    }

    @Test
    public void testReturnIdStudentNull(){
        ArrayList<Student> students = new ArrayList<>();
        Student student = new Student("1,Labus,Georgescu,test@gmail.com,pass1234!,22");
        students.add(student);
        this.controlStudent=new ControlStudent(students);

        int expectation=-1;
        assertEquals(controlStudent.returnIdStudent("qwert", "asdf"),expectation);
    }

    @Test
    public void testCreate(){
        ArrayList<Student> students = new ArrayList<>();
        Student student = new Student("1,Labus,Georgescu,test@gmail.com,pass1234!,22");
        this.controlStudent=new ControlStudent(students);
        int expected=students.size()+1;
        controlStudent.create(student);

        assertEquals(students.size(),expected);
    }

    @Test
    public void testDelete(){
        ArrayList<Student> students = new ArrayList<>();
        Student student = new Student("1,Labus,Georgescu,test@gmail.com,pass1234!,22");
        students.add(student);
        this.controlStudent=new ControlStudent(students);
        int expected=students.size()-1;
        controlStudent.delete("test@gmail.com");

        assertEquals(students.size(),expected);
    }

    @Test
    public void testRemoveFirstNameLastName(){
        ArrayList<Student> students = new ArrayList<>();
        Student student = new Student("1,Labus,Georgescu,test@gmail.com,pass1234!,22");
        students.add(student);
        this.controlStudent=new ControlStudent(students);
        int expected=students.size()-1;
        controlStudent.removeFirstNameLastName("Labus", "Georgescu");

        assertEquals(students.size(), expected);
    }

    @Test
    public void testRemoveFirstNameLastNameNull(){
        ArrayList<Student> students = new ArrayList<>();
        Student student = new Student("1,Labus,Georgescu,test@gmail.com,pass1234!,22");
        students.add(student);
        this.controlStudent=new ControlStudent(students);
        String expected=null;

        assertEquals(controlStudent.removeFirstNameLastName("qwert","asddf"),expected);
    }

    @Test
    public void testRemoveStudent(){
        ArrayList<Student> students = new ArrayList<>();
        Student student = new Student("1,Labus,Georgescu,test@gmail.com,pass1234!,22");
        students.add(student);
        this.controlStudent=new ControlStudent(students);
        int expected=students.size()-1;
        controlStudent.removeStudent(student);

        assertEquals(students.size(), expected);
    }

    @Test
    public void testAdd(){
        ArrayList <Student> students = new ArrayList<>();
        Student student = new Student("1,Labus,Georgescu,test@gmail.com,pass1234!,22");
        this.controlStudent=new ControlStudent(students);
        int expexted= students.size()+1;
        controlStudent.add(student);

        assertEquals(students.size(),expexted);
    }

    @Test
    public void testTotiStudentii(){
        ArrayList<Student> students = new ArrayList<>();
        Student student = new Student("1,Labus,Georgescu,test@gmail.com,pass1234!,22");
        Student student1 = new Student("2,Alexandru,Pitesteanu,alexpit@gmail.com,alexp2000,21");
        Student student2 = new Student("3,Elena,Visan,elenavisan@yahoo.com,qwerty1234,19");
        students.add(student);
        students.add(student1);
        students.add(student2);
        this.controlStudent=new ControlStudent(students);
        ArrayList<Student> list = controlStudent.totiStudentii();
        boolean expected=list.size()==students.size();

        assertEquals(true,expected);
    }

    @Test
    public void testUpdate(){
        ArrayList<Student> students = new ArrayList<>();
        Student student = new Student("1,Labus,Georgescu,test@gmail.com,pass1234!,22");
        students.add(student);
        this.controlStudent=new ControlStudent(students);
        Student student1 = new Student("2,Alexandru,Pitesteanu,test@gmail.com,alexp2000,21");
        controlStudent.update(student1);


        assertEquals(student.getId(),2);
        assertEquals(student.getFirstName(),"Alexandru");
        assertEquals(student.getLastName(),"Pitesteanu");
        assertEquals(student.getPassword(),"alexp2000");
        assertEquals(student.getAge(),21);
    }

    @Test
    public void testSave(){
        String path="C:\\mycode\\OOP\\Incapsularea\\Teorie2\\test\\data\\test.student.txt";
        ArrayList<Student> students = new ArrayList<>();
        Student student = new Student("1,Labus,Georgescu,test@gmail.com,pass1234!,22");
        students.add(student);
        int expection=students.size()+1;
        this.controlStudent=new ControlStudent(students);
        Student student1 = new Student("2,Alexandru,Pitesteanu,test@gmail.com,alexp2000,21");
        students.add(student1);
        controlStudent.save(path);
        controlStudent.load(path);
        assertEquals(controlStudent.numarStudenti(),expection);

    }

    @AfterEach
    public void clear() {
        ControlStudent controlStudent = new ControlStudent(new ArrayList<>());
        controlStudent.save("C:\\mycode\\OOP\\Incapsularea\\Teorie2\\test\\data\\test.student.txt");
    }


}
