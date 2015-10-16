package ss;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.List;

import org.mindswap.pellet.jena.PelletReasonerFactory;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.io.OWLXMLOntologyFormat;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.util.OWLOntologyMerger;

import com.clarkparsia.pellet.sparqldl.jena.SparqlDLExecutionFactory;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.ModelFactory;

// feormit.appspot.com ym q-d0n

public class __info {
	public static void main(String[] args) throws Exception {

		String s = "file:///kuka1.txt";
		s="file:///Users/Yuriy/Desktop/111.txt";
		String s1 = "http://bb.feofan.com/neznaik.owl";
		String s2 = "http://bb.feofan.com/srulang.owl";
		// s = ss.st.rfu_utf(s);
		// s=ss.st.kuka2(s);
		// Owl2Model owl2model = new Owl2Model();
		// owl2model.test();
		OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
		IRI ontologyIRI = IRI.create(s);
		OWLOntology ontology = manager.loadOntology(IRI.create(s));
		OWLOntology ontology1 = manager.loadOntology(IRI.create(s1));
		OWLOntology ontology2 = manager.loadOntology(IRI.create(s2));


	        OWLOntologyMerger merger = new OWLOntologyMerger(manager);
	        // We merge all of the loaded ontologies. Since an OWLOntologyManager is an OWLOntologySetProvider we just pass this in.
	        //We also need to specify the URI of the new ontology that will be created.
	       // IRI mergedOntologyIRI = IRI.create("http://www.feofan.com/mymergedont");
	       // OWLOntology merged = merger.createMergedOntology(manager, mergedOntologyIRI);
	        
	
	        
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		//manager.saveOntology(merged, outputStream);
		manager.saveOntology(ontology, outputStream);
		s = new String(outputStream.toByteArray(), "UTF-8");
		s=s.replace("\n", "\r\n");
		PrintWriter writer = new PrintWriter("/Users/Yuriy/Desktop/222.txt", "UTF-8");
		writer.println(s);
		writer.close();
		
		System.out.println(s);

	}

}
