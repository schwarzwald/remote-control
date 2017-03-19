package com.portfobio.application.system;

import com.portfobio.application.command.ApplicationCommand;
import com.portfobio.application.commandreceiver.CommandParser;
import com.portfobio.application.system.command.SystemRestartCommand;
import com.portfobio.application.system.command.SystemShutdownCommand;

public class SystemCommandParser implements CommandParser {
	public static final String PARSER_ID = "SystemCommand";

	public ApplicationCommand<?> parse(String command) {
		char commandSwitch = command.charAt(0);

		switch (commandSwitch) {
		case 's':
			return new SystemShutdownCommand();
		case 'r':
			return new SystemRestartCommand();
			// case 'e':
			// String message = command.substring(2);
			// return new SystemExecuteCommand(message);
		}

		return null;
	}

}
