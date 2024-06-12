package by.javaguru.je.jdbc.utils;

import by.javaguru.je.jdbc.entity.*;
import lombok.experimental.UtilityClass;
import org.hibernate.SessionFactory;
import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy;
import org.hibernate.cfg.Configuration;

@UtilityClass
public class HibernateUtil {
    public static SessionFactory buildSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(Flight.class);
        configuration.addAnnotatedClass(Seat.class);
        configuration.addAnnotatedClass(Airport.class);
        configuration.addAnnotatedClass(Aircraft.class);
        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Ticket.class);
        configuration.addAnnotatedClass(SeatId.class);


        configuration.setPhysicalNamingStrategy(new CamelCaseToUnderscoresNamingStrategy());
        configuration.configure();

        return configuration.buildSessionFactory();
    }
}
