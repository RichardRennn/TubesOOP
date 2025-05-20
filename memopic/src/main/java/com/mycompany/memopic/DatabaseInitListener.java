package com.mycompany.memopic;

import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener to initialize and clean up the database
 */
@WebListener
public class DatabaseInitListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Initializing Memopic database...");
        DatabaseManager.initDatabase();
        System.out.println("Database initialization complete!");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Shutting down database cleanup threads...");
        AbandonedConnectionCleanupThread.checkedShutdown();
        System.out.println("Database cleanup complete.");
    }
}
