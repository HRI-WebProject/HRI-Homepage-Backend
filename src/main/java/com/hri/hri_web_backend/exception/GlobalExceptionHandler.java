package com.hri.hri_web_backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.hri.hri_web_backend.global.FailResponse;
import com.hri.hri_web_backend.global.StatusEnum;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public FailResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
		return FailResponse.builder()
			.status(StatusEnum.BAD_REQUEST)
			.errorMessage(e.getMessage())
			.build();
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(IllegalArgumentException.class)
	public FailResponse handleIllegalArgumentException(IllegalArgumentException e){
		return FailResponse.builder()
			.status(StatusEnum.BAD_REQUEST)
			.errorMessage(e.getMessage())
			.build();
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(RuntimeException.class)
	public FailResponse handleRuntimeException(RuntimeException e){
		return FailResponse.builder()
			.status(StatusEnum.BAD_REQUEST)
			.errorMessage(e.getMessage())
			.build();
	}
}