package com.portfobio.application.domain;

import java.util.ArrayList;
import java.util.List;

import com.portfobio.application.command.ApplicationCommand;
import com.portfobio.application.command.CommandContainer;

public class QueuedCommandContainer implements CommandContainer {

	private List<ApplicationCommand<?>> commandQueue;

	public QueuedCommandContainer() {
		commandQueue = new ArrayList<ApplicationCommand<?>>();
	}

	public synchronized void addCommand(ApplicationCommand<?> command) {
		commandQueue.add(command);
	}

	public synchronized ApplicationCommand<?> getCommand() {
		return !commandQueue.isEmpty() ? commandQueue.remove(0) : null;
	}

	public Integer getSize() {
		return commandQueue.size();
	}
}
