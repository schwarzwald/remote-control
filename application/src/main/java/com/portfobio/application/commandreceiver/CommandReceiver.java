package com.portfobio.application.commandreceiver;

import com.portfobio.application.command.CommandContainer;

public interface CommandReceiver {

	public void setCommandContainer(CommandContainer container);

	public void receiveCommand();
}
