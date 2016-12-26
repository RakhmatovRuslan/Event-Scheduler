package org.bileton.ticketing;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Ruslan on 12/25/2016.
 */
public class EventStatusJob implements Job {

    private static final Logger log = LoggerFactory.getLogger(EventStatusJob.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    private static final EventService eventService = new EventService();

    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        eventService.updateEventStatus();
        log.info("The time is now {}", dateFormat.format(new Date()));
    }
}
