package ss.server;

import javax.servlet.ServletRequest;

import ss.client.Service2;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class Service2Impl extends RemoteServiceServlet implements
		Service2 {
	
	public String[] mm4(String slb, String stb, String sta, String qq6)
			throws IllegalArgumentException {
		
		ServletRequest req= super.getThreadLocalRequest();
		String sh = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort();
		ss.st.sout="Адрес файла (URL): "+sh+"/owl?"+stb;		

		return new String[] { sh+"/owl?"+stb, sta, "<br/>" };
		
	}	
	
}
