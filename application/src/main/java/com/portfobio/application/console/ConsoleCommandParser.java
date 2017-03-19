package com.portfobio.application.console;

import com.portfobio.application.command.ApplicationCommand;
import com.portfobio.application.commandreceiver.CommandParser;

public class ConsoleCommandParser implements CommandParser {
	public static final String PARSER_ID = "ConsoleCommand";

	public ApplicationCommand<?> parse(String command) {
		if (command.charAt(0) == 'p') {
			String message = command.substring(2);
			return new PrintMessageCommand(message);
		}

		throw new RuntimeException("Not valid command");
	}
}
