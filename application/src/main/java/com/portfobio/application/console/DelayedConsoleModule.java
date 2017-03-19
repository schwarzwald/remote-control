package com.portfobio.application.console;

import com.portfobio.application.BasicModuleInfo;
import com.portfobio.application.core.ApplicationModuleInfo;

public class DelayedConsoleModule implements ConsoleModule {
	private static final String NAME = "Console printer";
	private static final String DESCRIPTION = "Module to print messages on console";

	public void printLine(final String message) {
		try {
			Thread.sleep(10);
			System.out.println(message);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public ApplicationModuleInfo getModuleInfo() {
		return new BasicModuleInfo(NAME, DESCRIPTION);
	}

}
