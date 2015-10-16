package ss.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("ms")
public interface MyService extends RemoteService {
	  public String myMethod(String s);
	  public String[] myMethod2(String s);
	}