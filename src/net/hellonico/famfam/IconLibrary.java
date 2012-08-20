/**
 * ##library.name##
 * ##library.sentence##
 * ##library.url##
 *
 * Copyright ##copyright## ##author##
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General
 * Public License along with this library; if not, write to the
 * Free Software Foundation, Inc., 59 Temple Place, Suite 330,
 * Boston, MA  02111-1307  USA
 * 
 * @author      ##author##
 * @modified    ##date##
 * @version     ##library.prettyVersion## (##library.version##)
 */

package net.hellonico.famfam;


import java.net.URL;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * This is a template class and can be used to start a new processing library or tool.
 * Make sure you rename this class as well as the name of the example package 'template' 
 * to your own library or tool naming convention.
 * 
 * @example Hello 
 * 
 * (the tag @example followed by the name of an example included in folder 'examples' will
 * automatically include the example in the javadoc.)
 *
 */

public class IconLibrary {

	PApplet myParent;
	
	public final static String VERSION = "##library.prettyVersion##";

	public IconLibrary(PApplet theParent) {
		myParent = theParent;
	}
	
	public URL getFlag(String flagName) {
		return getR("flags", flagName);
	}
	public String getFlagS(String flagName) {
		return getFlag(flagName).toExternalForm();
	}
	public PImage getFlagI(String flagName) {
		return this.myParent.loadImage(getFlagS(flagName));
	}
	
	public URL getIcon(String iconName) {
		return getR("silk", iconName);
	}
	public String getIconS(String iconName) {
		return getIcon(iconName).toExternalForm();
	}
	public PImage getIconI(String iconName) {
		return this.myParent.loadImage(getIconS(iconName));
	}
	
	public URL getR(String group, String name) {
		return this.getClass().getResource("/"+group+"/"+name+".png");
	}
	
	public static String version() {
		return VERSION;
	}
}

