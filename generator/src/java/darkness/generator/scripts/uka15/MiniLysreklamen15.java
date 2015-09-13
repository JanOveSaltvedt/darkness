package darkness.generator.scripts.uka15;

import darkness.generator.api.BulbGroup;
import darkness.generator.api.BulbRGB;
import darkness.generator.api.BulbSet;

import java.awt.*;
import java.util.Random;

public class MiniLysreklamen15 extends BaseScriptUka15 {
	@Override
	public void run() {
		super.run();
		
		randomBulbs();
		fadeIn();

		for (BulbGroup letter : letters) {
			rgbFade(letter, 255, 255, 255, 4);
			skip(4);
		}

		skip(4);

		rainbow();
		turnOnSequentially();

		skip(16);

		/*


		skip(16);

		// Circus sign
		{
			int i = 0;

			// Fade each bulb to a semi-random colour
			for( int j = 0; j < 32; ++j) {
				for (BulbGroup letter : letters) {
					for (BulbRGB bulb : letter) {
						float col[] = {i * 0.15f % 1.0f, 0.4f, 0.8f};
						//hsbFade(bulb, col, 16);
						setHSB(bulb, col[0], col[1], col[2]);
						i++;
					}
				}
				next();
			}
		}

		// Horizontal rainbow
		int numColors = columns.length;
		Color colors[] = new Color[numColors];

		for (int i = 0; i < columns.length; ++i) {
			colors[i] = Color.getHSBColor((1.0f/numColors)*i, 0.4f, 0.8f);
		}

		for (int i = 0; i < 64; ++i) {
			int j = 0;
			for (BulbGroup col : columns) {
				for (BulbRGB bulb : col) {
					setRGB(bulb, colors[(i + j) % numColors]);
				}
				++j;
			}
			next();
		}

		skip(32);
		*/
	}

	private void randomBulbs() {
		// Show some (semi)random bulbs in each letter
		Random r = new Random();

		BulbGroup[] kindaRandom = {C, F, A, D, G, E, B};

		for (int i = 0; i < 3; ++i) {

			for (BulbGroup letter : kindaRandom) {
				BulbRGB bulb = letter.getBulb(r.nextInt(letter.numBulbs));
				bulb.setHSB(r.nextFloat(), 0.6f, 0.7f);
				next();
				bulb.set(0, 0, 0);
				if (i < 2) {
					skip(2-i);
				}
			}
		}
	}

	private void fadeIn() {
		BulbGroup[] kindaRandom = {C, F, A, D, G, E, B};

		int i = 0;

		for (BulbGroup letter : kindaRandom) {
			float col[] = { i/ 6f, 0.6f, 0.6f };
			rgbFade(letter, 255, 255, 255, 4);
			skip(4);

			hsbFade(letter, col, 4);
			skip(8);

			++i;
		}
	}

	private void rainbow() {
		// Horizontal rainbow
		int numColors = columns.length;
		Color colors[] = new Color[numColors];

		for (int i = 0; i < columns.length; ++i) {
			colors[i] = Color.getHSBColor((1.0f/numColors)*i, 0.4f, 0.8f);
		}

		for (int i = 0; i < 64; ++i) {
			int j = 0;
			for (BulbGroup col : columns) {
				for (BulbRGB bulb : col) {
					setRGB(bulb, colors[(i + j) % numColors]);
				}
				++j;
			}
			next();
		}
	}

	private void turnOnSequentially() {

		for (BulbGroup letter : letters) {
			letter.set(0, 0, 0);
		}

		// Turn each bulb on one by one
		for (BulbGroup letter : letters) {
			for (BulbRGB bulb : letter) {
				setRGB(bulb, Color.WHITE);
				next();
			}
		}
	}
}
