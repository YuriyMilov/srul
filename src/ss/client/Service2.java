package ss.client;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("serv2")
public interface Service2 extends RemoteService {

	String[] mm4(String slb, String stb, String sta, String qq6) throws IllegalArgumentException;
}
