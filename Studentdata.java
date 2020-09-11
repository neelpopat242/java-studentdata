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

import java.io.IOException;
import java.io.RandomAccessFile;

public class Studentdata extends DbObject {
	
	private String name;
	protected int nameLen = 30;
	
	private String lastName;
	protected int lastNameLen = 30;
	
	private int marks;
	protected int marksLen=4;
	
	private String programme;
	protected int programmeLen=30;
	
	private String town;
	protected int townLen=30;
	
	protected int size = 2*nameLen+2*lastNameLen+marksLen + 2*programmeLen+2*townLen;
	//the length of string is counted twice because of writing into file as array
	
	public Studentdata() {	
	}

	public Studentdata(String s1, String s2, int i, String s3, String s4) {
		name=s1;
		lastName=s2;
		marks=i;
		programme=s3;
		town=s4;
	}
	
	public boolean equals(Object d) {
		
		return name.trim().equals(((Studentdata) d).name.trim());
	}
	@Override
	public void writeToFile(RandomAccessFile out) throws IOException {
		writeString(name, out);
		writeString(lastName, out);
		out.writeInt(marks);
		writeString(programme,out);
		writeString(town,out);
		
	}

	@Override
	public void readFromFile(RandomAccessFile in) throws IOException {
		name = readString(nameLen, in);
		lastName = readString(lastNameLen, in);
		marks = in.readInt();
		programme=readString(programmeLen, in);
		town = readString(townLen, in);

	}

	@Override
	public void readFromConsole() {
		kb.useDelimiter("\r\n");
		
		System.out.print("Enter name: ");
		name=kb.next();
		
		for(int i = name.length(); i< nameLen; i++)
			name+=' ';

		System.out.print("Last name: ");
		lastName= kb.next();
		for(int i = lastName.length(); i< lastNameLen; i++)
			lastName+=' ';
		
		System.out.print("Marks: ");
		marks =kb.nextInt();
		
		//System.out.print("Here is error: " + kb.next());
		
		System.out.print("Programme: ");
		programme=kb.next();

		for(int i = programme.length(); i<programmeLen; i++)
		programme+=' ';
		
		System.out.print("Hometown: ");
		town=kb.next();

		for(int i = town.length(); i< townLen; i++)
		town+=' ';
		
		
		}
		
	

	@Override
	public void writeLegibly() {
		System.out.println("The Student name is:  " + name.trim() );
		System.out.println("The Last Name is:     " + lastName.trim() );
		System.out.println("They have scored:     " + marks );
		System.out.println("Studies  in:          " + programme.trim() );
		System.out.println("Home Town is:         " + town.trim() + ". ");
	}

	@Override
	public void readKey() {
		System.out.println("Enter name: ");
		kb.useDelimiter("\r\n");
		name= kb.next();
		System.out.println("Comparing name: " + name);
	}

	@Override
	public void copy(DbObject[] db) {
		db[0] = new Studentdata(name, lastName, marks, programme, town);

	}

	@Override
	public int size() {
		
		return size;
	}

}