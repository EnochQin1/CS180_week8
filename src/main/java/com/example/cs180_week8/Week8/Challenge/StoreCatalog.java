package com.example.cs180_week8.Week8.Challenge;
import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;
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

    public StoreCatalog(String filename1) throws FileNotFoundException, BookParseException {
        this.fileName = filename1;
        File f = new File(this.fileName);
        FileReader fr = new FileReader(f);
        BufferedReader bfr = new BufferedReader(fr);
        String line = null;
        try {
            line = bfr.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (line != null)
        {
            try {
                books.add(parseBook(line));
                bfr.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            bfr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static Book parseBook(String line) throws BookParseException
    {
        String[] separated = line.split(" ");
        String name = separated[0];
        String author = separated[1];
        float price = Float.parseFloat(separated[2]);
        int quantity = parseInt(separated[3]);
        int year = parseInt(separated[4]);
        Book book = new Book(name, author, price, quantity, year);
        return book;
    }
    public ArrayList<Book> searchByName(String bookName) throws BookNotFoundException
    {
        ArrayList<Book> withBook = new ArrayList<Book>();
        for (int i = 0; i < this.books.size(); i++)
        {
            if (this.books.get(i).getBookName().equals(bookName))
            {
                withBook.add(this.books.get(i));
            }
        }
        return withBook;
    }
    public ArrayList<Book> searchByAuthor(String authorName) throws BookNotFoundException
    {
        ArrayList<Book> withAuthor = new ArrayList<Book>();
        for (int i = 0; i < this.books.size(); i++)
        {
            if (this.books.get(i).getAuthorName().equals(authorName))
            {
                withAuthor.add(this.books.get(i));
            }
        }
        return withAuthor;
    }
    public void purchaseBook(String bookName) throws BookNotFoundException
    {
        for (int i = 0; i < this.books.size(); i++)
        {
            if (this.books.get(i).getBookName().equals(bookName))
            {
                this.books.get(i).setQuantity(this.books.get(i).getQuantity() - 1);
            }
            if (this.books.get(i).getQuantity() == 0)
            {
                this.books.remove(i);
            }
        }
    }
    private static DecimalFormat df = new DecimalFormat("0.00");
    public void writeChangesToFile() throws FileNotFoundException
    {
        File f = new File(this.fileName);
        FileOutputStream fos = new FileOutputStream(f, true);
        PrintWriter pw = new PrintWriter(fos);
        for (int i = 0; i < books.size(); i++)
        {
            String line;
            String bName = books.get(i).getBookName();
            bName.replace(" ", "_");
            String aName = books.get(i).getAuthorName();
            aName.replace(" ", "_");
            float price = books.get(i).getPrice();
            String rPrice = df.format(price);
            int quantity = books.get(i).getQuantity();
            int year = books.get(i).getYear();
            line = bName + " " + aName + " " + rPrice + " " + Integer.toString(quantity)
                + " " + Integer.toString(year);
            pw.println(line);
        }
        pw.close();
    }
    public ArrayList<Book> getBookList()
    {
        return this.books;
    }
}
