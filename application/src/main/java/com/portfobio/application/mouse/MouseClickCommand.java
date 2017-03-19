package com.portfobio.application.mouse;

import com.portfobio.application.command.ApplicationCommand;
import com.portfobio.application.mouse.MouseModule.Button;

public class MouseClickCommand implements ApplicationCommand<MouseModule> {

	private Button button;

	public MouseClickCommand(Button button) {
		this.button = button;
	}

	public Class<MouseModule> getExecutionModuleClass() {
		return MouseModule.class;
	}

	public void execute(MouseModule executionModule) {
		executionModule.click(button);
	}

}
