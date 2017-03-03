package dta.chat.view.console;

import java.util.ArrayList;
import java.util.List;

import dta.chat.controller.ChatAuthController;
import dta.chat.model.ChatMessage;
import dta.chat.model.observer.ChatObservable;
import dta.chat.model.observer.ChatObserver;

public abstract class ViewComposite implements ChatObserver<ChatMessage> {
	private List<ViewComposite> children = new ArrayList<>();
	protected ChatAuthController authController;
	protected String user;

	public void print() {
		for (ViewComposite view : children) {
			view.print();
		}
	}

	public void add(ViewComposite view) {
		children.add(view);
	}

	public void setAuthController(ChatAuthController authController) {
		this.authController = authController;
		this.children.forEach(view -> view.setAuthController(authController));
	}

	public void setLogin(String login) {
		this.user = login;
		this.children.forEach(view -> view.setLogin(login));
	}

	@Override
	public void update(ChatObservable<ChatMessage> observable, ChatMessage obj) {
		children.forEach(view -> view.update(observable, obj));
	}

}
