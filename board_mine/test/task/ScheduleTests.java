package task;

import org.junit.jupiter.api.Test;
import org.quartz.JobExecutionException;

public class ScheduleTests {
	ScheduleInit scheduleInit = new ScheduleInit();
	TimeTask timeTask = new TimeTask();
	
	@Test
	public void testSchedule() {
		scheduleInit.schedule();
	}
	
	@Test
	public void testTimeTask() throws JobExecutionException {
		timeTask.execute(null);
	}
	
}
