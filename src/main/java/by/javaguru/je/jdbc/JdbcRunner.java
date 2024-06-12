package by.javaguru.je.jdbc;

import by.javaguru.je.jdbc.entity.Aircraft;
import by.javaguru.je.jdbc.utils.HibernateUtil;
import lombok.extern.log4j.Log4j2;
import org.hibernate.SessionFactory;

import java.sql.SQLException;

@Log4j2
public class JdbcRunner {

    public static void main(String[] args) throws SQLException {

//        log.error("This is an error message {}", () ->  new Throwable("Hello"));
//        log.warn("This is a warning message");
//        log.info("This is an informational message \'{}\'", "hz");
//        log.debug("This is a debug message");
//        log.trace("This is a trace message");

//        String sql = """
//                CREATE TABLE info(
//                id serial PRIMARY KEY,
//                data varchar(256)
//                );""";
//        String sql2 = """
//                INSERT INTO info (data)
//                VALUES ('Text 1'),
//                ('Text 2'),
//                ('Text 3'),
//                ('Text 4');
//                """;
//        String sql_delete = """
//                DELETE FROM info;
//                """;
//        String sql_ticket = """
//                SELECT * FROM ticket;
//                 """;
//
//
//        try (Connection connection = ConnectionManager.open();
//             var statement = connection.createStatement()) {
////            System.out.println(statement.execute(sql));
////            System.out.println(statement.executeUpdate(sql_delete));
//            var result = statement.executeQuery(sql_ticket);
//            while (result.next()) {
//                System.out.println(result.getLong("id"));
//                System.out.println(result.getString("passenger_name"));
//                System.out.println(result.getLong("flight_id"));
//                System.out.println(result.getBigDecimal("cost"));
//            }
//        }
//
//        ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//        System.out.println(getTicketsByFlightId(8L));
//        System.out.println(getFlightBetween(LocalDate.of(2020, 4, 01).atStartOfDay(),
//                LocalDate.of(2020, 8, 01).atStartOfDay()));
//        ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//        checkMetaData();

//        saveTicket();
//        deleteTicket();
//        findAll();

        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
             var session = sessionFactory.openSession()) {
            session.beginTransaction();
//            Ticket ticket = session.get(Ticket.class, 1L);
//            Seat seat = ticket.getSeat();
//            Aircraft aircraft = session.get(Aircraft.class, 1L);
//            SeatId t1 = new SeatId("T2", aircraft.getId());
//
//            Seat build = Seat.builder().id(t1).build();
//
//            ticket.setSeat(build);
//            session.flush();

            Aircraft.builder().model("Боинг 777-300").build();
            session.getTransaction().commit();
        }


//        findById();


//        updateTicket();
//        findAllByFilters();

    }

}
