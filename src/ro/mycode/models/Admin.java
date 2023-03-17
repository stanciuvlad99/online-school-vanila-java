package ro.mycode.models;

public class Admin {
    private int id;
    private String email;
    private String password;
    private String firstName;
    private String lastname;

    public Admin(int id, String email, String password, String firstName, String lastname) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.firstName= firstName;
        this.lastname = lastname;

    }

    public Admin(String text) {
        String[] delimitare = text.split(",");
        this.id = Integer.parseInt(delimitare[0]);
        this.email = delimitare[1];
        this.password = delimitare[2];
        this.firstName=delimitare[3];
        this.lastname=delimitare[4];
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setFirstName(String firstName){
        this.firstName=firstName;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setLastname(String lastname){
        this.lastname=lastname;
    }

    public String getLastname(){
        return lastname;
    }


    public String descriere() {
        String descriere = "Id-ul adminului este " + id + ", adresa de mail este " + email + ", iar parola este "
                + password + ". Perenumele si numele de familie alea adminului sunt " + firstName +" " + lastname;
        return descriere;
    }

    public String toSave(){
        return this.id + "," + this.email + ","+ this.password + "," + this.firstName+ "," + this.lastname;
    }
}
