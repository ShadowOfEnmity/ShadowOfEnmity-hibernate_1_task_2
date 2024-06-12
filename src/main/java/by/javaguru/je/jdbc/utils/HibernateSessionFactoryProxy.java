package by.javaguru.je.jdbc.utils;

import lombok.extern.log4j.Log4j2;
import org.hibernate.SessionFactory;

@Log4j2
public class HibernateSessionFactoryProxy {
    private static final ThreadLocal<SessionFactory> sessionFactoryThreadLocal = new ThreadLocal<>();

    public static SessionFactory getSessionFactory() {
        SessionFactory sessionFactory = sessionFactoryThreadLocal.get();
        if (sessionFactory == null) {
            sessionFactory = buildSessionFactory();
            sessionFactoryThreadLocal.set(sessionFactory);
        }
        log.debug("Session factory has been created: {}", sessionFactoryThreadLocal::get);
        return sessionFactory;
    }

    private static SessionFactory buildSessionFactory() {
        try {
            return HibernateUtil.buildSessionFactory();
        } catch (Throwable ex) {
            log.error("Error has been occurred: {}", () -> ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static void closeSessionFactory() {
        SessionFactory sessionFactory = sessionFactoryThreadLocal.get();
        if (sessionFactory != null) {
            sessionFactory.close();
            sessionFactoryThreadLocal.remove();
            log.debug("Session factory has been closed: {}", () -> sessionFactory);
        }
    }
}
