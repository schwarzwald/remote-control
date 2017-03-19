package com.portfobio.application.mouse;

import com.portfobio.application.core.ApplicationModule;

public interface MouseModule extends ApplicationModule {
	public enum Button {
		LEFT_BUTTON, RIGHT_BUTTON
	}

	public void moveTo(int x, int y);

	public void moveBy(int x, int y);

	public void click(Button button);
}
