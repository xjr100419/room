package com.xian.room.job.quartz.examples.examples01;

import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * hello world Quartz
 * @author weeks
 *
 */
public class HelloJob implements Job {

    private static Logger _log = LoggerFactory.getLogger(HelloJob .class );

    /**
     * Job，Job需要一个公有的构造函数，否则Factory无法构建
     */
    public HelloJob() {
    }

    /**
     * 实现execute方法
     */
    public void execute(JobExecutionContext context)
        throws JobExecutionException {
        _log.info( "Hello World! - " + new Date());
    }

}