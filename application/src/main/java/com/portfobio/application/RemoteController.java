package com.portfobio.application;

import com.portfobio.application.command.CommandContainer;
import com.portfobio.application.commandexecutor.CommandExecutor;
import com.portfobio.application.commandexecutor.CommandExecutorThread;
import com.portfobio.application.commandreceiver.CommandParserFactory;
import com.portfobio.application.commandreceiver.CommandReceiver;
import com.portfobio.application.commandreceiver.CommandSourceReceiver;
import com.portfobio.application.console.ConsoleCommandParser;
import com.portfobio.application.console.DelayedConsoleModule;
import com.portfobio.application.core.ApplicationModuleInfo;
import com.portfobio.application.domain.QueuedCommandContainer;
import com.portfobio.application.domain.SimpleCommandParserFactory;
import com.portfobio.application.mouse.MouseCommandParser;
import com.portfobio.application.mouse.RobotMouseModule;
import com.portfobio.application.system.SystemCommandParser;
import com.portfobio.application.system.WindowsSystemModule;
import com.portfobio.networking.Receiver;
import com.portfobio.networking.datagram.DatagramReceiver;

public class RemoteController {
	private static CommandExecutor application;
	private static CommandContainer commandContainer;
	private static CommandReceiver commandReceiver;

	private static final int PORT = 9999;

	public static void main(String[] args) {
		assemblyApplication();
		run();
	}

	private static void assemblyApplication() {
		createApplication();
		createCommandContainer();
		createAndRegisterModules();
		createCommandReceiver();

		application.setCommandContainer(commandContainer);
	}

	private static void createApplication() {
		application = new CommandExecutor();
	}

	private static void createCommandContainer() {
		commandContainer = new QueuedCommandContainer();
	}

	private static void createAndRegisterModules() {
		application.registerModule(new DelayedConsoleModule());
		application.registerModule(new RobotMouseModule());
		application.registerModule(new WindowsSystemModule());
	}

	private static void createCommandReceiver() {
		CommandSourceReceiver receiver = new CommandSourceReceiver();
		receiver.setCommandContainer(commandContainer);
		receiver.setCommandParserFactory(createCommandParserFactory());
		receiver.setReceiver(createReceiver());

		commandReceiver = receiver;
	}

	private static Receiver createReceiver() {
		return new DatagramReceiver(PORT);
	}

	private static CommandParserFactory createCommandParserFactory() {
		SimpleCommandParserFactory factory = new SimpleCommandParserFactory();
		factory.registerParser(ConsoleCommandParser.PARSER_ID, new ConsoleCommandParser());
		factory.registerParser(MouseCommandParser.PARSER_ID, new MouseCommandParser());
		factory.registerParser(SystemCommandParser.PARSER_ID, new SystemCommandParser());

		return factory;
	}

	private static void run() {
		CommandExecutorThread thread = new CommandExecutorThread(application);
		thread.setDaemon(true);
		thread.start();

		printStartedInfo();

		while (true) {
			commandReceiver.receiveCommand();
		}
	}

	private static void printStartedInfo() {
		System.out.println("App started");
		System.out.println("---------------------");
		System.out.println("Modules:");

		for (ApplicationModuleInfo info : application.getModuleInfos()) {
			System.out.println(info.getName());
		}

		System.out.println("---------------------");

	}

}
