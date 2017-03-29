package com.favaro.libgdx001.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.favaro.libgdx001.LibGDX001;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.title = "Simple 2D Game";
		config.width = 800;
		config.height = 480;

		new LwjglApplication(new LibGDX001(), config);
	}
}
