package rukshin;

import java.util.List;
import java.util.Properties;

import org.openmrs.Patient;
import org.openmrs.api.context.Context;
import org.openmrs.module.ModuleMustStartException;
import org.openmrs.util.DatabaseUpdateException;
import org.openmrs.util.InputRequiredException;

public class Main {

	public static void main(String[] args) {
		System.out.println("hello!!");

		
		
//		File propsFile = new File("C:\\Program Files\\Apache Software Foundation\\Tomcat 6.0", "openmrs-runtime.properties");
//		  Properties props = new Properties();
//		  OpenmrsUtil.loadProperties(props, propsFile);
		  try {
			Context.startup("jdbc:mysql://localhost:3306/openmrs?autoReconnect=true", "israel", "oferR123", new Properties());
		} catch (ModuleMustStartException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DatabaseUpdateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InputRequiredException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  try {
		    Context.openSession();
		    Context.authenticate("admin", "Admin123");
		    List<Patient> patients = Context.getPatientService().getAllPatients();
		    for (Patient patient : patients) {
		      System.out.println("Patient: " + patient.getGivenName() + " " + patient.getFamilyName());
		    }
		  }
		  finally {
		    Context.closeSession();
		  }
	}
	
}
