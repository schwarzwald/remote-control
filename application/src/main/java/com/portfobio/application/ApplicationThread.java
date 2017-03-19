package com.portfobio.application;

import com.portfobio.application.core.Application;

public abstract class ApplicationThread<T extends Application> extends Thread {
	private T application;

	public ApplicationThread(T application, String name) {
		super(name);
		this.application = application;
	}

	public T getApplication() {
		return application;
	}
}
