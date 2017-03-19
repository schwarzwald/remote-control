package com.portfobio.application.commandexecutor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.portfobio.application.command.ApplicationCommand;
import com.portfobio.application.command.CommandContainer;
import com.portfobio.application.core.Application;
import com.portfobio.application.core.ApplicationModule;
import com.portfobio.application.core.ApplicationModuleInfo;

public class CommandExecutor implements Application {

	private List<ApplicationModule> modules;

	private CommandContainer commandContainer;

	public CommandExecutor() {
		modules = new ArrayList<ApplicationModule>();
	}

	public void setCommandContainer(CommandContainer provider) {
		commandContainer = provider;
	}

	public <T extends ApplicationModule> void registerModule(T module) {
		for (ApplicationModule am : modules) {
			if (am.getClass().equals(module.getClass())) {
				throw new RuntimeException("Module already registered");
			}
		}

		modules.add(module);
	}

	public void executeNextCommand() {
		ApplicationCommand<?> command = commandContainer.getCommand();
		if (command != null) {
			executeCommand(command);
		}
	}

	private <P extends ApplicationModule, T extends ApplicationCommand<P>> void executeCommand(T command) {
		P module = getModuleForCommand(command.getExecutionModuleClass());
		command.execute(module);
	}

	@SuppressWarnings("unchecked")
	private <T extends ApplicationModule> T getModuleForCommand(final Class<T> moduleClass) {

		for (ApplicationModule am : modules) {
			if (moduleClass.isAssignableFrom(am.getClass())) {
				return (T) am;
			}
		}

		throw new RuntimeException("Module for command not found");
	}

	public Collection<ApplicationModuleInfo> getModuleInfos() {
		Collection<ApplicationModuleInfo> infos = new ArrayList<ApplicationModuleInfo>();

		for (ApplicationModule module : modules) {
			infos.add(module.getModuleInfo());
		}

		return infos;
	}

}
