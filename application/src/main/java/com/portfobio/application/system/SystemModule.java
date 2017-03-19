package com.portfobio.application.system;

import com.portfobio.application.core.ApplicationModule;

public interface SystemModule extends ApplicationModule {

	public void shutdown();

	public void restart();

	public void execute(String command);

}
