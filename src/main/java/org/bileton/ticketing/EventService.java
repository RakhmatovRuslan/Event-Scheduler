package org.bileton.ticketing;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Reader;
import java.sql.Timestamp;
import java.util.Calendar;
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
        session.clearCache();
        List<EventScheduler> eventSchedulers = session.selectList("EventScheduler.getAll");
        if(eventSchedulers != null) {
            Timestamp currentTime = new Timestamp(Calendar.getInstance().getTime().getTime());
            for (EventScheduler eventScheduler : eventSchedulers) {
                if (eventScheduler.getActivation() && currentTime.getTime() > eventScheduler.getDate().getTime()) {
                    session.update("EventScheduler.updateEvent", eventScheduler);
                    session.delete("EventScheduler.delete", eventScheduler);
                    session.commit();
                } else if (!eventScheduler.getActivation() && currentTime.getTime() > eventScheduler.getDate().getTime()) {
                    session.update("EventScheduler.updateEvent", eventScheduler);
                    session.delete("EventScheduler.delete", eventScheduler);
                    session.commit();
                }
            }
        }
    }
}
