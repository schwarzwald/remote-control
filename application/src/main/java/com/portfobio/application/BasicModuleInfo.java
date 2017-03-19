package com.portfobio.application;

import com.portfobio.application.core.ApplicationModuleInfo;

public class BasicModuleInfo implements ApplicationModuleInfo {

	private String name;
	private String description;

	public BasicModuleInfo(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

}
