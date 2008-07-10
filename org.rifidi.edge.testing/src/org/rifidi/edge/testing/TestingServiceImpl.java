package org.rifidi.edge.testing;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.runner.JUnitCore;
import org.junit.runner.notification.RunListener;
import org.rifidi.edge.common.utilities.thread.AbstractThread;
import org.rifidi.edge.testing.service.TestingService;
import java.util.concurrent.LinkedBlockingQueue;



/**
 * @author Jerry Maine - jerry@pramari.com
 *
 */
public class TestingServiceImpl extends AbstractThread implements TestingService {
	private static final Log logger = LogFactory.getLog(TestingService.class);
	LinkedBlockingQueue<Class<?>> klasses = new LinkedBlockingQueue<Class<?>>();
		
	public TestingServiceImpl(String threadName) {
		super(threadName);		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		JUnitCore junit = new JUnitCore();
		RunListener listener = new JunitListener();
		junit.addListener(listener);
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e1) {
//
//		}
		try {
			while(running){
				Class<?> klass = klasses.take();
				logger.debug("Attempting to run Junit " + klass.getName());
				junit.run(klass);
			}
		} catch (InterruptedException e) {
			//ignore this exception
		}	
		junit.removeListener(listener);
		
	}

	@Override
	public void addJunitTests(Class<?>... classes) {
		for (Class<?> klass : classes)
			klasses.add(klass);
	}

}
