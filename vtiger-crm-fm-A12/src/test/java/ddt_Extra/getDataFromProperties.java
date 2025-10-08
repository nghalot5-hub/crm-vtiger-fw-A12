package ddt_Extra;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class getDataFromProperties {
	public static void main(String[] args)throws IOException, FileNotFoundException{
//1.	Get the Java Representation Object of the physical file
	FileInputStream fis=new FileInputStream("./src/test/resources/CommonData.properties");
//2.	Use the load() of Properties class to load all the keys
	Properties pobj=new Properties();
	pobj.load(fis);
//3.	Use the getProperty(Key) and pass the key and get the value in String format
	String Browser=pobj.getProperty("browser");	
	System.out.println(Browser);
	String Username=pobj.getProperty("username");
	System.out.println(Username);
	String Password=pobj.getProperty("password");
	System.out.println(Password);
	String URL=pobj.getProperty("url");
	System.out.println(URL);
	}
	
}
