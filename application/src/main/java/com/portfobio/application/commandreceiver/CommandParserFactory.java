package com.portfobio.application.commandreceiver;

public interface CommandParserFactory {

	public CommandParser createFor(String commandId);
}
