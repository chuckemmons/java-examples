package com.cee.example.richfaces.framework.ui;

/**
 * label-value pair representation of skins for richfaces.
 * 
 * @author chuck
 *
 */
public enum Skin {
	/* Richfaces predefined skins */
	DEFAULT("Default", "DEFAULT"),
	PLAIN("Plain", "plain"),
	EMERALD_TOWN("Emerald Town", "emeraldTown"),
	BLUE_SKY("Blue Sky", "blueSky"),
	WINE("Wine", "wine"),
	JAPAN_CHERRY("Japan Cherry", "japanCherry"),
	RUBY("Ruby", "ruby"),
	CLASSIC("Classic", "classic"),
	DEEP_MARINE("Deep Marine", "deepMarine");

	private String label;
	private String value;

	private Skin(String label, String value) {
		this.label = label;
		this.value = value;
	}

	public String getLabel() {
		// System.out.println("getLabel returns [" + label + "]");
		return this.label;
	}

	public String getValue() {
		// System.out.println("getValue returns [" + value + "]");
		return this.value;
	}
}
