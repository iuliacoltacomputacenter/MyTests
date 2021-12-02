package introduction;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;


public class RuntimeExceptions {

	public static void main(String[] args) throws IOException {
		
		String path = "\\Users\\Iulia\\eclipse-workspace\\JavaTutorial1\\src\\introduction\\javafile.properties";
		
		
		Properties prop = new Properties() ;
		FileInputStream fs = new FileInputStream(path) ;

		prop.load(fs);
		System.out.println(prop.getProperty("name")) ;
		System.out.println(prop.getProperty("domain")) ;
	}

}
