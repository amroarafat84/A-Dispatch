package com.amro.controller;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;






public class HandleContextListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void contextInitialized(ServletContextEvent arg0) {
		//DBConnection.getInstance().getConnection();

	}

}
