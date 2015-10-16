package ss.server;

import ss.client.Service3;
import com.clarkparsia.pellet.owlapiv3.PelletReasonerFactory;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import java.io.ByteArrayOutputStream;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.io.OWLFunctionalSyntaxOntologyFormat;
import org.semanticweb.owlapi.model.*;
import org.semanticweb.owlapi.reasoner.OWLReasoner;
import org.semanticweb.owlapi.reasoner.OWLReasonerFactory;
import org.semanticweb.owlapi.util.InferredOntologyGenerator;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class Service3Impl extends RemoteServiceServlet implements Service3 {

	public String mm3(String slb, String stb, String sta, String sqq6, String stb2) throws IllegalArgumentException {

		// String str="http://bb.feofan.com/neznaik.owl";
		// str="http://bb.feofan.com/srulang.owl";
		// str="http://feormit.appspot.com/owl?онтология_русского_языка";
		String str = stb2;
	
		try {

			IRI ontologyIRI = IRI.create(str);
			OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
			OWLOntology ontology = manager.loadOntology(ontologyIRI);

			// Create Reasoner
			OWLReasonerFactory reasonerFactory = new PelletReasonerFactory();
			OWLReasoner reasoner = reasonerFactory.createReasoner(ontology);

			// Load the ontologies into the reasoner.
			InferredOntologyGenerator iog = new InferredOntologyGenerator(reasoner);
			OWLOntology inferredOntology = manager.createOntology();
			iog.fillOntology(manager, inferredOntology);

			ByteArrayOutputStream bytes1 = new ByteArrayOutputStream();
			manager.saveOntology(ontology, new OWLFunctionalSyntaxOntologyFormat(), bytes1);

			// str = bytes1.toString("UTF-8");
			// for (String s : bytes1.toString().split("\n")) {
			// System.err.println(s);
			// }

			iog.fillOntology(manager, inferredOntology);
			ByteArrayOutputStream bytes2 = new ByteArrayOutputStream();
			manager.saveOntology(inferredOntology, new OWLFunctionalSyntaxOntologyFormat(), bytes2);

			String sss = bytes2.toString("UTF-8");
			str = "<br/> ";

			for (String s : sss.split("\n")) {
				
				
				if (s.contains("ClassAssertion") && !s.contains("Thing"))
				{
					s = s.replace("<", "(").replace(">", ")").replace("owl:", "").replace("ClassAssertion(", "")
							.replace("(", "").replace(")", "").replace("каракуля_", "");

				 
					System.out.println(s);
					String[] ss=s.split(" ");	
					if (ss.length ==2 ) { 
						String s1=ss[1]; 						
						if(!s1.equals(ss[0])) 
							str = str + "&nbsp;&nbsp;&nbsp;"+ ss[1] + " - " + ss[0] + "<br/>"; 
					}
					
				}
				
				

	
			}

		} catch (Exception e) {
			stb2 = e.toString();
		}
		ss.st.sout = str;

		return str;//stb2;
	}
}
