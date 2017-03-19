package com.portfobio.application.system.command;

import com.portfobio.application.command.ApplicationCommand;
import com.portfobio.application.system.SystemModule;

public class SystemShutdownCommand implements ApplicationCommand<SystemModule> {

	public Class<SystemModule> getExecutionModuleClass() {
		return SystemModule.class;
	}

	public void execute(SystemModule executionModule) {
		executionModule.shutdown();
	}

}
