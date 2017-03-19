package com.portfobio.application.system;

import java.io.IOException;

import com.portfobio.application.BasicModuleInfo;
import com.portfobio.application.core.ApplicationModuleInfo;

public class WindowsSystemModule implements SystemModule {

	private static final String NAME = "Windows System Module";
	private static final String DESCRIPTION = "Module to handle Window system commands";

	public ApplicationModuleInfo getModuleInfo() {
		return new BasicModuleInfo(NAME, DESCRIPTION);
	}

	public void shutdown() {
		execRuntime("shutdown -s");
	}

	public void restart() {
		execRuntime("shutdown -r");
	}

	public void execute(String command) {
		execRuntime(command);
	}

	private void execRuntime(String command) {
		try {
			Runtime.getRuntime().exec(command);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
