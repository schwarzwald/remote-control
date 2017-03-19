package com.portfobio.application.command;

import com.portfobio.application.core.ApplicationModule;

public interface ApplicationCommand<T extends ApplicationModule> {

	public Class<T> getExecutionModuleClass();

	public void execute(T executionModule);
}
