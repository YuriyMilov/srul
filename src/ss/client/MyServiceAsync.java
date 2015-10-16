package ss.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

interface MyServiceAsync {
	  public void myMethod(String s, AsyncCallback<String> callback);
	  public void myMethod2(String s, AsyncCallback<String[]> callback);
	}