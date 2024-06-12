package by.javaguru.je.jdbc.dao;

import by.javaguru.je.jdbc.entity.Ticket;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class TicketDao implements Dao<Long, Ticket, Session> {
    private static final TicketDao INSTANCE = new TicketDao();


    private static final String FIND_ALL_SQL = "FROM Ticket t";

    private static String FIND_BY_FLIGHT_ID = FIND_ALL_SQL + """
             INNER JOIN t.flight f  WHERE f = :flight
            """;

    public static TicketDao getInstance() {
        return INSTANCE;
    }

    private TicketDao() {
    }

    public List<Ticket> findAllByFlightId(Long id, Session session) {
        List<Ticket> tickets = Collections.emptyList();
        session.beginTransaction();
        Query<Ticket> query = session.createQuery("FROM Ticket t INNER JOIN t.flight f WHERE f.id= :flight", Ticket.class);
        query.setParameter("flight", id);
        tickets = query.getResultList();
        session.getTransaction().commit();
        return tickets;
    }

    @Override
    public Optional<Ticket> findById(Long id, Session session) {
        Ticket ticket;
        session.beginTransaction();
        ticket = session.get(Ticket.class, id);
        session.getTransaction().commit();
        return Optional.ofNullable(ticket);
    }


    @Override
    public Ticket update(Ticket ticket, Session session) {
        session.beginTransaction();
        ticket = session.merge(ticket);
        session.getTransaction().commit();
        return ticket;
    }

    @Override
    public List<Ticket> findAll(Session session) {

        List<Ticket> tickets = Collections.emptyList();
        session.beginTransaction();
        Query<Ticket> query = session.createQuery(FIND_ALL_SQL, Ticket.class);
        tickets = query.getResultList();
        session.getTransaction().commit();
        return tickets;

    }

    @Override
    public Ticket save(Ticket ticket, Session session) {

        session.beginTransaction();
        ticket = session.merge(ticket);
        session.getTransaction().commit();

        return ticket;
    }

    @Override
    public void delete(Long id, Session session) {
        session.beginTransaction();
        Optional.of(session.get(Ticket.class, id)).ifPresent(session::remove);
        session.getTransaction().commit();
    }


}
