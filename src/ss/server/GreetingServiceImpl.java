package ss.server;

import javax.servlet.http.HttpServletRequest;

import ss.client.GreetingService;
import ss.shared.FieldVerifier;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements
		GreetingService {
int i =7;
	@Override
	public String greetServer(String name) throws IllegalArgumentException {
		//try {
		//	Thread.sleep(2222);
		//} catch (InterruptedException e) {
		//	e.printStackTrace();
		//}
	
		HttpServletRequest req = this.getThreadLocalRequest();
		String sh= req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + req.getContextPath();
		
		//s=ss.st.rfu_utf(sh+"/sse?7");
		//String  s=ss.st.rfu_utf(sh+"/ontos");
		
	 	String s = "http://bb.feofan.com/neznaik.owl";

		
	      try {
	    	  //result of asynchron call
	    	 // j++;
	    		//s	= ss.st.rfu_utf(s);	
	    		//s=ss.st.kuka2(s);
	    		//System.err.println("-->  "+s);
	    	
			Thread.sleep(111);
		} catch (InterruptedException e) {
			
			System.err.println("-->  "+e.toString());
			
		}          

	    //  out.println(String.valueOf(j) + " " + s);
	      
	   
	     // s=ss.st.fir("онтологии").replace("\r", "");
		return s;
	    	      
	}

}
