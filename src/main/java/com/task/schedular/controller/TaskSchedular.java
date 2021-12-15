package com.task.schedular.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.task.schedular.model.Task;
import com.task.schedular.service.TaskSchedularService;

@RestController
public class TaskSchedular {
	 
	@Autowired
	private TaskSchedularService ts;
	
	@GetMapping("/task")
	public List<Task> getTask() {
		return ts.getAllTask();
	}
	@GetMapping("/task/{id}")
	public Task getTaskById(@PathVariable("id") int id) {
		return ts.getTaskById(id);
	}
	
	@PostMapping("/task")
	public Task createTask(@RequestBody Task t) {
		return ts.createTask(t);
	}
	@PutMapping("/task/{id}")
	public Task updateTask(@RequestBody Task t, @PathVariable("id") int id) {
		return ts.updateTask(t, id);
	}
	@DeleteMapping("/task/{id}")
	public void deleteTask(@PathVariable("id") int id) {
	      ts.deleteBook(id);
	}
  
}
