package com.network.social.sn.controller.handleEx;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class SocialNetworkExceptionHandler {

  @ExceptionHandler(ObjectWithoutContent.class)
  public ResponseEntity<SocialNetworkException> handleObjectWithoutContent(ObjectWithoutContent ex) {
    var exception = new SocialNetworkException(ex.getMessage(), ex.getCause(), HttpStatus.NO_CONTENT);
    return new ResponseEntity<>(exception, HttpStatus.NO_CONTENT);
  }

  @ExceptionHandler(ObjectWithoutFound.class)
  public ResponseEntity<SocialNetworkException> handleObjectWithoutFound(ObjectWithoutFound ex) {
    var exception = new SocialNetworkException(ex.getMessage(), ex.getCause(), HttpStatus.NOT_FOUND);
    return new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
  }
}
