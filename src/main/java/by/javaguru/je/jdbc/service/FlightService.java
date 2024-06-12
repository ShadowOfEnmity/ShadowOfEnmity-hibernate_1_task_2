package by.javaguru.je.jdbc.service;

import by.javaguru.je.jdbc.dao.FlightDao;
import by.javaguru.je.jdbc.dto.FlightDto;
import by.javaguru.je.jdbc.utils.HibernateSessionFactoryProxy;
import by.javaguru.je.jdbc.utils.HibernateUtil;
import lombok.Cleanup;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.stream.Collectors;

public class FlightService {
    private static final FlightService INSTANCE = new FlightService();

    private final FlightDao flightDao = FlightDao.getInstance();

    private FlightService() {
    }

    public static FlightService getInstance() {
        return INSTANCE;
    }

    public List<FlightDto> findAll() {
//        @Cleanup SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
        var sessionFactory = HibernateSessionFactoryProxy.getSessionFactory();
        @Cleanup Session session = sessionFactory.openSession();
        return flightDao.findAll(session).stream().map(flight ->
                new FlightDto(flight.getId(), "%s - %s - %s".formatted(
                        flight.getArrivalAirportCode(),
                        flight.getDepartureAirportCode(),
                        flight.getStatus()
                ))).collect(Collectors.toList());
    }
}
