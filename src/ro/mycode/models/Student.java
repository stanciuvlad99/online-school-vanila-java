package ro.mycode.models;

public class Student {

    private int id=0;
    private String firstName="";
    private String lastName="";
    private String email="";
    private int age=0;
    private String password="";

    public Student(int id, String firstName, String lastName, String email, int age, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.password = password;
    }


    public Student(String student){//5,Radu,Enescu,raduenescu12@gmail.com,25,mosene47!
        String []alegere=student.split(",");
        this.id= Integer.parseInt(alegere[0]);
        this.firstName=alegere[1];
        this.lastName=alegere[2];
        this.email=alegere[3];
        this.age= Integer.parseInt(alegere[4]);
        this.password=alegere[5];

    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String descriere() {
        String descriere = "ID-ul persoanei este " + id + ", numele mic este " + firstName + ", numele de familie este " +
                lastName + ", email-ul persoanei este " + email + ", varsta este " + age + " de ani si parola este " + password;
        return descriere;
    }
}
