package dta.chat.view.console;

public class ChatConsoleTitleView extends ViewComposite {
	private String title = "= CHAT APP =";

	public ChatConsoleTitleView() {

	}

	@Override
	public void print() {
		System.out.println(title);
	}

}
