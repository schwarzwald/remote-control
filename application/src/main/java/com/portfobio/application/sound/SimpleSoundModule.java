package com.portfobio.application.sound;

import com.portfobio.application.BasicModuleInfo;
import com.portfobio.application.core.ApplicationModuleInfo;

public class SimpleSoundModule implements SoundModule {
	private static final String NAME = "Simple Sound Module";
	private static final String DESCRIPTION = "Module to control the volume of system";
	private int volume;

	public SimpleSoundModule() {

	}

	public void mute() {

	}

	public void unmute() {
		// TODO Auto-generated method stub

	}

	public void adjust(int level) {
		// TODO Auto-generated method stub

	}

	public ApplicationModuleInfo getModuleInfo() {
		return new BasicModuleInfo(NAME, DESCRIPTION);
	}

}
