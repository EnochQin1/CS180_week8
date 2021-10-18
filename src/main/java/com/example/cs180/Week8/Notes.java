package com.example.cs180_week8.Week8;

public class Notes
{
    public static void main(String[] args)
    {
        /*
        Interfaces and Inheritance
        Interface
        - A point where two systems interact
        - Typically asymmetric: one system "defines" the interface,
          the other system "uses" it
          Examples
          - GUI user -> computer
          Java Class
          - provides one form of interface
          - public members(mostly methods) define the interface to users of that class
          Interface consists of
          - what the method expects
          - method return types
          Java Interface
          - A class that defines the interface, and
          - A class that implements the interface

          Syntax
          - declaration like class interface Doable { ... }
          - no method bodies except default
          - no fields other than constants
          like a class where you forgot to declare the fields and left out the method bodies

         Default methods
         - provided method from interface

         Fields in Interfaces
         - interfaces may include fields
         - Fields are implicitly declared (public, final, and static)
         - fields in interfaces are constants

         Implementing Multiple Interfaces
         - a class can implement multiple interfaces
         - The methods implemented are the union of the methods specified in the interfaces
         */
    }
    interface Doable
    {
        int compute(int x);
        void doit(int y);
    }

    class Henway implements Doable
    {
        public int compute(int x)
        {
            return x + 1;
        }
        public void doit(int y)
        {
            System.out.println(y);
        }
    }

    interface Constants
    {
        double X = -1234.56;
        int Y = -1;
        String Z = "hello there";
    }

    public class Booyah implements Constants
    {
        public static void main(String[] args)
        {
            System.out.println(X);
            System.out.println(Y);
            System.out.println(Z);
        }
    }
}
