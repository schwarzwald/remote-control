package com.portfobio.application.console;

import com.portfobio.application.command.ApplicationCommand;

public class PrintMessageCommand implements ApplicationCommand<ConsoleModule> {

	private String message;

	public PrintMessageCommand(String message) {
		this.message = message;
	}

	public Class<ConsoleModule> getExecutionModuleClass() {
		return ConsoleModule.class;
	}

	public void execute(ConsoleModule executionModule) {
		executionModule.printLine(message);
	}

}
