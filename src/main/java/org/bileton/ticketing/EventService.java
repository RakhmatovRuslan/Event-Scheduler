package org.bileton.ticketing;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * Created by Ruslan on 12/26/2016.
 */
public class EventService {

    private static final Logger log = LoggerFactory.getLogger(EventService.class);
    private SqlSession session;

    public EventService() {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            session = sqlSessionFactory.openSession();
        } catch (IOException e) {
            log.error(e.getLocalizedMessage());
            e.printStackTrace();
        }
    }

    public void updateEventStatus(){
        List<EventScheduler> eventEventSchedulers = session.selectList("EventScheduler.getAll");
        for (EventScheduler eventScheduler: eventEventSchedulers) {
            System.out.println(eventScheduler);
        }
    }
}
