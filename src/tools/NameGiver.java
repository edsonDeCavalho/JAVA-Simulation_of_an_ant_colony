package tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

/**
 * This class gives a random name to an Ant from a text file.
 * 
 * @author Edson De Carvalho Arthur Mimouni
 *
 */
public class NameGiver {
	private ArrayList<String> firstName;
	private File file;
	
	public NameGiver() throws IOException, URISyntaxException {
		this.firstName=new ArrayList<String>();
		file=new File("./src/files/name.txt");
		CsvExtracter(firstName,file);
	}
	
	private void CsvExtracter(ArrayList<String> firstName,File file) throws IOException, URISyntaxException {
		
		try {
			FileReader filereader = new FileReader(file);
			BufferedReader bfr = new BufferedReader(filereader);
			String line ="";
			while((line=bfr.readLine())!=null) {
				firstName.add(line);
			}
			bfr.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public String firtNameGiver() {
		int random = (int )(Math.random() * 148 + 1);
		return firstName.get(random);
	}
	
}
