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
package org.rifidi.edge.adapter.awid.awid2010.gpio;

import org.rifidi.edge.sensors.sessions.MessageParsingStrategy;

/**
 * This class is the parsing strategy for incoming GPI/O messages for the AWID
 * reader.
 * 
 * It reads the first byte (which is the length byte), then reads that number of
 * bytes.
 * 
 * @author Kyle Neumeier - kyle@pramari.com
 * 
 */
public class AwidGPIOMessageParsingStrategy implements MessageParsingStrategy {

	/** The message */
	private byte[] messageBytes;
	/** The number of bytes read so far */
	private byte byteCount = 0;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.rifidi.edge.sensors.sessions.MessageParsingStrategy#isMessage
	 * (byte)
	 */
	@Override
	public byte[] isMessage(byte message) {
		// increment the counter
		byteCount++;
		// if this is the first byte
		if (byteCount == 1) {
			// if the first byte is a 0x00 or a 0xFF, it's an ACK, so just
			// return the ACK
			if (message == 0x00 || message == (byte) 0xFF) {
				return new byte[] { message };
			}
			// create the array
			messageBytes = new byte[message];
		}
		// add the byte to the array
		messageBytes[byteCount - 1] = message;

		// if we have received the total number of bytes, return it.
		if (byteCount == messageBytes[0]) {
			return messageBytes;
		}

		// return null if we havent' received all the bytes yet
		return null;

	}

}
