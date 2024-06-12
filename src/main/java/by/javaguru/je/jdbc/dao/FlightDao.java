package by.javaguru.je.jdbc.dao;

import by.javaguru.je.jdbc.entity.Flight;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class FlightDao implements Dao<Long, Flight, Session> {

    private final static FlightDao INSTANCE = new FlightDao();


    private FlightDao() {
    }

    public static FlightDao getInstance() {
        return INSTANCE;
    }

    private final static String FIND_ALL_SQL = "FROM Flight f";

    @Override
    public Flight update(Flight flight, Session session) {
        session.beginTransaction();
        session.persist(flight);
        session.beginTransaction().commit();
        return flight;
    }

    @Override
    public List<Flight> findAll(Session session) {
        List<Flight> flights = Collections.emptyList();
        session.beginTransaction();
        Query<Flight> query = session.createQuery(FIND_ALL_SQL, Flight.class);
        flights = query.getResultList();
        session.getTransaction().commit();
        return flights;
    }

    @Override
    public Optional<Flight> findById(Long id, Session session) {
        Flight flight = null;
        session.beginTransaction();
        flight = session.get(Flight.class, id);
        session.getTransaction().commit();
        return Optional.ofNullable(flight);
    }


    @Override
    public Flight save(Flight flight, Session session) {
        session.beginTransaction();
        session.persist(flight);
        session.getTransaction().commit();
        return flight;
    }

    @Override
    public void delete(Long id, Session session) {
        session.beginTransaction();
        Optional.of(session.get(Flight.class, id)).ifPresent(session::remove);
        session.getTransaction().commit();
    }
}
