package com.zist.model;

import java.util.ArrayList;

public class Description {

	private ArrayList<String> availableSizes = new ArrayList<String>();
	private ArrayList<String> accessories = new ArrayList<String>();
	private ArrayList<String> availableColor = new ArrayList<String>();
	private String buttonStyle;
	private String buttonSize;

	
	public Description(String[] sizeDescription,String buttonStyle,String buttonSize,String[] accessories,
			String[] color){

		// Adding sizes to the list
		
		for (int i = 0; i < sizeDescription.length; i++) {
			sizeDescription[i] = sizeDescription[i].toUpperCase();
			availableSizes.add(sizeDescription[i]);
			}
		
		// initializing button style
		
		this.buttonStyle = buttonStyle;
		
		// Initializing button size
		
		this.buttonSize = buttonSize;
		
		// Initializing accessories

		for (int i = 0; i < accessories.length; i++) {
			accessories[i] = accessories[i].toUpperCase();
			this.accessories.add(accessories[i]);
			}

		// Initialize Color
		
		for (int i = 0; i < color.length; i++) {
			color[i] = color[i].toUpperCase();
			availableColor.add(color[i]);
			}

	}


	public ArrayList<String> getAvailableSizes() {
		return availableSizes;
	}


	public void setAvailableSizes(ArrayList<String> availableSizes) {
		this.availableSizes = availableSizes;
	}


	public ArrayList<String> getAccessories() {
		return accessories;
	}


	public void setAccessories(ArrayList<String> accessories) {
		this.accessories = accessories;
	}


	public ArrayList<String> getAvailableColor() {
		return availableColor;
	}


	public void setAvailableColor(ArrayList<String> availableColor) {
		this.availableColor = availableColor;
	}


	public String getButtonStyle() {
		return buttonStyle;
	}


	public void setButtonStyle(String buttonStyle) {
		this.buttonStyle = buttonStyle;
	}


	public String getButtonSize() {
		return buttonSize;
	}


	public void setButtonSize(String buttonSize) {
		this.buttonSize = buttonSize;
	}
	
	@Override
	public String toString() {
		return "Description [size=" + availableSizes + ", ButtonStyle =" + buttonStyle + ", ButtonSize =" +
				buttonSize + ", Accessories =" + accessories + ", AvailableColors = "+ availableColor 
				+"]";
	}
	
}
