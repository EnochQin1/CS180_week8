package com.example.cs180_week8.Week8.Challenge;
import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
/**
 * Homework 8 - StoreCatalog
 * @author Enoch_Qin
 * @version October 15, 2021
 * StoreCatalog represents the catalog of books held by a bookstore.
 */
public class StoreCatalog
{
    private ArrayList<Book> books;
    private String fileName;

    public StoreCatalog(String fileName) throws FileNotFoundException, BookParseException {
        try {
            this.fileName = fileName;
            this.books = new ArrayList<Book>();
            File f = new File(this.fileName);
            FileReader fr = new FileReader(f);
            BufferedReader bfr = new BufferedReader(fr);
            String line = bfr.readLine();
            while (line != null)
            {
                this.books.add(parseBook(line));
                line = bfr.readLine();
            }
            bfr.close();
            fr.close();
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static Book parseBook(String line) throws BookParseException
    {
        String[] separated = line.split(" ");
        if (separated.length != 5) {
            throw new BookParseException("Error parsing book! Data provided in a single line is invalid!");
        }
        String name = separated[0];
        name = name.replace("_", " ");
        String author = separated[1];
        author = author.replace("_", " ");
        try {
            float price = Float.parseFloat(separated[2]);
            int quantity = Integer.parseInt(separated[3]);
            int year = Integer.parseInt(separated[4]);
            Book book = new Book(name, author, price, quantity, year);
            return book;
        } catch (NumberFormatException e) {
            throw new BookParseException("Error parsing book! Failed to parse numbers from file");
        }
    }
    public ArrayList<Book> searchByName(String bookName) throws BookNotFoundException
    {
        ArrayList<Book> withBook = new ArrayList<Book>();
        for (int i = 0; i < this.books.size(); i++)
        {
            if (this.books.get(i).getBookName().contains(bookName))
            {
                withBook.add(this.books.get(i));
            }
        }
        if (withBook.isEmpty()) {
            throw new BookNotFoundException("No books found with the given book name!");
        }
        return withBook;
    }
    public ArrayList<Book> searchByAuthor(String authorName) throws BookNotFoundException
    {
        ArrayList<Book> withAuthor = new ArrayList<Book>();
        for (int i = 0; i < this.books.size(); i++)
        {
            if (this.books.get(i).getAuthorName().contains(authorName))
            {
                withAuthor.add(this.books.get(i));
            }
        }
        if (withAuthor.isEmpty()) {
            throw new BookNotFoundException("No books found with the given author name!");
        }
        return withAuthor;
    }
    public void purchaseBook(String bookName) throws BookNotFoundException
    {
        int counter = 0;
        for (int i = 0; i < this.books.size(); i++)
        {
            if (this.books.get(i).getBookName().contains(bookName))
            {
                this.books.get(i).setQuantity(this.books.get(i).getQuantity() - 1);
                counter++;
            }
            if (this.books.get(i).getQuantity() == 0)
            {
                this.books.remove(i);
            }
        }
        if (counter == 0) {
            throw new BookNotFoundException("The given book was not found.");
        }
    }
    private static DecimalFormat df = new DecimalFormat("#.00");
    public void writeChangesToFile() throws FileNotFoundException
    {
        try {
            File f = new File(this.fileName);
            FileOutputStream fos = new FileOutputStream(f, true);
            PrintWriter pw = new PrintWriter(fos);
            for (int i = 0; i < books.size(); i++)
            {
                String line;
                String bName = books.get(i).getBookName();
                bName = bName.replace(" ", "_");
                String aName = books.get(i).getAuthorName();
                aName = aName.replace(" ", "_");
                float price = books.get(i).getPrice();
                String rPrice = df.format(price);
                int quantity = books.get(i).getQuantity();
                int year = books.get(i).getYear();
                line = bName + " " + aName + " " + rPrice + " " + quantity + " " + year;
                if (i != books.size() - 1) {
                    pw.println(line);
                } else {
                    pw.print(line);
                }
            }
            pw.close();
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException();
        }
    }
    public ArrayList<Book> getBookList()
    {
        return this.books;
    }

}
