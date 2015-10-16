package ss.server;

import java.util.ArrayList;

import ss.client.Service1;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;


@SuppressWarnings("serial")
public class Service1Impl extends RemoteServiceServlet implements Service1 {

	@Override
	public String[] mm4(String slb, String stb, String sta, String saa2)
			throws IllegalArgumentException {

		//System.err.println("111111111111");
		
		String	sont = ss.st.fir("файл");
		ss.st.fiw("файл", sont+"\n");
		ss.st.fiw(sont, sta);
		
		
		ArrayList<String> ar = new ArrayList<String>();
		ar.add(ss.st.fir("файл"));
		ar.add(stb);
		ar.add(sta);
		
		String[] sss=new String[ar.size()];
		
		return sss;
	}	
}
