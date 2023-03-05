package ro.mycode.models;

public class Enrolment {
    private int id=0;
    private int studentId=0;
    private int courseId=0;

    public Enrolment(int id, int studentId, int courseId){
        this.id=id;
        this.studentId=studentId;
        this.courseId=courseId;
    }

    public Enrolment(String inscriere){
        String []delimitare=inscriere.split(",");
        this.id=Integer.parseInt(delimitare[0]);
        this.studentId=Integer.parseInt(delimitare[1]);
        this.courseId=Integer.parseInt(delimitare[2]);

    }

    public void setId(int id){
        this.id=id;
    }

    public int getId(){
        return id;
    }

    public void setStudentId(int studentId){
        this.studentId=studentId;
    }

    public int getStudentId(){
        return studentId;
    }

    public void setCourseId(int courseId){
        this.courseId=courseId;
    }

    public int getCourseId(){
        return courseId;
    }

    public String descriere(){
        String descriere="Id-ul inscrierii este " + id + ", id-ul studentului este " + studentId +
                " si id-ul cursului este " + courseId;
        return descriere;
    }
}
