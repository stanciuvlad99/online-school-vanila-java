package ro.mycode.controllers;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.testng.annotations.AfterTest;
import ro.mycode.models.Enrolment;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ControlEnrolmentTest {


    @Test
    public void testFindByIdStudent() {
        ArrayList<Enrolment> enrolments = new ArrayList<>();
        Enrolment enrolment = new Enrolment("1,1,1");
        enrolments.add(enrolment);
        ControlEnrolment controlEnrolment = new ControlEnrolment(enrolments);
        boolean expected = true;

        assertEquals(expected, controlEnrolment.findByIdStudent(enrolment.getStudentId()));
    }

    @Test
    public void testFindByIdStudentFalse() {
        ArrayList<Enrolment> enrolments = new ArrayList<>();
        Enrolment enrolment = new Enrolment("1,1,1");
        enrolments.add(enrolment);
        ControlEnrolment controlEnrolment = new ControlEnrolment(enrolments);
        boolean expected = false;

        assertEquals(expected, controlEnrolment.findByIdStudent(2));
    }

    @Test
    public void testCreate() {
        ArrayList<Enrolment> enrolments = new ArrayList<>();
        Enrolment enrolment = new Enrolment("1,1,1");
        int expected = enrolments.size() + 1;
        ControlEnrolment controlEnrolment = new ControlEnrolment(enrolments);
        controlEnrolment.create(enrolment);

        assertEquals(expected, enrolments.size());
    }

    @Test
    public void testIdStudent() {
        ArrayList<Enrolment> enrolments = new ArrayList<>();
        Enrolment enrolment = new Enrolment("1,1,1");
        enrolments.add(enrolment);
        ControlEnrolment controlEnrolment = new ControlEnrolment(enrolments);
        String expected = String.valueOf(enrolment.descriere());

        assertEquals(expected, controlEnrolment.idStudent(1).descriere());
    }

    @Test
    public void testIdStudentNull() {
        ArrayList<Enrolment> enrolments = new ArrayList<>();
        Enrolment enrolment = new Enrolment("1,1,1");
        enrolments.add(enrolment);
        ControlEnrolment controlEnrolment = new ControlEnrolment(enrolments);
        String expected = null;

        assertEquals(expected, controlEnrolment.idStudent(2));
    }

    @Test
    public void testUpdate() {
        ArrayList<Enrolment> enrolments = new ArrayList<>();
        Enrolment enrolment = new Enrolment("1,1,1");
        enrolments.add(enrolment);
        ControlEnrolment controlEnrolment = new ControlEnrolment(enrolments);
        Enrolment enrolment1 = new Enrolment("2,1,2");
        controlEnrolment.update(enrolment1);

        int expectedId = enrolment.getId();
        int expectedCourseId = enrolment.getCourseId();

        assertEquals(expectedId, enrolment1.getId());
        assertEquals(expectedCourseId, enrolment1.getCourseId());
    }

    @Test
    public void testInscriereStudent() {
        //etapa 1 //facem o lista de inscrieri
        ArrayList<Enrolment> enrolments = new ArrayList<>();
        Enrolment enrolment = new Enrolment("1,1,1");
        Enrolment enrolment1 = new Enrolment("2,1,2");
        Enrolment enrolment2 = new Enrolment("3,3,3");
        enrolments.add(enrolment);
        enrolments.add(enrolment1);
        enrolments.add(enrolment2);

        ControlEnrolment controlEnrolment = new ControlEnrolment(enrolments);

        ArrayList<Enrolment> list = null;
        for (int i = 0; i < enrolments.size(); i++) {
            list = controlEnrolment.studentEnrolmentsFindById(1);
        }
        int expected=2;

        assertEquals(expected, list.size());

    }

    @Test
    public void testNextId() {
        ArrayList<Enrolment> enrolments = new ArrayList<>();
        Enrolment enrolment = new Enrolment("1,1,1");
        Enrolment enrolment1 = new Enrolment("2,2,2");
        int expected = 3;
        enrolments.add(enrolment);
        enrolments.add(enrolment1);
        ControlEnrolment controlEnrolment = new ControlEnrolment(enrolments);

        assertEquals(expected, controlEnrolment.nextId());

    }

    @Test
    public void testNextIdError() {
        ArrayList<Enrolment> enrolments = new ArrayList<>();
        int expexted = -1;
        ControlEnrolment controlEnrolment = new ControlEnrolment(enrolments);

        assertEquals(expexted, controlEnrolment.nextId());
    }

    @Test
    public void testEnrolmentIdCursIdStudent() {
        ArrayList<Enrolment> enrolments = new ArrayList<>();
        Enrolment enrolment = new Enrolment("1,1,1");
        enrolments.add(enrolment);
        ControlEnrolment controlEnrolment = new ControlEnrolment(enrolments);
        String expected = String.valueOf(enrolment.descriere());

        assertEquals(expected, controlEnrolment.enrolmentIdCursIdStudent(enrolment.getCourseId(),
                enrolment.getStudentId()).descriere());

    }

    @Test
    public void testEnrolmentIdCursIdStudentNull() {
        ArrayList<Enrolment> enrolments = new ArrayList<>();
        Enrolment enrolment = new Enrolment("1,1,1");
        enrolments.add(enrolment);
        ControlEnrolment controlEnrolment = new ControlEnrolment(enrolments);
        String expected = null;

        assertEquals(expected, controlEnrolment.enrolmentIdCursIdStudent(enrolment.getCourseId(),
                enrolment.getId() + 1));
    }

    @Test
    public void testEraseEnrolment() {
        ArrayList<Enrolment> enrolments = new ArrayList<>();
        Enrolment enrolment = new Enrolment("1,1,1");
        enrolments.add(enrolment);
        ControlEnrolment controlEnrolment = new ControlEnrolment(enrolments);
        String expected = null;
        controlEnrolment.eraseEnrolment(enrolment);

        assertEquals(expected, controlEnrolment.idStudent(enrolment.getId()));
    }

    @Test
    public void testAdd() {
        ArrayList<Enrolment> enrolments = new ArrayList<>();
        Enrolment enrolment = new Enrolment("1,1,1");
        ControlEnrolment controlEnrolment = new ControlEnrolment(enrolments);
        String expected = String.valueOf(enrolment.descriere());
        controlEnrolment.add(enrolment);

        assertEquals(expected, controlEnrolment.idStudent(enrolment.getId()).descriere());
    }

    @Test
    public void testFrecventaCurs() {
        ArrayList<Enrolment> enrolments = new ArrayList<>();
        Enrolment enrolment = new Enrolment("1,1,2");
        Enrolment enrolment1 = new Enrolment("2,2,2");
        Enrolment enrolment2 = new Enrolment("3,3,2");
        enrolments.add(enrolment);
        enrolments.add(enrolment1);
        enrolments.add(enrolment2);
        ControlEnrolment controlEnrolment = new ControlEnrolment(enrolments);

        int[] freccenta=controlEnrolment.frecventaCursurilor();
        int actual = freccenta[2];
        int expected=3;

        assertEquals(expected, actual);
    }

    @Test
    public void testPozitieElementMaxim() {
        ArrayList<Enrolment> enrolments = new ArrayList<>();
        Enrolment enrolment = new Enrolment("1,1,3");
        Enrolment enrolment1 = new Enrolment("2,2,3");
        Enrolment enrolment2 = new Enrolment("3,3,2");
        enrolments.add(enrolment);
        enrolments.add(enrolment1);
        enrolments.add(enrolment2);
        ControlEnrolment controlEnrolment = new ControlEnrolment(enrolments);
        int expected = 3;

        assertEquals(expected, controlEnrolment.pozitieElementMaxim(controlEnrolment.frecventaCursurilor()));
    }

    @Test
    public void testIdCelMaiFrecventatCurs() {
        ArrayList<Enrolment> enrolments = new ArrayList<>();
        Enrolment enrolment = new Enrolment("1,1,2");
        Enrolment enrolment1 = new Enrolment("2,2,2");
        Enrolment enrolment2 = new Enrolment("3,3,1");
        enrolments.add(enrolment);
        enrolments.add(enrolment1);
        enrolments.add(enrolment2);
        ControlEnrolment controlEnrolment = new ControlEnrolment(enrolments);
        int expected = 2;

        assertEquals(expected, controlEnrolment.idCelMaiFrecventatCurs());
    }

    @Test
    public void testStudentiCursanti() {
        ArrayList<Enrolment> enrolments = new ArrayList<>();
        Enrolment enrolment = new Enrolment("1,1,1");
        enrolments.add(enrolment);
        ControlEnrolment controlEnrolment = new ControlEnrolment(enrolments);
        boolean expected = true;

        assertEquals(expected, controlEnrolment.studentiCursanti(enrolment.getCourseId()));
    }

    @Test
    public void testStudentiCursantiFalse() {
        ArrayList<Enrolment> enrolments = new ArrayList<>();
        Enrolment enrolment = new Enrolment("1,1,1");
        enrolments.add(enrolment);
        ControlEnrolment controlEnrolment = new ControlEnrolment(enrolments);
        boolean expected = false;

        assertEquals(expected, controlEnrolment.studentiCursanti(2));
    }

    @Test
    public void testToSave() {
        ArrayList<Enrolment> enrolments = new ArrayList<>();
        Enrolment enrolment = new Enrolment("1,1,1,");
        Enrolment enrolment1 = new Enrolment("2,2,2");
        enrolments.add(enrolment);
        enrolments.add(enrolment1);
        ControlEnrolment controlEnrolment = new ControlEnrolment(enrolments);
        String expected = String.valueOf(enrolment.toSave()) + "\n" + String.valueOf(enrolment1.toSave());

        assertEquals(expected, controlEnrolment.toSave());
    }

    @Test
    public void testSave() {
        ArrayList<Enrolment> enrolments = new ArrayList<>();
        Enrolment enrolment = new Enrolment("1,1,1");
        Enrolment enrolment1 = new Enrolment("2,2,2");
        int expected = enrolments.size() + 2;
        enrolments.add(enrolment);
        enrolments.add(enrolment1);
        ControlEnrolment controlEnrolment = new ControlEnrolment(enrolments);
        String path = "C:\\mycode\\OOP\\Incapsularea\\Teorie2\\test\\data\\test.enrolment.txt";
        controlEnrolment.save(path);
        controlEnrolment.load(path);

        assertEquals(expected, controlEnrolment.numarInscrieri());
    }


    @AfterEach
    public void clear(){
        ControlEnrolment controlEnrolment = new ControlEnrolment(new ArrayList<>());
        controlEnrolment.save("C:\\mycode\\OOP\\Incapsularea\\Teorie2\\test\\data\\test.enrolment.txt");
    }


}