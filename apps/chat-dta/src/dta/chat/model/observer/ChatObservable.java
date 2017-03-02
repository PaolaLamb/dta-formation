package dta.chat.model.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class ChatObservable<T> {

	protected List<ChatObserver<T>> observers = new ArrayList<>();

	public void addObserver(ChatObserver<T> observer) {
		this.observers.add(observer);
	}

	public void removeObserver(ChatObserver<T> observer) {
		this.observers.remove(observer);
	}

	public void notifyObservers(T msg) {
		for (ChatObserver<T> observer : observers) {
			observer.update(this, msg);
		}
	}

}
