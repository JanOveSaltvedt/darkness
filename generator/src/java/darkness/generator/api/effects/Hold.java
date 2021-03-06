package darkness.generator.api.effects;

import darkness.generator.api.BulbSet;

import java.awt.*;

public class Hold extends EffectBase {
	private final BulbSet bulbSet;
	private final Color color;
	private final int frames;

	public Hold(BulbSet bulbSet, Color color, int frames) {
		this.bulbSet = bulbSet;
		this.color = color;
		this.frames = frames;
	}

	@Override
	public void run() {
		for (int f = 0; f < frames && !isCancelled(); f++) {
			set(bulbSet, color);
			next();
		}
	}

	@Override
	public String toString() {
		return "Effect Hold on " + bulbSet + " for color " + color + " over " + frames + " frames.";
	}
}
