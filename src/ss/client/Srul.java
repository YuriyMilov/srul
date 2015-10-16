package ss.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Srul implements EntryPoint {

	final Button bb1 = new Button(" Создать, изменить или удалить (если пусто) ");
	final Button bb2 = new Button(" Адрес онтологии после загрузки, создания или изменения");
	final Button bb3 = new Button(" Запустить на этой онтологии резонёр ");
	final HTML info = new HTML();
	//final HTML tim = new HTML();

	public void onModuleLoad() {
		RadioButton radioButton1 = new RadioButton("radioGroup", "OWL");
		RadioButton radioButton2 = new RadioButton("radioGroup", "КРЯ");
		radioButton1.setValue(true);
		radioButton2.setEnabled(true);
		HorizontalPanel h_panel = new HorizontalPanel();
		VerticalPanel v_panel= new VerticalPanel();

		ListBox lbx = new ListBox();
		lbx.setWidth("333px");
		TextBox tb = new TextBox();
		tb.setVisible(false);
		tb.setWidth("333px");
		
		TextBox tb2 = new TextBox();
		tb2.setWidth("333px");
		tb2.setVisible(false);
		TextArea ta = new TextArea();
		ta.setWidth("655px");
		ta.setHeight("400px");
		ta.setVisible(false);	

		MyHandler mh = new MyHandler(radioButton1, radioButton2, lbx, tb, ta, info, tb2, bb1, bb2, bb3);
		bb1.addClickHandler(mh);
		bb1.setVisible(false);
		lbx.addChangeHandler(mh);
		init_lbx(lbx);

		bb2.addClickHandler(new MyHandler2(lbx, tb, ta, info, tb2, bb3));
		bb2.setVisible(false);
		bb3.addClickHandler(new MyHandler3(lbx, tb, ta, info, tb2));
		bb3.setVisible(false);
		
		radioButton1.addClickHandler(new RbHandler(radioButton1, radioButton2, ta, info));
		radioButton2.addClickHandler(new RbHandler(radioButton1, radioButton2, ta, info));
		tb2.setVisible(false);
		bb2.setVisible(false);


		tb2.setVisible(false);
		h_panel.setSpacing(5);
		h_panel.add(new HTML("Выбрать:"));
		h_panel.add(radioButton1);
		h_panel.add(radioButton2);
		v_panel.setSpacing(10);
		v_panel.add(h_panel);
		v_panel.add(lbx);
		v_panel.add(tb);
		v_panel.add(bb1);
		v_panel.add(bb2);
		v_panel.add(tb2);
		v_panel.add(bb3);
		v_panel.add(info);

		info.setHTML("<img src=/waiting.gif>");

		RootPanel.get("left").add(v_panel);
		RootPanel.get("right").add(new HTML("<div> <br /><br />Превод OWL <->КРЯ использует упрощенный Манчестерский синтаксис<br /><br /></div>"));
		RootPanel.get("right").add(ta);
		
	}

	void init_lbx(final ListBox lb2) {
		
		final MyServiceAsync ms = GWT.create(MyService.class);
		
		ms.myMethod2("", new AsyncCallback<String[]>() {
			public void onFailure(Throwable caught) {
				Window.alert(caught.toString());
			}

			public void onSuccess(String[] result) {
				lb2.clear();
				lb2.addItem("файл");
				lb2.addItem("новый");

				for (String s : result) {
					lb2.addItem(s);
				}
				info.setHTML("");
			}
		});
	}

}
