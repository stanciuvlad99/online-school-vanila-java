package ro.mycode.models;

import java.sql.Timestamp;
import java.util.StringTokenizer;

public class Book {
    private int id=0;
    private int studentId=0;
    private int year=0;
    private String title="";
    private String author="";

    public Book(int id, int studentId, int year, String title, String author) {
        this.id = id;
        this.studentId = studentId;
        this.year = year;
        this.title = title;
        this.author = author;
    }

    public Book(String carte){
        String []delimitare=carte.split(",");
        this.id=Integer.parseInt(delimitare[0]);
        this.studentId= Integer.parseInt(delimitare[1]);
        this.year=Integer.parseInt(delimitare[2]);
        this.title=delimitare[3];
        this.author=delimitare[4];
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public String descriere() {
        String descriere = "Id-ul cartii este " + id + ", id-ul studentului este " + studentId + ", anul cartii este " +
                year +", titlul catii este " + title + " iar autorul este " + author;
        return descriere;
    }

    public String toSave(){
        return this.id + ","+this.studentId+","+this.year+","+this.title+","+this.author;
    }
}
