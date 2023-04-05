package ro.mycode.controllers;

import org.junit.jupiter.api.Test;
import ro.mycode.models.Admin;

import java.util.ArrayList;

import static org.testng.Assert.assertEquals;

class ControlAdmintest {

    @Test
    public void testFindByEmailPassword() {
        ArrayList<Admin> admins = new ArrayList<>();
        Admin admin = new Admin("1,ionelstaion@gmail.com,10n3l5t014n,Ionela,Stoian");
        admins.add(admin);
        ControlAdmin controlAdmin = new ControlAdmin(admins);
        String expected = admin.descriere();

        assertEquals(controlAdmin.findByEmailPassword(admin.getEmail(), admin.getPassword()).descriere(), expected);
    }

    @Test
    public void testAdd() {
        ArrayList<Admin> admins = new ArrayList<>();
        Admin admin = new Admin("1,ionelstaion@gmail.com,10n3l5t014n,Ionela,Stoian");
        ControlAdmin controlAdmin = new ControlAdmin(admins);
        controlAdmin.add(admin);
        String expected = admin.descriere();

        assertEquals(controlAdmin.findByEmailPassword(admin.getEmail(), admin.getPassword()).descriere(), expected);
    }

    @Test
    public void testToSave() {
        ArrayList<Admin> admins = new ArrayList<>();
        Admin admin = new Admin("1,ionelstaion@gmail.com,10n3l5t014n,Ionela,Stoian");
        Admin admin1 = new Admin("2,mirelparaschiv@hotmail.com,m1r3lp4r45ch1v,Mirel,Paraschiv");
        admins.add(admin);
        admins.add(admin1);
        ControlAdmin controlAdmin = new ControlAdmin(admins);
        String expected = admin.toSave() + "\n" + admin1.toSave();

        assertEquals(controlAdmin.toSave(), expected);
    }

    @Test
    public void testToSaveNull() {
        ArrayList<Admin> admins = new ArrayList<>();
        ControlAdmin controlAdmin = new ControlAdmin(admins);
        String expected = "";

        assertEquals(controlAdmin.toSave(), expected);
    }

    @Test
    public void testSave() {
        ArrayList<Admin> admins = new ArrayList<>();
        Admin admin = new Admin("1,ionelstaion@gmail.com,10n3l5t014n,Ionela,Stoian");
        Admin admin1 = new Admin("2,mirelparaschiv@hotmail.com,m1r3lp4r45ch1v,Mirel,Paraschiv");
        admins.add(admin);
        admins.add(admin1);
        ControlAdmin controlAdmin = new ControlAdmin(admins);
        String path = "C:\\mycode\\OOP\\Incapsularea\\Teorie2\\test\\data\\test.admin.txt";
        controlAdmin.save(path);
        controlAdmin.load(path);
        String expected = admin.descriere();
        String expected1 = admin1.descriere();

        assertEquals(controlAdmin.findByEmailPassword(admin.getEmail(), admin.getPassword()).descriere(), expected);
        assertEquals(controlAdmin.findByEmailPassword(admin1.getEmail(), admin1.getPassword()).descriere(), expected1);
    }

    @Test
    public void clear(){
        ControlAdmin controlAdmin = new ControlAdmin(new ArrayList<>());
        controlAdmin.save("C:\\mycode\\OOP\\Incapsularea\\Teorie2\\test\\data\\test.admin.txt");
    }
}
