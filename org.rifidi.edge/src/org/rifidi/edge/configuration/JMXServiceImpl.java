/*
 * Copyright (c) 2013 Transcends, LLC.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 */
package org.rifidi.edge.configuration;

import java.lang.management.ManagementFactory;
import java.util.HashMap;
import java.util.Map;

import javax.management.InstanceAlreadyExistsException;
import javax.management.InstanceNotFoundException;
import javax.management.MBeanInfo;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Allows services to be exposed via JMX
 * 
 * @author Jochen Mader - jochen@pramari.com
 */
public class JMXServiceImpl implements JMXService {
	/** Logger for this instance. */
	static final Log logger = LogFactory.getLog(JMXServiceImpl.class);
	/** The JMX server used by thi service instance. */
	MBeanServer mbs;
	/** Set containing the currently registered services. */
	private Map<Configuration, ObjectName> persistentServicesToObjectNames;

	/**
	 * Constructor.
	 */
	public JMXServiceImpl() {
		// register the MBeans server
		mbs = ManagementFactory.getPlatformMBeanServer();
		persistentServicesToObjectNames = new HashMap<Configuration, ObjectName>();
		logger.debug("JMXServiceImpl created.");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.rifidi.edge.configuration.services.JMXService#publish(org.rifidi.edge.configuration
	 * .Configuration)
	 */
	@Override
	public void publish(Configuration config) {
		synchronized (persistentServicesToObjectNames) {
			if (!persistentServicesToObjectNames.containsKey(config)) {
				logger.debug("Binding " + config + " to JMX.");
				// watch out, because of spring we are getting proxies, not the
				// actual services
				try {
					MBeanInfo info = config.getMBeanInfo();
					if (info != null) {
						ObjectName obname = new ObjectName("rifidi:type="
								+ config.getServiceID());
						mbs.registerMBean(config, obname);
						persistentServicesToObjectNames.put(config, obname);
					}
				} catch (InstanceAlreadyExistsException e) {
					logger.error("Tried to register object twice: "
							+ config.toString() + " " + e);
				} catch (MBeanRegistrationException e) {
					logger.error(e);
				} catch (NotCompliantMBeanException e) {
					logger.error(e);
				} catch (MalformedObjectNameException e) {
					logger.error(e);
				} catch (IllegalArgumentException e) {
					logger.error(e);
				}
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.rifidi.configuration.services.JMXService#unpublish(org.rifidi.
	 * configuration.Configuration)
	 */
	@Override
	public void unpublish(Configuration config) {
		synchronized (persistentServicesToObjectNames) {
			if (persistentServicesToObjectNames.containsKey(config)) {
				// unregister from jmx
				logger.debug("Unbinding " + config + " from JMX.");
				try {
					mbs.unregisterMBean(persistentServicesToObjectNames
							.get(config));
					persistentServicesToObjectNames.remove(config);
				} catch (InstanceNotFoundException e) {
					logger.error(e);
				} catch (MBeanRegistrationException e) {
					logger.error(e);
				}
			}
		}
	}

	/**
	 * Set the reference to the configuration control mbean.
	 * 
	 * @param mbean
	 */
	public void setConfigurationControlMBean(ConfigurationControlMBean mbean) {
		ObjectName obname;
		try {
			obname = new ObjectName("rifidi:type=ConfigurationControl");
			mbs.registerMBean(mbean, obname);
			logger.debug("ConfigurationControl registered to JMX.");
		} catch (MalformedObjectNameException e) {
			logger.error("Problem binding ConfigurationControl: " + e);
		} catch (NullPointerException e) {
			logger.error("Problem binding ConfigurationControl: " + e);
		} catch (InstanceAlreadyExistsException e) {
			logger.error("Problem binding ConfigurationControl: " + e);
		} catch (MBeanRegistrationException e) {
			logger.error("Problem binding ConfigurationControl: " + e);
		} catch (NotCompliantMBeanException e) {
			logger.error("Problem binding ConfigurationControl: " + e);
		}
	}
}
