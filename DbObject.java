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

abstract class DbObject {

	 java.util.Scanner kb = new java.util.Scanner(System.in);
	    public void writeString(String s, RandomAccessFile out) throws IOException {
	        for (int i = 0; i < s.length(); i++)
	            out.writeChar(s.charAt(i));
	    }
	    public String readString(int len, RandomAccessFile in) throws IOException {
	        StringBuffer s = new StringBuffer(len);
	        for (int i = 0; i < len; i++)
	            s.append(in.readChar());
	        return s.toString();
	    }
	    abstract public void writeToFile(RandomAccessFile out) throws IOException;
	    abstract public void readFromFile(RandomAccessFile in) throws IOException;
	    abstract public void readFromConsole();
	    abstract public void writeLegibly();
	    abstract public void readKey();
	    abstract public void copy(DbObject[] db);
	    abstract public int size();

}