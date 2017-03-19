package com.portfobio.application.mouse;

import com.portfobio.application.command.ApplicationCommand;

public class MouseMoveCommand implements ApplicationCommand<MouseModule> {
	private int x;
	private int y;

	public MouseMoveCommand(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Class<MouseModule> getExecutionModuleClass() {
		return MouseModule.class;
	}

	public void execute(MouseModule executionModule) {
		executionModule.moveTo(x, y);
	}

}
