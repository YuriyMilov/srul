package ss.client;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("serv3")
public interface Service3 extends RemoteService {

	String mm3(String slb, String stb, String sta, String sqq6, String stb2) throws IllegalArgumentException;
}
