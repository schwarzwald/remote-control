package com.portfobio.application.sound;

import com.portfobio.application.core.ApplicationModule;

public interface SoundModule extends ApplicationModule {

	public void mute();

	public void unmute();

	public void adjust(int level);
}
