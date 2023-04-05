package ro.mycode.controllers;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import ro.mycode.models.Book;

import java.util.ArrayList;

import static org.testng.Assert.assertEquals;

class ControlBookTest {

    @Test
    public void testFindByStudentId() {
        ArrayList<Book> books = new ArrayList<>();
        Book book = new Book("1,1,2020,Moara cu noroc,Ioan Slavici");
        books.add(book);
        ControlBook controlBook = new ControlBook(books);
        boolean expected = true;

        assertEquals(controlBook.findByStudentId(book.getStudentId()), expected);
    }

    @Test
    public void testFindByStudentIdFalse() {
        ArrayList<Book> books = new ArrayList<>();
        Book book = new Book("1,1,2020,Moara cu noroc,Ioan Slavici");
        books.add(book);
        ControlBook controlBook = new ControlBook(books);
        boolean expected = false;

        assertEquals(controlBook.findByStudentId(book.getStudentId()+1), expected);
    }

    @Test
    public void testCreate(){
        ArrayList<Book> books = new ArrayList<>();
        Book book = new Book("1,1,2020,Moara cu noroc,Ioan Slavici");
        ControlBook controlBook = new ControlBook(books);
        controlBook.create(book);
        String expected=book.descriere();

        assertEquals(controlBook.findByName(book.getTitle()).descriere(),expected);
    }

    @Test
    public void testCreateFalse(){
        ArrayList<Book> books = new ArrayList<>();
        Book book = new Book("1,1,2020,Moara cu noroc,Ioan Slavici");
        Book book1 = new Book("1,1,2020,qwerty,qwerty");
        ControlBook controlBook = new ControlBook(books);
        controlBook.create(book);
        controlBook.create(book1);
        String expected = null;

        assertEquals(controlBook.findByName(book1.getTitle()), expected);
    }

    @Test
    public void testFindByIdStudent(){
        ArrayList<Book> books = new ArrayList<>();
        Book book = new Book("1,1,2020,Moara cu noroc,Ioan Slavici");
        books.add(book);
        ControlBook controlBook = new ControlBook(books);
        String expected=book.descriere();

        assertEquals(controlBook.findByIdStudent(book.getStudentId()).descriere(),expected);
    }

    @Test
    public void testFindByIdStudentNull(){
        ArrayList<Book> books = new ArrayList<>();
        Book book = new Book("1,1,2020,Moara cu noroc,Ioan Slavici");
        books.add(book);
        ControlBook controlBook = new ControlBook(books);
        String expected=null;

        assertEquals(controlBook.findByIdStudent(book.getStudentId()+1),expected);
    }

    @Test
    public void testUpdate(){
        ArrayList<Book> books = new ArrayList<>();
        Book book = new Book("1,1,2020,Moara cu noroc,Ioan Slavici");
        Book book1 = new Book("2,1,2019,Baltagul,Mihail Sadoveanu");
        books.add(book);
        ControlBook controlBook = new ControlBook(books);
        controlBook.update(book1);

        int expectedId=book1.getId();
        int expectedYear=book1.getYear();
        String expectedTitle=book1.getTitle();
        String expectedAuthor=book1.getAuthor();

        assertEquals(book.getId(),expectedId);
        assertEquals(book.getYear(),expectedYear);
        assertEquals(book.getTitle(),expectedTitle);
        assertEquals(book.getAuthor(),expectedAuthor);
    }

    @Test
    public void testDelete(){
        ArrayList <Book> books = new ArrayList<>();
        Book book = new Book("1,1,2020,Moara cu noroc,Ioan Slavici");
        books.add(book);
        ControlBook controlBook = new ControlBook(books);
        controlBook.delete(1);
        String expected=null;

        assertEquals(controlBook.findByIdStudent(book.getStudentId()+1), expected);
    }

    @Test
    public void testFindById(){
        ArrayList<Book> books = new ArrayList<>();
        Book book = new Book("1,1,2020,Moara cu noroc,Ioan Slavici");
        books.add(book);
        ControlBook controlBook = new ControlBook(books);
        String expected=book.descriere();

        assertEquals(controlBook.findById(book.getId()).descriere(),expected);
    }

    @Test
    public void testFindByIdNull(){
        ArrayList<Book> books = new ArrayList<>();
        Book book = new Book("1,1,2020,Moara cu noroc,Ioan Slavici");
        books.add(book);
        ControlBook controlBook = new ControlBook(books);
        String expected=null;

        assertEquals(controlBook.findById(book.getId()+1),expected);
    }

