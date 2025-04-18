package CoreJavaConceptsClassesNadObjects;

import java.util.ArrayList;

public class ClassesAndObjectInJava {

    public static void main(String[] args) {

        // library object

        Library library = new Library();

        // create some book object
        Book book1 = new Book("Java Programming", "James Gosling", 500);
        Book book2 = new Book("Spring Framework", "Rod Johnson", 600);
        Book book3 = new Book("Hibernate in Action", "Gavin King", 550);

        // Add books to library

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        library.displayBooks();

        Member member = new Member("Saad" , 1);

        member.lendBook(library, "Java Programming");
        member.lendBook(library, "spring Boot");
    }
}

class Book{

    String title ;
    String author ;
    int price;

    public Book(String title, String author, int price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public void displayInfo(){
        System.out.println("Title : " + title);
        System.out.println("author : " + author);
        System.out.println("Price : " + price);
    }
}

class Library{

    ArrayList<Book> books ;

    public Library() {
        books = new ArrayList<>();
    }

    // yeh method se hum library me books add karenge
    public void addBook(Book book){
        books.add(book);
        System.out.println("Book added to the library : " + book.title);
    }

    // yeh method se library ki sab books display hongi
    public void displayBooks(){

        System.out.println("\nBooks Available In library : ");
        System.out.println("Library Books : ");
        for (Book book : books){
            book.displayInfo(); // books ki info yaha se aaenge
            System.out.println("------------------------------");
        }
    }
}

class Member {

    String name ;
    int memberID ;

    public Member(String name, int memberID) {
        this.name = name;
        this.memberID = memberID;
    }

    // method to lend books
    public void lendBook(Library library , String bookTitle){
        boolean found = false ;

        for (Book book : library.books){
            if (book.title.equalsIgnoreCase(bookTitle)){
                System.out.println(name + " has borrowed teh book" + bookTitle );
                found = true ;
                break;
            }
        }
        if (!found){
            System.out.println("Sorry, The book " + bookTitle + " is not available.");
        }
    }
}