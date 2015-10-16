package ss.server;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.*;
import javax.servlet.http.*;


import java.io.StringReader;

import org.mindswap.pellet.jena.PelletReasonerFactory;

import com.clarkparsia.pellet.sparqldl.jena.SparqlDLExecutionFactory;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.ModelFactory;


public class Ontos extends HttpServlet {
private static final long serialVersionUID = 1L;
public static int j = 0;

  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
            throws ServletException, IOException
  {      
      response.setContentType("text/event-stream; charset=UTF8");
      PrintWriter out = response.getWriter();
      
  	String s = "http://bb.feofan.com/neznaik.owl";

	
      try {
    	  //result of asynchron call
    	  j++;
    		s	= ss.st.rfu_utf(s);	
    		s=kuka1(s);
    		System.err.println("-->  "+s);
    		ss.st.sout=s;
		Thread.sleep(111);
	} catch (InterruptedException e) {
	}          

    //  out.println(String.valueOf(j) + " " + s);
      
      out.println(j + " " + s);
      
  }
  
  

	public static String kuka1(String s){	
		
		OntModel mm = ModelFactory
				.createOntologyModel(PelletReasonerFactory.THE_SPEC);		
		mm.read(new StringReader(s), "");
		s="PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>PREFIX owl: <http://www.w3.org/2002/07/owl#>PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>PREFIX qq: <http://127.0.0.1:8888/rff?83.owl#> SELECT ?X ?Y ?Z WHERE {?X ?Y ?Z}";

		
		try {
			
			Query qq = QueryFactory.create(s);
			s = "\r\n";
			ResultSet r = SparqlDLExecutionFactory.create(qq, mm).execSelect();
			while (r.hasNext()) {
				String sa = r.next().toString();
				String sa1 = "", sa2 = "", sap = "", sr = ss.st.sr;
				// sr = sr.toLowerCase().replaceAll("тот, кто", "")
				// .replaceAll(", тот", "").replace(" ", "-").replace("_", " ")
				// .replaceAll("[-]+", " ");
				int k = sa.indexOf("#");
				if (k > 0)
					sa = sa.substring(k).trim();
				String[] ssa = sa.split("#");

				if (ssa.length == 3) {
					sa1 = ssa[1].substring(0, ssa[1].indexOf(">")).trim();
					sa2 = ssa[2].substring(0, ssa[2].indexOf(">")).trim();
					if (!sa1.equals(sa2) && !(sa1.startsWith("кто_"))
							&& !(sa2.startsWith("кто_"))) {
						sa = sa1 + " " + sa2;
						sap = sa;
						sap = sap.replace(" ", " - ");
						sap = sap.replace("_", " ");

						String s42 = sr.replace("_", " ").toLowerCase();
						String s43 = sap.replace(" - ", " ").toLowerCase();

						s43 = s43.replaceAll("/" + "" + ".*" + "//", "");

						boolean bb1 = !(s.toLowerCase()).contains(s43);
						boolean bb2 = !s42.contains(s43);

						if (bb1 && bb2)
							if (ss.st.bim(sap.substring(0, 1))) {
								sap = sap.replace("_", " ");
							//	s = s + " " + sap + ".\r\n";
							}
						}
				}
				if (ssa.length == 4) {
					sa = ssa[1].substring(0, ssa[1].indexOf(">")) + " "
							+ ssa[2].substring(0, ssa[2].indexOf(">")) + " "
							+ ssa[3].substring(0, ssa[3].indexOf(">"));

					sap = sa.replace("_", " ");
					String s42 = sr.replace("_", " ").toLowerCase();

					String s43 = sap.toLowerCase();
					s43 = s43.replaceAll("/" + "" + ".*" + "//", "");

					boolean bb1 = !s.toLowerCase().contains(s43);
					boolean bb2 = !s42.contains(s43);

					if (bb1 && bb2)
						if (ss.st.bim(sap.substring(0, 1)))
							s = s + " " + sap + ". ";// \r\n
				}
			}

		} catch (Exception ee) {
			s = ee.toString();
		}
		return s.replaceAll("[\r\n]", " ");
		
		
	}

}
