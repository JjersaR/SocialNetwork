package com.network.social.sn.controller.handleEx;

import org.springframework.http.HttpStatus;

public class SocialNetworkException {

  private final String message;
  private final Throwable cause;
  private final HttpStatus status;

  public SocialNetworkException(String message, Throwable cause, HttpStatus status) {
    this.message = message;
    this.cause = cause;
    this.status = status;
  }

  public String getMessage() {
    return message;
  }

  public Throwable getCause() {
    return cause;
  }

  public HttpStatus getStatus() {
    return status;
  }

}
