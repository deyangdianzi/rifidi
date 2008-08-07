/* 
 * DataComposite.java
 *  Created:	Aug 6, 2008
 *  Project:	RiFidi Emulator - A Software Simulation Tool for RFID Devices
 *  				http://www.rifidi.org
 *  				http://rifidi.sourceforge.net
 *  Copyright:	Pramari LLC and the Rifidi Project
 *  License:	Lesser GNU Public License (LGPL)
 *  				http://www.opensource.org/licenses/lgpl-license.html
 */
package org.rifidi.site.ui.content;

import org.eclipse.swt.widgets.Composite;

/**
 * 
 * 
 * @author Matthew Dean - matt@pramari.com
 */
public abstract class DataComposite extends Composite {

	/**
	 * 
	 */
	private CompositeFormData data;
	
	/**
	 * 
	 * 
	 * @param parent
	 * @param style
	 */
	public DataComposite(Composite parent, int style, CompositeFormData data) {
		super(parent, style);
		data = new CompositeFormData();
	}

	/**
	 * @return the data
	 */
	public CompositeFormData getData() {
		return data;
	}
	
	/**
	 *  
	 */
	public abstract void endComposite();
}
