package ss.client;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ServiceAsync {

	
	void get_lbx(String itemText, String text, String text2,
			AsyncCallback<String[]> asyncCallback);
	
	void get_b1(String itemText, String text, String text2,
			AsyncCallback<String[]> asyncCallback);

	void get_ont(String itemText, String text, String text2,
			AsyncCallback<String[]> asyncCallback);
}
