package ss;

import java.io.ByteArrayOutputStream;
import java.io.File;
import org.semanticweb.HermiT.Configuration;
import org.semanticweb.HermiT.Reasoner.ReasonerFactory;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.io.OWLFunctionalSyntaxOntologyFormat;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.reasoner.ConsoleProgressMonitor;
import org.semanticweb.owlapi.reasoner.InferenceType;
import org.semanticweb.owlapi.reasoner.OWLReasoner;
import org.semanticweb.owlapi.reasoner.OWLReasonerFactory;
import org.semanticweb.owlapi.util.InferredOntologyGenerator;

import com.clarkparsia.pellet.owlapiv3.PelletReasonerFactory;

public class _1test2 {
	public static String sq = "каракуля_на", sont = "examples/ontologies/pred.owl";
	// public static String
	// sq="каракуля_на",sont="examples/ontologies/srulang.owl";
	// public static String sq="Рыба",sont="examples/ontologies/ryba.owl",
	// s1="разводит",s2="Рыба";
	// public static String sq="Розы",sont="examples/ontologies/neznaika.owl",
	// s1="выращивает",s2="Розы";

	public static void main(String[] args) throws Exception {
		String str="http://bb.feofan.com/neznaik.owl";
		str="http://bb.feofan.com/srulang.owl";
	
	
		try {
			
			 IRI ontologyIRI = IRI.create(str);			
			 OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
			OWLOntology 	ontology = manager.loadOntology(ontologyIRI);		
			//OWLDataFactory factory = manager.getOWLDataFactory();
		
	        // Create Reasoner
	        OWLReasonerFactory reasonerFactory = new PelletReasonerFactory();
	        OWLReasoner reasoner = reasonerFactory.createReasoner(ontology);

	        // Load the ontologies into the reasoner.
	    	InferredOntologyGenerator iog = new InferredOntologyGenerator(reasoner);
			OWLOntology inferredOntology = manager.createOntology();
			iog.fillOntology(manager, inferredOntology);

	
				ByteArrayOutputStream bytes1 = new ByteArrayOutputStream();
				manager.saveOntology(ontology, new OWLFunctionalSyntaxOntologyFormat(), bytes1);
	
				str = bytes1.toString("UTF-8");
				
				for (String s : bytes1.toString().split("\n")) {
					
					System.err.println(s);
				}
				
				
				iog.fillOntology(manager, inferredOntology);
				ByteArrayOutputStream bytes2 = new ByteArrayOutputStream();
				manager.saveOntology(inferredOntology, new OWLFunctionalSyntaxOntologyFormat(), bytes2);
			
				//str = bytes2.toString("UTF-8");
				
			for (String s : bytes2.toString().split("\n")) {
				
				System.err.println(s);
				
					//if (s.contains("ClassAssertion") && !s.contains("Prefix") && !s.contains("PropertyAssertion") && !s.contains("Thing"))
					///		s=s.replace("owl:", "").replace("ClassAssertion(", "").replace(")", "");//.replace("каракуля_", "");					
					//		String[] ss=s.split(" ");
					//		String s1=ss[1].replace("каракуля_", "");
					//		if(!s1.equals(ss[0]))
					//			str = str + ss[1] + " - " + ss[0] + "\r\n";
				}		
		
			
			
			
		} catch (Exception e) {
			str=e.toString();
		}
		
		
		System.err.println(str);
	}
}
