package com.portfobio.application.commandexecutor;

import com.portfobio.application.ApplicationThread;

public class CommandExecutorThread extends ApplicationThread<CommandExecutor> {
	private static final String NAME = "Command Executor Thread";

	public CommandExecutorThread(CommandExecutor application) {
		super(application, NAME);
	}

	public void run() {
		while (true) {
			getApplication().executeNextCommand();
		}
	}

}
