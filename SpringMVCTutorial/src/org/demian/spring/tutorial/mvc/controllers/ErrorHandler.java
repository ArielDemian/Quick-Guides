package org.demian.spring.tutorial.mvc.controllers;

import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {
	@ExceptionHandler(DataAccessException.class)
	public String handleDatabaseExceptions(DataAccessException exception) {
		return "error";
	}
}