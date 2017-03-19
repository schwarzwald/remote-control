package com.portfobio.application;

import com.portfobio.application.command.ApplicationCommand;
import com.portfobio.application.core.ApplicationModule;
import com.portfobio.application.domain.QueuedCommandContainer;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class QueuedCommandProviderTest extends TestCase {
	private QueuedCommandContainer provider;

	public static Test suite() {
		return new TestSuite(QueuedCommandProviderTest.class);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		provider = new QueuedCommandContainer();
	}

	public void testAddSingleToQueue() {
		ApplicationCommand<?> c1 = new TestingApplicationCommand<ApplicationModule>();
		provider.addCommand(c1);

		assertTrue(provider.getSize() == 1);
	}

	public void testRemoveSingleFromQueue() {
		ApplicationCommand<?> c1 = new TestingApplicationCommand<ApplicationModule>();
		provider.addCommand(c1);
		provider.getCommand();

		assertTrue(provider.getSize() == 0);
	}

	public void testQueueOrdering() {
		ApplicationCommand<?> c1 = new TestingApplicationCommand<ApplicationModule>();
		ApplicationCommand<?> c2 = new TestingApplicationCommand<ApplicationModule>();

		provider.addCommand(c1);
		provider.addCommand(c2);

		assertTrue(c1 == provider.getCommand());
		assertTrue(c2 == provider.getCommand());
	}

	public void testEmptyRemoval() {
		ApplicationCommand<?> c1 = provider.getCommand();

		assertTrue(c1 == null);
	}

	private class TestingApplicationCommand<T extends ApplicationModule>
			implements
				ApplicationCommand<T> {

		public Class<T> getExecutionModuleClass() {
			return null;
		}

		public void execute(T executionModule) {

		}

	}
}
