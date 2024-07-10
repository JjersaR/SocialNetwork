package com.network.social.sn.controller.handleEx;

public class ObjectWithoutFound extends RuntimeException {

  public ObjectWithoutFound(String message) {
    super(message);
  }

  public ObjectWithoutFound(String message, Throwable cause) {
    super(message, cause);
  }
}
