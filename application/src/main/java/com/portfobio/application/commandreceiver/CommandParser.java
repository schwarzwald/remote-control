package com.portfobio.application.commandreceiver;

import com.portfobio.application.command.ApplicationCommand;

public interface CommandParser {

	public ApplicationCommand<?> parse(String command);

}
