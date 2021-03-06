/*******************************************************************************
 * Copyright (c) 2014 Transcends, LLC.
 * This program is free software; you can redistribute it and/or modify it under the terms of the GNU 
 * General Public License as published by the Free Software Foundation; either version 2 of the 
 * License, or (at your option) any later version. This program is distributed in the hope that it will 
 * be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY 
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details. You 
 * should have received a copy of the GNU General Public License along with this program; if not, 
 * write to the Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301, 
 * USA. 
 * http://www.gnu.org/licenses/gpl-2.0.html
 *******************************************************************************/
package org.rifidi.edge.adapter.awid.commands.awid2010;

import javax.management.MBeanInfo;

import org.rifidi.edge.configuration.AnnotationMBeanInfoStrategy;
import org.rifidi.edge.configuration.JMXMBean;
import org.rifidi.edge.configuration.Property;
import org.rifidi.edge.configuration.PropertyType;
import org.rifidi.edge.sensors.AbstractCommandConfiguration;

/**
 * @author Kyle Neumeier - kyle@pramari.com
 * @author Daniel Gomez - dgomez@idlinksolutions.com
 * 
 */
@JMXMBean
public class AwidReadBlockDataCommandConfiguration extends
		AbstractCommandConfiguration<AwidReadBlockDataCommand> {
	
	private byte memoryBank=0x01;
	public static final MBeanInfo mbeaninfo;
	static {
		AnnotationMBeanInfoStrategy strategy = new AnnotationMBeanInfoStrategy();
		mbeaninfo = strategy
				.getMBeanInfo(AwidReadBlockDataCommandConfiguration.class);
	}

	@Override
	public AwidReadBlockDataCommand getCommand(String readerID) {
		return new AwidReadBlockDataCommand(super.getID(),  memoryBank);
	}

	@Override
	public MBeanInfo getMBeanInfo() {
		return (MBeanInfo)mbeaninfo.clone();
	}

	/**
	 * @return the memoryBank
	 */
	@Property(category = "Memory Bank", defaultValue = "01", description = "0x01 EPC bank, 0x02 TID bank, 0x03 User bank", displayName = "Memory Bank", orderValue = 2, type = PropertyType.PT_INTEGER, writable = true, minValue="0", maxValue="3")
	public Integer getMemoryBank() {
		return new Integer(memoryBank);
	}

	/**
	 * @param memoryBank the memoryBank to set
	 */
	public void setMemoryBank(Integer memoryBank) {
		//TODO: bounds check
		this.memoryBank = memoryBank.byteValue();
	}
}
