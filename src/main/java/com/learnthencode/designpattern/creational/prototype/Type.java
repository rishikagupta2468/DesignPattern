package com.learnthencode.designpattern.creational.prototype;

public class Type {
  private String value;

  public Type(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return "Type {" +
        "value='" + value + '\'' +
        '}';
  }
}
