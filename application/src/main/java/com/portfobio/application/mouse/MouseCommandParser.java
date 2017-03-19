package com.portfobio.application.mouse;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.portfobio.application.command.ApplicationCommand;
import com.portfobio.application.commandreceiver.CommandParser;
import com.portfobio.application.mouse.MouseModule.Button;

public class MouseCommandParser implements CommandParser {
	public static final String PARSER_ID = "MouseCommand";
	private static final Pattern MOVE_TO_PATTERN = Pattern.compile("m (\\d+) (\\d+)");
	private static final Pattern MOVE_BY_PATTERN = Pattern.compile("b (-?\\d+) (-?\\d+)");
	private static final Pattern CLICK_PATTERN = Pattern.compile("c (\\d)");

	public ApplicationCommand<?> parse(String command) {
		Matcher matcher = MOVE_TO_PATTERN.matcher(command);

		if (matcher.find()) {
			int x = Integer.valueOf(matcher.group(1));
			int y = Integer.valueOf(matcher.group(2));

			return new MouseMoveCommand(x, y);
		}

		matcher = MOVE_BY_PATTERN.matcher(command);

		if (matcher.find()) {
			int x = Integer.valueOf(matcher.group(1));
			int y = Integer.valueOf(matcher.group(2));

			return new MouseMoveByCommand(x, y);
		}

		matcher = CLICK_PATTERN.matcher(command);

		if (matcher.find()) {
			Button button = Integer.valueOf(matcher.group(1)) == 1 ? Button.LEFT_BUTTON : Button.RIGHT_BUTTON;

			return new MouseClickCommand(button);
		}

		throw new RuntimeException("Not valid command");
	}

}
