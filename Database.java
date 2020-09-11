
/*
Project Name : Student Data 
Group :  01
Name             Roll Number  
Vishwa Raval     AU1940131
Kavya Patel      AU1940144
Yashvi Navadia   AU1940123
Hinanshi Suthar  AU1940266   
Kashish Jivani   AU1940161
Neel Popat       AU1940165
Vinay Kakkad     AU1940012

*/

package Project_ds;

import java.io.*;

public class Database {
private RandomAccessFile database;
private String fName = new String();
java.util.Scanner kb = new java.util.Scanner(System.in);
Database(){
}

 void add(DbObject d)throws IOException {
	 database = new RandomAccessFile(fName, "rw");
	 database.seek(database.length());
	 d.writeToFile(database);
	 database.close();
 }
 void modify(DbObject d)throws IOException {
	 DbObject[] tmp = new DbObject[1]; //cannot initialize object of abstract type
	 d.copy(tmp);
	 database = new RandomAccessFile(fName, "rw");
	 while(database.getFilePointer()< database.length()) {
		 tmp[0].readFromFile(database);
		 if(tmp[0].equals(d)) {
			 tmp[0].readFromConsole();
			 database.seek(database.getFilePointer() - d.size());
			 tmp[0].writeToFile(database);
			 database.close();
			 return;
		 }
	 }
 }
 boolean find(DbObject d)throws IOException {
//	DbObject tmp = new DbObject(); cannot initialize abstract object!!!
	 DbObject[] tmp = new DbObject[1];
	 d.copy(tmp);
	 database = new RandomAccessFile(fName, "r");
	 while(database.getFilePointer()<database.length()) {
		 tmp[0].readFromFile(database);
		 if(tmp[0].equals(d)) {
			 database.close();
			 return true;
		 }
	 }
	 database.close();
	return false;
}
 void printDb(DbObject d)throws IOException {
	
	 database = new RandomAccessFile(fName, "r");
	 while(database.getFilePointer()< database.length()) {
		 d.readFromFile(database);
		 d.writeLegibly();
		 System.out.println();
	 }
	database.close();
}

public void run(DbObject rec) throws IOException {
    String option;
    System.out.print("File name: ");
    fName = kb.next();
    System.out.println("1. Add 2. Find 3. Modify a record; 4. Exit");
    System.out.print("Enter an option: ");
    option = kb.next();
    while (true) {
        if (option.charAt(0) == '1') {
             rec.readFromConsole();
             add(rec);
        }
        else if (option.charAt(0) == '2') {
             rec.readKey();
             System.out.print("The record is ");
             if (find(rec) == false)
                 System.out.print("not ");
             System.out.println("in the database");
        }
        else if (option.charAt(0) == '3') {
             rec.readKey();
             modify(rec);
        }
        else if (option.charAt(0) != '4')
             System.out.println("Wrong option");
        else return;
        printDb(rec);
        System.out.println("1. Add 2. Find 3. Modify a record; 4. Exit");
        System.out.print("Enter an option: ");
        option = kb.next();
    }
}


static public void main(String[] args) throws IOException {
//create database and run it
	Database studentdata = new Database();
	studentdata.run(new Studentdata());
}
}
