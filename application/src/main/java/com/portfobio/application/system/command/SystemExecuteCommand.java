package com.portfobio.application.system.command;

import com.portfobio.application.command.ApplicationCommand;
import com.portfobio.application.system.SystemModule;

public class SystemExecuteCommand implements ApplicationCommand<SystemModule> {

	private String command;

	public SystemExecuteCommand(String command) {
		this.command = command;
	}

	public Class<SystemModule> getExecutionModuleClass() {
		return SystemModule.class;
	}

	public void execute(SystemModule executionModule) {
		executionModule.execute(command);
	}

}
