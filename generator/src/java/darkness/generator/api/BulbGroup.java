package darkness.generator.api;

import java.awt.Color;
import java.util.Arrays;
import java.util.List;

/**
 * A group of one or more bulbs, that can mostly be treated as one "big" bulb through the {@link BulbSet} interface.
 */
public class BulbGroup implements BulbSet {
	private final List<BulbRGB> bulbs;

	/**
	 * Create a bulb group that consists of the given bulbs.
	 */
	public BulbGroup(BulbRGB... bulbs) {
		if (bulbs == null || bulbs.length == 0) {
			throw new IllegalArgumentException("bulbs must be non-null and contain elements");
		}
		this.bulbs = Arrays.asList(bulbs);
	}

	/**
	 * Set all bulbs in the group to the given RGB color.
	 */
	@Override
	public void set(int red, int green, int blue) {
		for (BulbRGB bulb : bulbs) {
			bulb.set(red, green, blue);
		}
	}

	/**
	 * Set all bulbs in the group to the given RGB color.
	 */
	@Override
	public void set(Color color) {
		for (BulbRGB bulb : bulbs) {
			bulb.set(color);
		}
	}

	/**
	 * Set all bulbs in the group to the given HSB color.
	 */
	@Override
	public void setHSB(float hue, float saturation, float brightness) {
		for (BulbRGB bulb : bulbs) {
			bulb.setHSB(hue, saturation, brightness);
		}
	}

	/**
	 * @return The red component of the first bulb in the group.
	 */
	@Override
	public int getRed() {
		return bulbs.get(0).getRed();
	}

	/**
	 * @return The green component of the first bulb in the group.
	 */
	@Override
	public int getGreen() {
		return bulbs.get(0).getGreen();
	}

	/**
	 * @return The blue component of the first bulb in the group.
	 */
	@Override
	public int getBlue() {
		return bulbs.get(0).getBlue();
	}

	/**
	 * @return A string describing the channels and current values of the bulbs in this group.
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("BulbSet{");
		for (BulbRGB bulb : bulbs) {
			sb.append(bulb);
			sb.append(',');
		}
		sb.setCharAt(sb.length() - 1, '}'); // Overwrite trailing comma
		return sb.toString();
	}

	/**
	 * @return The RGB color of the first bulb in the group.
	 */
	@Override
	public Color getColor() {
		return bulbs.get(0).getColor();
	}
}