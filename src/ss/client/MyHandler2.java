package ss.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;

public class MyHandler2 implements ClickHandler, KeyUpHandler {

	private final Service2Async service2 = GWT
			.create(Service2.class);

	
	ListBox lb = new ListBox();
	TextBox tb = new TextBox();
	TextArea ta = new TextArea();
	HTML info = new HTML();
	TextBox tb2 = new TextBox();
	Button bb3 = new Button();

	public MyHandler2(ListBox lb, TextBox tb, TextArea ta, HTML info, TextBox tb2, Button bb3) {
		this.lb = lb;		
		this.tb = tb;	
		this.ta = ta;
		this.info = info;
		this.tb2 = tb2;	
		this.bb3 = bb3;
		
	}


	private void send2Server( ListBox lb,TextBox tb,TextArea ta, final TextBox tb2, final HTML info) {
		
		
		service2.mm4(lb.getItemText(lb.getSelectedIndex()), tb.getText(), ta.getText(), info.getHTML(), new AsyncCallback<String[]>() {
					public void onFailure(Throwable caught) {
						info.setHTML(caught.toString());
					}

					@Override
					public void onSuccess(String[] result) {
						
						tb2.setText(result[0]);
						info.setHTML(result[2]);
						bb3.setVisible(true);
						tb2.setVisible(true);
						info.setHTML("");
					}
			
				});
	}

	@Override
	public void onKeyUp(KeyUpEvent event) {
		
		info.setHTML("<img src=/waiting.gif>");
		send2Server(lb, tb, ta, tb2, info);
		//info.setHTML("ОК2");
	}


	@Override
	public void onClick(ClickEvent event) {		
		info.setHTML("<img src=/waiting.gif>");
		send2Server(lb, tb, ta, tb2, info);
		//info.setHTML("ОК3");

	}
}