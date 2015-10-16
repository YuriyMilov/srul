package ss.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;

public class MyHandler1 implements ClickHandler, KeyUpHandler {

	private final Service1Async service1 = GWT
			.create(Service1.class);

	
	ListBox lb = new ListBox();
	TextBox tb = new TextBox();
	TextArea ta = new TextArea();
	HTML info = new HTML();
	TextBox tb2 = new TextBox();
	

	public MyHandler1(ListBox lb, TextBox tb, TextArea ta, HTML info, TextBox tb2 ) {
		this.lb = lb;		
		this.tb = tb;	
		this.ta = ta;
		this.info = info;
		this.tb2 = tb2;		
		tb2.setVisible(false);
	}


	private void sendServer( final ListBox lb,final TextBox tb,final TextArea ta, final HTML info) {	
		
		service1.mm4(lb.getItemText(lb.getSelectedIndex()), tb.getText(), ta.getText(), info.getHTML(), new AsyncCallback<String[]>() {
					public void onFailure(Throwable caught) {
						info.setHTML(caught.toString());
					}

					@Override
					public void onSuccess(String[] ar) {
						String ss="";				
								for(String s:ar){									
									ss=ss+s +"<br/>";									
								}														
								
								info.setHTML(ss);		
								ta.setText(ss);
								info.setHTML("Ок h1 1");
					}
				});
	}

	@Override
	public void onKeyUp(KeyUpEvent event) {
		
		info.setHTML("<img src=/waiting.gif>");
		sendServer(lb, tb, ta, info);
		//info.setHTML("ОК5");
	}


	@Override
	public void onClick(ClickEvent event) {		
		info.setHTML("<img src=/waiting.gif>");
		sendServer(lb, tb, ta, info);
		//info.setHTML("ОК6");
	}
}