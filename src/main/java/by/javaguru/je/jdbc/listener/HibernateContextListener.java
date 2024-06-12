package by.javaguru.je.jdbc.listener;

import by.javaguru.je.jdbc.utils.HibernateSessionFactoryProxy;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;

@Log4j2
@WebListener
public class HibernateContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        HibernateSessionFactoryProxy.getSessionFactory();
        log.info("Session factory has been initialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        HibernateSessionFactoryProxy.closeSessionFactory();
        log.info("Session factory has been closed");
    }
}
