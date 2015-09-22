package darkness.generator.scripts.uka15;

import darkness.generator.api.BulbGroup;
import darkness.generator.api.BulbRGB;

import java.awt.Color;

public class DemoScriptUka15 extends BaseScriptUka15 {
	@Override
	public void run() {
		super.run();

		for (BulbGroup letter : letters) {
			for (BulbRGB bulb : letter) {
				set(bulb, Color.GREEN);
				next();
			}
		}

		skip(96);

		for (int i = 0; i < 4; i++) {
			merge(new DemoSubScript15());
			next();
		}

		skip(96);

	}
}
