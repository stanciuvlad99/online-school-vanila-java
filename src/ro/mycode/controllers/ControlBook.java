package ro.mycode.controllers;

import ro.mycode.models.Book;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ControlBook {

    private ArrayList<Book>books;


    public ControlBook(){
        this.books=new ArrayList<>();
        load();
    }

    private void load(){
        try {
            File file = new File("C:\\mycode\\OOP\\Incapsularea\\Teorie2\\src\\ro\\mycode\\data\\books.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()){
                String linie=scanner.nextLine();
                Book book = new Book(linie);
                this.books.add(book);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    //todo: CRUD
    //functie ce arata daca exita in lista un anumit student id
    private boolean findByStudentId(int idStudent){
        for (int i=0; i<books.size(); i++){
            if (books.get(i).getId()==idStudent){
                return true;
            }
        }
        return false;
    }

    //functie ce creaza o carte, primeste constructor ca parametru
    public boolean create(Book book){
        return findByStudentId(book.getId())==false?this.books.add(book):false;
    }

    //functie de afiseaza cartile din lista
    public void read(){
        for (int i=0; i<books.size(); i++){
            System.out.println(this.books.get(i).descriere());
        }
    }

    //functie ce returneaza cartea, primeste id student ca parametru
    public Book findByIdStudent(int idStudent){
        for (int i=0; i<books.size(); i++){
            if (books.get(i).getStudentId()==idStudent){
                return books.get(i);
            }
        }
        return null;
    }

    //functie ce face update informatiilor, primeste constructor ca parametru
    public void update(Book book){
        Book update= findByIdStudent(book.getStudentId());

        if ((book.getId()==0)==false){
            update.setId(book.getId());
        }
        if (book.getAuthor().equals("")==false){
            update.setAuthor(book.getAuthor());
        }
        if ((book.getYear()==0)==false){
            update.setYear(book.getYear());
        }
        if (book.getTitle().equals("")==false){
            update.setTitle(book.getTitle());
        }
    }

    //functie ce elimina o carte din lista, primeste id student ca parametru
    public void delete(int idStudent){
        for (int i=0; i<books.size(); i++){
            if (books.get(i).getStudentId()==idStudent){
                books.remove(i);
            }
        }
    }

    //todo: functie ce gaseste cartile dupa id-ul acestora, primeste id ca parametru
    public Book findById(int id){
        for (int i=0; i<books.size(); i++){
            if (books.get(i).getId()==id){
                return books.get(i);
            }
        }
        return null;
    }

    public Book findByName(String name){
        for (int i=0; i<books.size(); i++){
            if (books.get(i).getTitle().equals(name)){
                return books.get(i);
            }
        }
        return null;
    }

    //todo:functie ce primeste ca parametru idstudent si returneza toate cartile studentului
    public ArrayList<Book> cartiStudent(int idStudnet){
        ArrayList<Book> carti = new ArrayList<>();
        for (int i=0; i<books.size(); i++){
            if (books.get(i).getStudentId()==idStudnet){
                carti.add(books.get(i));
            }
        }
        return carti;
    }

    //todo: functie ce adauga inca o carte studentului, primeste nume ca parametru
    public void add(Book book){
        this.books.add(book);
    }

    //todo:functie ce genereaza un nou id valabil
    public int nextId() {
        if (this.books.size() == 0) {
            return 1;
        }
        return this.books.get(this.books.size() - 1).getId() + 1;
    }

    //todo:functie ce elimina carte din baza de date, primeste titlu carte si student id ca parametru
     public void eraseBook(String titluCarte, int idStudent){
        for (int i=0; i<books.size(); i++){
            if (books.get(i).getTitle().equals(titluCarte) && books.get(i).getStudentId()==idStudent){
                books.remove(i);
            }
        }
     }

     //todo: functie ce face update autorului si anului, primeste constructor ca parametru
    public void updateAuthorYear(Book book){
        Book update = findByIdStudent(book.getStudentId());

        if ((book.getYear()==0)==false){
            update.setYear(book.getYear());
        }
        if (book.getAuthor().equals("")==false){
            update.setAuthor(book.getAuthor());
        }
    }



}
