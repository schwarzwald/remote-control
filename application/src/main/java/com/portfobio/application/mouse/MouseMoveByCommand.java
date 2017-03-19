package com.portfobio.application.mouse;

import com.portfobio.application.command.ApplicationCommand;

public class MouseMoveByCommand implements ApplicationCommand<MouseModule> {

	private int dx;
	private int dy;

	public MouseMoveByCommand(int dx, int dy) {
		this.dx = dx;
		this.dy = dy;
	}

	public Class<MouseModule> getExecutionModuleClass() {
		return MouseModule.class;
	}

	public void execute(MouseModule executionModule) {
		executionModule.moveBy(dx, dy);
	}

}
