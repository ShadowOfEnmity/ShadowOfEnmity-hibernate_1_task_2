package by.javaguru.je.jdbc.service;

import by.javaguru.je.jdbc.dao.TicketDao;
import by.javaguru.je.jdbc.dto.TicketDto;
import by.javaguru.je.jdbc.utils.HibernateSessionFactoryProxy;
import by.javaguru.je.jdbc.utils.HibernateUtil;
import lombok.Cleanup;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TicketService {
    private static final TicketService INSTANCE = new TicketService();

    private final TicketDao ticketDao = TicketDao.getInstance();

    private TicketService() {
    }

    public static TicketService getInstance() {
        return INSTANCE;
    }

    public List<TicketDto> findAllByFlightId(Long flightId) {
//        @Cleanup var sessionFactory = HibernateUtil.buildSessionFactory();
        var sessionFactory = HibernateSessionFactoryProxy.getSessionFactory();
        @Cleanup Session session = sessionFactory.openSession();
        return ticketDao.findAllByFlightId(flightId, session).stream().map(ticket -> new TicketDto(ticket.getId(), ticket.getFlight().getId(), ticket.getSeatNo())
        ).collect(Collectors.toList());
    }
}
