package ss.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("serv")
public interface Service extends RemoteService {

	String[] get_lbx(String slbx, String stb, String sta) throws IllegalArgumentException;
	String[] get_b1(String slbx, String stb, String sta) throws IllegalArgumentException;
	String[] get_ont(String slbx, String stb, String sta) throws IllegalArgumentException;
}
