package com.portfobio.application.core;

import java.util.Collection;

public interface Application {

	public <T extends ApplicationModule> void registerModule(T module);

	public Collection<ApplicationModuleInfo> getModuleInfos();

}
