package com.portfobio.application.command;

public interface CommandContainer {

	public void addCommand(ApplicationCommand<?> command);

	public ApplicationCommand<?> getCommand();
}
