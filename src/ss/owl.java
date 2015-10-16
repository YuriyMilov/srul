package ss;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class owl extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		String sh = req.getScheme() + "://" + req.getServerName() + ":"
				+ req.getServerPort() + req.getContextPath();

		ServletOutputStream out = resp.getOutputStream();
		resp.setContentType("text/plain; charset=UTF-8");
		
		resp.setCharacterEncoding("UTF8");
		String s = "";
				String sq = URLDecoder.decode(req.getQueryString(), "UTF-8");
				
		
		s = ss.st.fir(sq);
	
		
		
		byte[] b = s.getBytes("UTF-8");
		resp.setHeader("Content-Disposition", "attachment; filename="+sq+".owl");
		out.write(b);
	}

	private static final long serialVersionUID = 1L;
}