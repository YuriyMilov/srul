package ss.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class SSEAsyncServlet extends HttpServlet {

	public static int i = 0;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {
		res.setContentType("text/event-stream");
		res.setCharacterEncoding("UTF-8");
		PrintWriter writer = res.getWriter();
		String s=ss.st.fir("лог");
		if ((ss.st.sout.trim().length() > 0)) {
			s=s+ss.st.sout.trim()+"\r\n > ";
			
			ss.st.fiw("лог", s);
			
			writer.write("data: " + ss.st.sout + "\n\n");
			writer.flush();
			ss.st.sout = "";
		} else {
			while (ss.st.sout.trim().length() == 0)
				try {
					Thread.sleep(222);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		}

	}

}
