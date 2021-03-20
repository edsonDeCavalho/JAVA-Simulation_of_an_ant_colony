package data;

import java.io.IOException;
import java.net.URISyntaxException;

import tools.NameGiver;

/**
 * This class is the representation of the identity of an ant (ID and name of the ant).
 * 
 * @author Arthur Mimouni, Edson De Carvalho , Paul Gasquet
 */

public class Identity {
	
	private String firstName;
	private int idNumber;
	private NameGiver nameGiver;
	
	public Identity(int idNumber) throws IOException, URISyntaxException {
		this.nameGiver=new NameGiver();
		this.idNumber=idNumber;
		this.firstName=nameGiver.firtNameGiver();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(int idNumber) {
		this.idNumber = idNumber;
	}

	@Override
	public String toString() {
		return "Identity [firstName=" + firstName + ", idNumber=" + idNumber + "]";
	}
	
}