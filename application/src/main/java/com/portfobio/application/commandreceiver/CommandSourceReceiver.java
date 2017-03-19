package com.portfobio.application.commandreceiver;

import com.portfobio.application.command.CommandContainer;
import com.portfobio.networking.Receiver;

public class CommandSourceReceiver implements CommandReceiver {
	private CommandContainer container;
	private CommandParserFactory factory;
	private Receiver receiver;

	public void setCommandContainer(CommandContainer container) {
		this.container = container;
	}

	public void setReceiver(Receiver receiver) {
		this.receiver = receiver;
	}

	public void setCommandParserFactory(CommandParserFactory factory) {
		this.factory = factory;
	}

	public void receiveCommand() {
		String message = null;
		do {
			message = receiveMessage();
			System.out.println(message);
		} while (!isCommandValid(message));

		parseAndAddCommandToContainer(message);
	}

	private String receiveMessage() {
		byte[] data = receiver.receive();

		return new String(data);
	}

	private boolean isCommandValid(String message) {
		if (message == null) {
			return false;
		}

		if (message.length() == 0) {
			return false;
		}

		if (message.indexOf(' ') == -1) {
			return false;
		}

		if (message.trim().length() == 0) {
			return false;
		}

		return true;
	}

	private void parseAndAddCommandToContainer(String message) {
		int endOfCommandId = message.indexOf(' ');
		String commandId = message.substring(0, endOfCommandId);
		String command = message.substring(endOfCommandId + 1);

		CommandParser parser = factory.createFor(commandId);
		if (parser != null) {
			container.addCommand(parser.parse(command));
		}
	}

}
