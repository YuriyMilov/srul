package ss.server;

import ss.client.MyService;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;



public class MyServiceImpl extends RemoteServiceServlet implements MyService {

	private static final long serialVersionUID = 1L;

public String myMethod(String s) {
// Do something interesting with 's' here on the server.
return s;
}

public String[] myMethod2(String s) {
	
	s = ss.st.fir("файл").replace("файл\n", "").replace("новый\n", "");

	if(s.contains("\n\n"));
		s=s.replace("\n\n","\n");

	return s.trim().split("\n");
	
	}

}