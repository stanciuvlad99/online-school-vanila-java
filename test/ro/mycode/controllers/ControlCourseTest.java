package ro.mycode.controllers;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import ro.mycode.models.Course;

import java.util.ArrayList;

import static org.testng.Assert.assertEquals;

class ControlCourseTest {

    @Test
    public void testFindByNameBoolean(){
        ArrayList<Course> courses = new ArrayList<>();
        Course course = new Course("1,Introducere in filosofie,Departamentul de filosofie");
        courses.add(course);
        ControlCourse controlCourse = new ControlCourse(courses);
        boolean expected=true;

        assertEquals(expected,controlCourse.findByNameBoolean("Introducere in filosofie"));
    }

    @Test
    public void testFindByNameBooleanFalse(){
        ArrayList<Course> courses = new ArrayList<>();
        Course course = new Course("1,Introducere in filosofie,Departamentul de filosofie");
        courses.add(course);
        ControlCourse controlCourse = new ControlCourse(courses);
        boolean expected=false;

        assertEquals(expected,controlCourse.findByNameBoolean("qwerty"));
    }

    @Test
    public void testCreate(){
        ArrayList<Course> courses = new ArrayList<>();
        Course course = new Course("1,Introducere in filosofie,Departamentul de filosofie");
        ControlCourse controlCourse = new ControlCourse(courses);
        controlCourse.create(course);
        String expected=String.valueOf(course.descriere());

        assertEquals(expected,controlCourse.findByName("Introducere in filosofie").descriere());
    }

    @Test
    public void testCreateFalse(){
        Course course = new Course("1,Introducere in filosofie,Departamentul de filosofie");
        Course course1 = new Course("2,Introducere in filosofie,Departamentul de filosofie");
        ControlCourse controlCourse = new ControlCourse(new ArrayList<>());
        controlCourse.create(course);
        controlCourse.create(course1);

        String expected=null;
        assertEquals(expected,controlCourse.findById(2));
    }

    @Test
    public void testFindByName(){
        ArrayList<Course> courses = new ArrayList<>();
        Course course = new Course("1,Introducere in filosofie,Departamentul de filosofie");
        courses.add(course);
        ControlCourse controlCourse = new ControlCourse(courses);
        String expected=course.descriere();

        assertEquals(expected,controlCourse.findByName("Introducere in filosofie").descriere());
    }

    @Test
    public void testFindByNameNull(){
        ArrayList<Course> courses = new ArrayList<>();
        Course course = new Course("1,Introducere in filosofie,Departamentul de filosofie");
        courses.add(course);
        ControlCourse controlCourse = new ControlCourse(courses);
        String expected=null;

        assertEquals(expected,controlCourse.findByName("qwerty"));
    }

    @Test
    public void testUpdate(){
        ArrayList<Course> courses = new ArrayList<>();
        Course course = new Course("1,Introducere in filosofie,Departamentul de filosofie");
        courses.add(course);
        ControlCourse controlCourse = new ControlCourse(courses);
        Course course1 = new Course("5,Introducere in filosofie,qwerty");
        controlCourse.update(course1);
        int expectedId=5;
        String expectedDepartment="qwerty";

        assertEquals(expectedId,course.getId());
        assertEquals(expectedDepartment,course.getDepartment());
    }

    @Test
    public void testDelete(){
        ArrayList<Course> courses = new ArrayList<>();
        Course course = new Course("1,Introducere in filosofie,Departamentul de filosofie");
        courses.add(course);
        ControlCourse controlCourse = new ControlCourse(courses);
        controlCourse.delete("Introducere in filosofie");
        String expected=null;

        assertEquals(expected,controlCourse.findByName("Introducere in filosofie"));
    }

    @Test
    public void testDeleteNull(){
        ArrayList<Course> courses = new ArrayList<>();
        Course course = new Course("1,Introducere in filosofie,Departamentul de filosofie");
        courses.add(course);
        ControlCourse controlCourse = new ControlCourse(courses);
        controlCourse.delete("Introducere");
        String expected=String.valueOf(course.descriere());

        assertEquals(expected,controlCourse.findByName("Introducere in filosofie").descriere());
    }

    @Test
    public void testFindById(){
        ArrayList<Course> courses = new ArrayList<>();
        Course course = new Course("1,Introducere in filosofie,Departamentul de filosofie");
        courses.add(course);
        ControlCourse controlCourse = new ControlCourse(courses);
        String expexted=String.valueOf(course.descriere());

        assertEquals(expexted,controlCourse.findById(1).descriere());
    }

