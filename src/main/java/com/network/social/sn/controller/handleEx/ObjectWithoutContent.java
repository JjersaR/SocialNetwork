package com.network.social.sn.controller.handleEx;

public class ObjectWithoutContent extends RuntimeException {

  public ObjectWithoutContent(String message) {
    super(message);
  }

  public ObjectWithoutContent(String message, Throwable cause) {
    super(message, cause);
  }
}
