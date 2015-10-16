package ss;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.mindswap.pellet.jena.PelletReasonerFactory;

import com.clarkparsia.pellet.sparqldl.jena.SparqlDLExecutionFactory;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Text;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.ModelFactory;

public class st {

	public static String sout="поехали!";
	public static String sr="";
	public static String sont="";
	
	public static String rfu_utf(String s) {
		try {
			URL url = new URL(s);
	
			URLConnection conn = url.openConnection();
			BufferedReader br = new BufferedReader(new InputStreamReader(
					conn.getInputStream(), "utf8"));
			s = "";
			String thisLine = "";
			while ((thisLine = br.readLine()) != null) { // while loop begins
															// here
				s = s + thisLine + "\r\n";
			}
			br.close();
			return s.toString();
	
		} catch (Exception e) {
			return e.toString();
		}
	}
	
	public static boolean bim(String s) {

		if (s.length() > 0)
			if (s.substring(0, 1).toUpperCase().equals(s.substring(0, 1)))
				return true;
			else
				return false;
		else
			return false;
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
	

	public static String kuka2(String s){			
		OntModel mm = ModelFactory
				.createOntologyModel(PelletReasonerFactory.THE_SPEC);		
		mm.read(new StringReader(s), "");
		
		String sparql="PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>PREFIX owl: <http://www.w3.org/2002/07/owl#>PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>PREFIX qq: <http://127.0.0.1:8888/rff?83.owl#> "
				+ "SELECT ?X ?Y ?Z WHERE {?X  ?Y  ?Z}";
			
		Query qq = QueryFactory.create(sparql);
			
			s = "\r\n";
			ResultSet r = SparqlDLExecutionFactory.create(qq, mm).execSelect();
			while (r.hasNext()) {
				String sa = r.next().toString();	
				System.out.println(sa);
				
			//	s=s+"<br/>"+sa;
				//String[]  ss=sa.split("#");
				//if(ss.length - 1 ==3)
				{
				//	sa= ss[1].substring(0, ss[1].indexOf(">")) + " "+ss[2].substring(0, ss[2].indexOf(">")) + " "+ss[3].substring(0, ss[3].indexOf(">"));
				//	s=s+"<br/>"+sa;
				}
			}			
		return s;
	}
	
	public static String fir(String sfilename) {
		String sid = "Files", skk = "files", s = "", sfn = "";
		DatastoreService dbf = DatastoreServiceFactory.getDatastoreService();
		Key key = KeyFactory.createKey(sid, skk);
		com.google.appengine.api.datastore.Query query = new com.google.appengine.api.datastore.Query(sid, key).addSort("date",
				com.google.appengine.api.datastore.Query.SortDirection.DESCENDING);
		List<Entity> spisok = dbf.prepare(query).asList(
				FetchOptions.Builder.withLimit(10));
		for (Entity ent : spisok) {
			sfn = ((String) ent.getProperty("file_name")).trim();

			if (sfn.equals(sfilename))
				s = ((Text) ent.getProperty("content")).getValue();
		}
		return s;
	}

	public static void fiw(String sfilename, String s) {
		String sid = "Files", skk = "files";

		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();
		Key key = KeyFactory.createKey(sid, skk);
		com.google.appengine.api.datastore.Query query = new com.google.appengine.api.datastore.Query(sid, key).addSort("date",
				com.google.appengine.api.datastore.Query.SortDirection.DESCENDING);
		List<Entity> spisok = datastore.prepare(query).asList(
				FetchOptions.Builder.withLimit(10));
		for (Entity ent : spisok) {
			if (((String) ent.getProperty("file_name")).trim()
					.equals(sfilename))
				datastore.delete(ent.getKey());
		}

		Entity ent = new Entity(sid, key);
		ent.setProperty("file_name", sfilename);
		ent.setProperty("content", new Text(s));
		ent.setProperty("date", new Date());

		datastore.put(ent);
	}
	
	public static void fid(String sfilename) {
		String sid = "Files", skk = "files";

		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();
		Key key = KeyFactory.createKey(sid, skk);
		com.google.appengine.api.datastore.Query query = new com.google.appengine.api.datastore.Query(sid, key).addSort("date",
				com.google.appengine.api.datastore.Query.SortDirection.DESCENDING);
		List<Entity> spisok = datastore.prepare(query).asList(
				FetchOptions.Builder.withLimit(10));
		for (Entity ent : spisok) {
			if (((String) ent.getProperty("file_name")).trim()
					.equals(sfilename))
				datastore.delete(ent.getKey());
		}
	}
	
	public static String get_date_rus_sec() {
		Date dd = new Date();	
		TimeZone tz = TimeZone.getTimeZone("Europe/Moscow");
		Calendar cc = Calendar.getInstance(tz);
		cc.setTime(dd);
		cc.add(Calendar.HOUR, -1);
		
		String s_hh = String.valueOf(cc.get(Calendar.HOUR_OF_DAY));
		String s_mm = String.valueOf(String.format("%02d",cc.get(Calendar.MINUTE)));
		String s_ss = String.valueOf(String.format("%02d",cc.get(Calendar.SECOND)));
		String s_dofm = String.valueOf(cc.get(Calendar.DAY_OF_MONTH));
		String s_dow = String.valueOf(cc.get(Calendar.DAY_OF_WEEK)).replace("1", "воскресенье").replace("2", "понедельник").replace("3", "вторник").replace("4", "среда").replace("5", "четверг").replace("6", "пятница").replace("7", "суббота");
		
		String s = String.valueOf(cc.MONTH);		
		s = s.replace("0", " января ").replace("1", " февраля ")
				.replace("2", " марта ").replace("3", " апреля ")
				.replace("4", " мая ").replace("5", " июня ")
				.replace("6", " июля ").replace("7", " августа ")
				.replace("8", " сентября ").replace("9", " октября ")
				.replace("10", " ноября ").replace("11", " декабря ");

			s = "в Москве "  + " "+s_dow + " "+ s_dofm + s + " " + s_hh + ":"+ s_mm+ ":"+ s_ss ;

		return s;
	}

	
	
}