    @Test
    public void testFindByIdNull(){
        ArrayList<Course> courses = new ArrayList<>();
        Course course = new Course("1,Introducere in filosofie,Departamentul de filosofie");
        courses.add(course);
        ControlCourse controlCourse = new ControlCourse(courses);
        String expected = null;

        assertEquals(expected,controlCourse.findById(2));
    }

    @Test
    public void testReturnIdCurs(){
        ArrayList<Course> courses = new ArrayList<>();
        Course course = new Course("1,Introducere in filosofie,Departamentul de filosofie");
        courses.add(course);
        ControlCourse controlCourse = new ControlCourse(courses);
        int expected=course.getId();

        assertEquals(expected,controlCourse.returnIdCurs("Introducere in filosofie"));
    }

    @Test
    public void testReturnIdCursError(){
        ArrayList<Course> courses = new ArrayList<>();
        Course course = new Course("1,Introducere in filosofie,Departamentul de filosofie");
        courses.add(course);
        ControlCourse controlCourse = new ControlCourse(courses);
        int expected=-1;

        assertEquals(expected,controlCourse.returnIdCurs("qwerty"));
    }

    @Test
    public void testFindByDepartment(){
        ArrayList<Course> courses = new ArrayList<>();
        Course course = new Course("1,Introducere in filosofie,Departamentul de filosofie");
        courses.add(course);
        ControlCourse controlCourse = new ControlCourse(courses);
        String expected = String.valueOf(course.descriere());

        assertEquals(expected,controlCourse.findByDepartment("Departamentul de filosofie").descriere());
    }

    @Test
    public void testFindByDepartmentNull(){
        ArrayList<Course> courses = new ArrayList<>();
        Course course = new Course("1,Introducere in filosofie,Departamentul de filosofie");
        courses.add(course);
        ControlCourse controlCourse = new ControlCourse(courses);
        String expected=null;

        assertEquals(expected,controlCourse.findByDepartment("qwerty"));
    }

    @Test
    public void testUpdateName(){
        ArrayList<Course> courses = new ArrayList<>();
        Course course = new Course("1,Introducere in filosofie,Departamentul de filosofie");
        Course course1 = new Course("1,qwerty,Departamentul de filosofie");
        courses.add(course);
        ControlCourse controlCourse = new ControlCourse(courses);
        controlCourse.updateName(course1);
        String expected="qwerty";

        assertEquals(expected,course1.getName());
    }

    @Test
    public void testAdd(){
        ArrayList<Course> courses = new ArrayList<>();
        Course course = new Course("1,Introducere in filosofie,Departamentul de filosofie");
        ControlCourse controlCourse = new ControlCourse(courses);
        controlCourse.add(course);
        String expected=String.valueOf(course.descriere());

        assertEquals(expected,controlCourse.findByName("Introducere in filosofie").descriere());
    }

    @Test
    public void testToSave(){
        ArrayList<Course> courses = new ArrayList<>();
        Course course = new Course("1,Introducere in filosofie,Departamentul de filosofie");
        Course course1 = new Course("2,Algebra lineara,Departamentul de matematica");
        courses.add(course);
        courses.add(course1);
        ControlCourse controlCourse = new ControlCourse(courses);
        String expected=String.valueOf(course.toSave()) + "\n" + String.valueOf(course1.toSave());

        assertEquals(expected,controlCourse.toSave());
    }

    @Test
    public void testToSaveNull(){
        ArrayList<Course> courses = new ArrayList<>();
        ControlCourse controlCourse = new ControlCourse(courses);
        String expected="";

        assertEquals(expected,controlCourse.toSave());
    }

    @Test
    public void testSave(){
        ArrayList<Course> courses = new ArrayList<>();
        Course course = new Course("1,Introducere in filosofie,Departamentul de filosofie");
        Course course1 = new Course("2,Algebra lineara,Departamentul de matematica");
        courses.add(course);
        courses.add(course1);
        ControlCourse controlCourse = new ControlCourse(courses);
        String path="C:\\mycode\\OOP\\Incapsularea\\Teorie2\\test\\data\\test.course.txt";
        controlCourse.save(path);
        controlCourse.load(path);
        String expected=course.toSave();
        String expected1=course1.toSave();

        assertEquals(expected,controlCourse.findById(1).toSave());
        assertEquals(expected1,controlCourse.findById(2).toSave());

    }

    @AfterEach
    public void clear(){
        ControlCourse controlCourse = new ControlCourse(new ArrayList<>());
        controlCourse.save("C:\\mycode\\OOP\\Incapsularea\\Teorie2\\test\\data\\test.course.txt");
    }

}
