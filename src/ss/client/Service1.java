package ss.client;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("serv1")

public interface Service1 extends RemoteService {

	String[] mm4(String slb, String stb, String sta, String saa2)
			throws IllegalArgumentException;

}

