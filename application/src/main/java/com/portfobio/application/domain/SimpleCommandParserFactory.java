package com.portfobio.application.domain;

import java.util.HashMap;
import java.util.Map;

import com.portfobio.application.commandreceiver.CommandParser;
import com.portfobio.application.commandreceiver.CommandParserFactory;

public class SimpleCommandParserFactory implements CommandParserFactory {
	private Map<String, CommandParser> parserMap = new HashMap<String, CommandParser>();

	public void registerParser(String parserId, CommandParser parser) {
		parserMap.put(parserId, parser);
	}

	public CommandParser createFor(String parserId) {
		return parserMap.get(parserId);
	}

}
