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
package org.rifidi.edge.adapter.alien;

public interface AlienCommandConstants {
	
	/**
	 * You can put this in front of a Alien command for terse output to come
	 * back to you, making things faster and easier to parse.
	 */
	public static final String PROMPT_SUPPRESS = "\1";

	/** Set antenna sequence */
	public static final String ANTENNA_SEQUENCE_COMMAND = "AntennaSequence";

	/**
	 * COMMANDS
	 */
	public static final String COMMAND_HEARTBEAT_ADDRESS = "heartbeataddress";
	public static final String COMMAND_ANTENNA_SEQUENCE = "antennasequence";
	public static final String COMMAND_MAX_ANTENNA = "maxantenna";
	public static final String COMMAND_PASSWORD = "password";
	public static final String COMMAND_READERNAME = "ReaderName";
	public static final String COMMAND_READERNUMBER = "ReaderNumber";
	public static final String COMMAND_READER_TYPE = "ReaderType";
	public static final String COMMAND_READER_VERSION = "ReaderVersion";
	public static final String COMMAND_RF_ATTENUATION = "RFAttenuation";
	public static final String COMMAND_EXTERNAL_INPUT = "ExternalInput";
	public static final String COMMAND_USERNAME = "username";
	public static final String COMMAND_UPTIME = "Uptime";
	public static final String COMMAND_TAG_LIST = "taglist";
	public static final String COMMAND_TAG_TYPE = "tagtype";
	public static final String COMMAND_TAG_LIST_FORMAT = "TagListFormat";
	public static final String COMMAND_TAG_LIST_CUSTOM_FORMAT = "TagListCustomFormat";
	public static final String COMMAND_EXTERNAL_OUTPUT = "ExternalOutput";
	public static final String COMMAND_INVERT_EXTERNAL_INPUT = "InvertExternalInput";
	public static final String COMMAND_INVERT_EXTERNAL_OUTPUT = "InvertExternalOutput";
	public static final String COOMMAND_COMMAND_PORT = "CommandPort";
	public static final String COMMAND_DHCP = "DHCP";
	public static final String COMMAND_PERSIST_TIME = "PersistTime";
	public static final String COMMAND_DNS = "DNS";
	public static final String COMMAND_GATEWAY = "Gateway";
	public static final String COMMAND_HEARTBEAT_COUNT = "HeartbeatCount";
	public static final String COMMAND_HEARTBEAT_PORT = "HeartbeatPort";
	public static final String COMMAND_HEARTBEAT_TIME = "HeartbeatTime";
	public static final String COMMAND_IPADDRESS = "IPAddress";
	public static final String COMMAND_MAC_ADDRESS = "MACAddress";
	public static final String COMMAND_NETMASK = "Netmask";
	public static final String COMMAND_NETWORK_TIMEOUT = "NetworkTimeout";
	public static final String COMMAND_TIME = "Time";
	public static final String COMMAND_TIME_SERVER = "TimeServer";
	public static final String COMMAND_TIME_ZONE = "TimeZone";

}
