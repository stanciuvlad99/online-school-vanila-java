package ro.mycode.models;

public class Course {
    private int id = 0;
    private String name = "";
    private String department = "";

    public Course(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public Course(String curs) {
        String[] delimitare = curs.split(",");
        this.id = Integer.parseInt(delimitare[0]);
        this.name = delimitare[1];
        this.department = delimitare[2];
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public String descriere() {
        String descriere = "Id-ul cursului este " + id + ", numele cursului este " + name + ", iar departamentul este "
                + department;
        return descriere;
    }

    public String toSave() {
        return this.id + "," + this.name + "," + this.department;
    }
}