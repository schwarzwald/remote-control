package com.portfobio.application.console;

import com.portfobio.application.core.ApplicationModule;

public interface ConsoleModule extends ApplicationModule {

	void printLine(String message);
}
