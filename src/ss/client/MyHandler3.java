package ss.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;

public class MyHandler3 implements ClickHandler {

	private final Service3Async service3 = GWT.create(Service3.class);

	ListBox lb = new ListBox();
	TextArea ta = new TextArea();
	HTML info = new HTML();
	TextBox tb = new TextBox();
	TextBox tb2 = new TextBox();
	String s = "";

	public MyHandler3(ListBox lb, TextBox tb, TextArea ta, HTML info, TextBox tb2) {
		this.lb = lb;
		this.tb = tb;
		this.ta = ta;
		this.info = info;
		this.tb2 = tb2;
		
	}

	@Override
	public void onClick(ClickEvent event) {
		info.setHTML("<img src=/waiting.gif>");
		sendServer(lb, tb, ta, info, tb2);
		info.setHTML("<img src=/waiting.gif>");
		//info.setHTML("ОК7");

	}

	private void sendServer(final ListBox lb, TextBox tb, final TextArea ta, final HTML info, final TextBox tb2) {
		service3.mm3(lb.getItemText(lb.getSelectedIndex()), tb.getText(), ta.getText(), info.getHTML(),tb2.getText(),
				new AsyncCallback<String>() {
					public void onFailure(Throwable caught) {
						info.setHTML(caught.toString());
					}

					@Override
					public void onSuccess(String str) {						
						tb2.setText("");
						info.setHTML(str);		
						//info.setHTML("ОК8");
						tb2.setVisible(false);
					}
				});
	}
}
