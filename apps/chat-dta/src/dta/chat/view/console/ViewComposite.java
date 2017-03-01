package dta.chat.view.console;

import java.util.ArrayList;
import java.util.List;

public abstract class ViewComposite {

	private List<ViewComposite> children = new ArrayList<>();

	public void print() {
		for (ViewComposite view : children) {
			view.print();
		}
	}

	public void add(ViewComposite view) {
		children.add(view);
	}
}
