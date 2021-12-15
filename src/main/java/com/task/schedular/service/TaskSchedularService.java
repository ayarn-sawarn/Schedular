package com.task.schedular.service;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.quartz.CronScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.task.schedular.model.Task;

import lombok.var;

@Component
public class TaskSchedularService {

	private static List<Task> list = new ArrayList<>();
	//private static final String DATE_FORMATTER= "yyyy-MM-dd HH:mm:ss";
	static {
		//getting current date tim   
		LocalDateTime lt = LocalDateTime.now();
		list.add(new Task(11,lt));
			 
	}
	int a=0;
	//@Scheduled(cron = "* * * ? * * ")
	@Scheduled(cron = "10 13 10 15 12 ? ")
	public void taskSchedular() {
		System.out.println("current date is"+ LocalDateTime.now());
					
			
		/*String expresion = "5 * * * * ?";
		Trigger trigger = TriggerBuilder
				.newTrigger()
				.withIdentity(name, myGroup)
				.withSchedule(
				CronScheduleBuilder.cronSchedule(expresion))
				.build();
			*/
		
		
		
		

	}

	// createing list of LocaDateTime

	public List<Task> getAllTask() {
		return list;
	}

	// getting single book by id
	public Task getTaskById(int id) {
		Task t = null;
		t = list.stream().filter(e -> e.getId() == id).findFirst().get();
		return t;
	}

	public Task createTask(Task t) {
		if (t != null) {
			list.add(t);
		}
		return t;
	}

	// update
	public Task updateTask(Task t, int id) {
		list.parallelStream().forEach(n -> {
			if (n.getId() == id) {
				n.setScheduledDate(t.getScheduledDate());
				System.out.println(n.getScheduledDate());
			}
		});

		return t;
	}

	// delete the list
	public void deleteBook(int id) {
		list = list.stream().filter(task -> {
			if (task.getId() != id) {
				return true;
			} else {
				return false;
			}
		}).collect(Collectors.toList());
	}

}