    @Test
    public void testCartiStudenti(){
        ArrayList<Book> books = new ArrayList<>();
        Book book = new Book("1,1,2020,Moara cu noroc,Ioan Slavici");
        Book book1 = new Book("2,1,2019,Baltagul,Mihail Sadoveanu");
        Book book2 = new Book("3,1,2022,Ultima noapte de dragoste intaia noapte de razboi,Camil Petrescu");
        books.add(book);
        books.add(book1);
        books.add(book2);
        ControlBook controlBook = new ControlBook(books);

        ArrayList<Book> list = null;
        for (int i=0; i<books.size(); i++){
            list=controlBook.cartiStudent(books.get(i).getStudentId());
        }
        assertEquals(books.size(),list.size());
    }

    @Test
    public void testAdd(){
        ArrayList<Book> books = new ArrayList<>();
        Book book = new Book("1,1,2020,Moara cu noroc,Ioan Slavici");
        ControlBook controlBook = new ControlBook(books);
        controlBook.add(book);
        String expected=book.descriere();

        assertEquals(controlBook.findByName(book.getTitle()).descriere(), expected);
    }

    @Test
    public void testNextId(){
        ArrayList<Book> books = new ArrayList<>();
        Book book = new Book("1,1,2020,Moara cu noroc,Ioan Slavici");
        books.add(book);
        ControlBook controlBook = new ControlBook(books);
        int expected=book.getId()+1;

        assertEquals(controlBook.nextId(),expected);
    }

    @Test
    public void testNextIdNull(){
        ArrayList<Book> books = new ArrayList<>();
        ControlBook controlBook = new ControlBook(books);
        int expected=books.size()-1;

        assertEquals(controlBook.nextId(),expected);
    }

    @Test
    public void testEraseBook(){
        ArrayList<Book> books = new ArrayList<>();
        Book book = new Book("1,1,2020,Moara cu noroc,Ioan Slavici");
        books.add(book);
        ControlBook controlBook = new ControlBook(books);
        controlBook.eraseBook(book.getTitle(), book.getStudentId());
        String expected=null;


        assertEquals(controlBook.findByName(book.getTitle()), expected);
    }

    @Test
    public void testUpdateAuthorYear(){
        ArrayList<Book> books = new ArrayList<>();
        Book book = new Book("1,1,2020,Moara cu noroc,Ioan Slavici");
        Book book1 = new Book("2,1,2019,Baltagul,Mihail Sadoveanu");
        books.add(book);
        ControlBook controlBook = new ControlBook(books);
        controlBook.updateAuthorYear(book1);
        int expectedYear=book1.getYear();
        String expectedAuthor=book1.getAuthor();

        assertEquals(book.getYear(),expectedYear);
        assertEquals(book.getAuthor(),expectedAuthor);
    }

    @Test
    public void testToSave(){
        ArrayList<Book> books = new ArrayList<>();
        Book book = new Book("1,1,2020,Moara cu noroc,Ioan Slavici");
        Book book1 = new Book("2,2,2019,Baltagul,Mihail Sadoveanu");
        books.add(book);
        books.add(book1);
        ControlBook controlBook = new ControlBook(books);
        String expected= book.toSave() + "\n" + book1.toSave();

        assertEquals(controlBook.toSave(), expected);
    }

    @Test
    public void testToSaveNull(){
        ArrayList<Book> books = new ArrayList<>();
        ControlBook controlBook = new ControlBook(books);
        String expected="";

        assertEquals(controlBook.toSave(), expected);
    }

    @Test
    public void testSave(){
        ArrayList<Book> books = new ArrayList<>();
        Book book = new Book("1,1,2020,Moara cu noroc,Ioan Slavici");
        Book book1 = new Book("2,2,2019,Baltagul,Mihail Sadoveanu");
        books.add(book);
        books.add(book1);
        ControlBook controlBook = new ControlBook(books);
        String path="C:\\mycode\\OOP\\Incapsularea\\Teorie2\\test\\data\\test.book.txt";
        controlBook.save(path);
        controlBook.load(path);
        String expected=book.toSave();
        String expected1=book1.toSave();

        assertEquals(controlBook.findByName(book.getTitle()).toSave(),expected);
        assertEquals(controlBook.findByName(book1.getTitle()).toSave(),expected1);
    }

    @AfterEach
    public void clear(){
        ControlBook controlBook = new ControlBook(new ArrayList<>());
        controlBook.save("C:\\mycode\\OOP\\Incapsularea\\Teorie2\\test\\data\\test.book.txt");
    }
}
