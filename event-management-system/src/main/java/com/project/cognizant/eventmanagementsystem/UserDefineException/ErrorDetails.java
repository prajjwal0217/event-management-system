package com.project.cognizant.eventmanagementsystem.UserDefineException;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ErrorDetails {
	
	private LocalDateTime timestamp;
	private String message;
	private String details;

}
