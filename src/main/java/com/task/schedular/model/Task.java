package com.task.schedular.model;

import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
	
    private int id;
    //@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime scheduledDate;
    
    
}
