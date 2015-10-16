package ss.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;

public class MyHandler implements ChangeHandler, ClickHandler {
	private final ServiceAsync service = GWT.create(Service.class);

	RadioButton rb_owl = new RadioButton("radioGroup", "OWL");
	RadioButton rb_krl = new RadioButton("radioGroup", "КРЯ");
	ListBox lb = new ListBox();
	TextArea ta = new TextArea();
	// HTML qq6 = new HTML();
	TextBox tb = new TextBox();
	String s = "";
	HTML info = new HTML();
	TextBox tb2 = new TextBox();
	Button bb1 = new Button();
	Button bb2 = new Button();
	Button bb3 = new Button();

	public MyHandler(RadioButton rb_owl, RadioButton rb_krl, ListBox lb, TextBox tb, TextArea ta, HTML info,
			TextBox tb2, Button bb1, Button bb2, Button bb3) {

		this.rb_owl = rb_owl;
		this.rb_krl = rb_krl;
		this.lb = lb;
		this.tb = tb;
		this.ta = ta;
		this.info = info;
		this.tb2 = tb2;
		this.bb1 = bb1;
		this.bb2 = bb2;
		this.bb3 = bb3;

	}

	@Override
	public void onChange(ChangeEvent event) {
		info.setHTML("<img src=/waiting.gif>");
		get_lbx(rb_owl, lb, tb, ta);
		ta.setFocus(true);
		//bb2.setVisible(true);
		//bb3.setVisible(false);
		//tb2.setVisible(false);
		// info.setHTML("");
	}

	@Override
	public void onClick(ClickEvent event) {
		info.setHTML("<img src=/waiting.gif>");
		get_b1(lb, tb, ta);
		ta.setFocus(true);
		//bb1.setVisible(true);
		//bb3.setVisible(false);
		//tb2.setVisible(false);
		// info.setHTML("");
	}

	private void get_lbx(RadioButton rb_owl2, ListBox lb2, final TextBox tb, final TextArea ta2) {
		final int i = lb.getSelectedIndex();
		final String s1 = lb.getItemText(i);
		final String s2 = tb.getText();

		service.get_lbx(lb.getItemText(lb.getSelectedIndex()), tb.getText(), ta.getText(),
				new AsyncCallback<String[]>() {
					public void onFailure(Throwable caught) {
						info.setHTML(caught.toString());
					}

					@Override
					public void onSuccess(String[] result) {

						lb.clear();
						lb.addItem("файл");
						lb.addItem("новый");
						// lb.addItem("лог");

						for (String s : result) {
							lb.addItem(s);
						}
						// lb.setSelectedIndex(i);

						service.get_ont(s1, s2, ta.getText(), new AsyncCallback<String[]>() {
							public void onFailure(Throwable caught) {
								// Window.alert(caught.toString());
								info.setHTML(caught.toString());
							}

							@Override
							public void onSuccess(String[] result) {
								tb.setText(result[0]);
								ta.setText(result[1]);
								lb.setSelectedIndex(0);
								tb2.setText("");
								if (result[0].trim().length() == 0)
									{
									info.setHTML("создать новый файл? как назвать?");
									bb2.setVisible(false);
									}
								else 
									{
									info.setHTML("загрузил файл \"" + result[0] + "\"");
									bb2.setVisible(true);
									}
			
								tb.setVisible(true);
								bb1.setVisible(true);
								bb3.setVisible(false);
								ta.setVisible(true);
								
							}
						});

					}

				});
	}

	private void get_b1(ListBox lb2, final TextBox tb, TextArea ta2) {

		final int i = lb.getSelectedIndex();
		final String s1 = lb.getItemText(i);
		final String s2 = tb.getText().replace(" ", "_");
		final String s3 = ta.getText();

		service.get_b1(s1, s2, s3, new AsyncCallback<String[]>() {
			public void onFailure(Throwable caught) {
				Window.alert(caught.toString());
			}

			@Override
			public void onSuccess(String[] result) {

				// bb3.setVisible(false);

				for (String s : result) {

					tb.setText(result[0]);
					ta.setText(result[1]);
					// tim.setHTML(result[2]);
					tb2.setText("");
					/////////////////////////////////

					service.get_lbx(s1, s2, ta.getText(), new AsyncCallback<String[]>() {
						public void onFailure(Throwable caught) {
							Window.alert(caught.toString());
						}

						@Override
						public void onSuccess(String[] result) {

							// Window.alert("get_b1 + get_lbx");

							tb2.setText("");
							lb.clear();
							lb.addItem("файл");
							lb.addItem("новый");
							// lb.addItem("лог");

							for (String s : result) {
								lb.addItem(s);
							}
							lb.setSelectedIndex(0);
							
							if (s2.trim().length() == 0)
							{		
								info.setHTML("создать новый файл? тогда нужно его как-то назвать и чего-то там записать");
								bb2.setVisible(false);
								bb3.setVisible(false);
								tb2.setVisible(false);
							}
							else if (s3.trim().length() == 0)
								{
								info.setHTML("удалил файл \"" + s2 + "\"");
								bb2.setVisible(false);
								bb3.setVisible(false);
								tb2.setVisible(false);
								}
							else
								{
								info.setHTML("сохранил изменения в \"" + s2 + "\"");
								bb2.setVisible(true);
								bb3.setVisible(false);
								tb2.setVisible(false);
								}
							
							//bb1.setVisible(true);
					

						}

					});
					////////////////////////////////////
				}
				// Window.alert(tim.getHTML());

			}
		});

	}
}