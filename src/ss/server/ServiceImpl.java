package ss.server;

import ss.client.Service;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class ServiceImpl extends RemoteServiceServlet implements Service {
	String msg="";
			
	
	@Override
	public String[] get_lbx(String slbx, String stb, String sta)
			throws IllegalArgumentException {

		
		
		String s = ss.st.fir("файл").replace("файл\n", "")
				.replace("новый\n", "");

		if (s.contains("\n\n"));
		s = s.replace("\n\n", "\n");

		return s.trim().split("\n");
	}

	@Override
	public String[] get_b1(String slbx, String stb, String sta)
			throws IllegalArgumentException {

		ss.st.sout="";
		
		String s = "", s1 = ("\n"+ss.st.fir("файл")+"\n").replace("\n\n", "\n");
		

		if (slbx.trim().equals("файл") && stb.trim().length() == 0
				&& sta.trim().length() == 0) {
			stb = "";
			s=sta;
			msg="кляк - а ничего нет";
		}
		else
			if (slbx.trim().equals("файл") && stb.trim().length() == 0
			&& sta.trim().length() > 0) {
		stb = "";
		s=sta;
		msg="файл не имеет названия";
	}
	else
		if (slbx.trim().equals("файл") && stb.trim().length() > 0 && sta.trim().length() > 0) 
		{
			while (s1.contains("\n"+stb+"\n")) {
				s1 = ss.st.fir("файл").replace(stb, "")
						.replace("\n\n", "\n");
				ss.st.fid(stb);
				ss.st.fiw("файл", (s1 + "\n").trim());
			}

			ss.st.fiw("файл", (s1 + "\n"+stb+"\n").replace("\n\n", "\n").trim());
			//s = sta.trim();
			ss.st.fiw(stb, sta);
			s = ss.st.fir(stb);
			
			msg="сохранён файл '"+ stb+"'";	
		} else
		
			if (slbx.trim().equals("файл") && stb.trim().length() > 0
				&& sta.trim().length() == 0)

		{	while (s1.contains("\n"+stb+"\n")) {
			s1 = "\n"+ss.st.fir("файл")+ "\n";
			s1=s1.replace("\n"+stb+"\n", "\n").replace("\n\n", "\n");
			ss.st.fid(stb);
			s1=s1.replace("\n\n", "\n");			
			ss.st.fiw("файл", s1);
		}
		//if(stb.equals("лог"))
		//	msg="лог очищен";	
		//else
		msg="удалён пустой файл '"+ stb+"'";	
			stb = "";
			s = "";
		}

		ss.st.sout=msg;
		
		return new String[] { stb, s, msg };
	}

	@Override
	public String[] get_ont(String slbx, String stb, String sta2)
			throws IllegalArgumentException {
	
		String s = "";

		if (slbx.trim().equals("файл") || slbx.trim().equals("новый")
				|| stb.trim().equals("файл") || stb.trim().equals("новый")) {
			stb = "";
			s="";
			msg = "что-то новенькое?";			
		
		}
		else {
			stb = slbx;
			s = ss.st.fir(stb);
			msg = "выбран файл '" + stb+"'";			
		
		}

		ss.st.sout=msg;
		
		return new String[] { stb, s };
	}

}
