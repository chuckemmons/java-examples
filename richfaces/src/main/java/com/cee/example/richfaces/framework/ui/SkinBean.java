package com.cee.example.richfaces.framework.ui;

import java.io.Serializable;

import javax.faces.component.UIOutput;
import javax.faces.event.ValueChangeEvent;

/**
 * 
 * @author chuck
 *
 */
public class SkinBean implements Serializable {
	private static final long serialVersionUID = 2211895646630386780L;

	private String selectedSkin = "japanCherry";

	public void selectSkinListener(ValueChangeEvent event) {
		setSelectedSkin(((UIOutput) event.getComponent()).getValue().toString());
		// AjaxBehaviorEventsetSelectedSkin(((UIOutput)
		// event.getSource()).getValue().toString());
	}

	public String getSelectedSkin() {
		System.out.println("getSelectedSkin returns [" + selectedSkin + "]");
		return selectedSkin;
	}

	public void setSelectedSkin(String selectedSkin) {
		System.out.println("setSelectedSkin to [" + selectedSkin + "]");
		this.selectedSkin = selectedSkin;
	}

	public Skin[] getSkinOptions() {
		return Skin.values();
	}

}
