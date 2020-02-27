package com.ho.practice.java.file;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class FileWatchService {

	private ScheduledFuture<?> scheduledFuture = null;
	
	public void startWatch(String filePath, long pollPeriod) {
		ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
		scheduledFuture = service.scheduleWithFixedDelay(
				new FileWatchRunner(filePath), 
				0, 
				pollPeriod, 
				TimeUnit.SECONDS);
    }
	
	public void stopWatch() {
		scheduledFuture.cancel(false);
	}
	
}
