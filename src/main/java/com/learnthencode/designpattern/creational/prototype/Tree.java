package com.learnthencode.designpattern.creational.prototype;

public class Tree {

  private int age;
  private int height;

  private Type type;

  public Tree(int age, int height, Type type) {
    this.age = age;
    this.height = height;
    this.type = type;
  }

  public Tree clone() {
    return new Tree(this.age, this.height, new Type(this.type.getValue()));
  }

  @Override
  public String toString() {
    return "Tree {" +
        "age = " + age +
        ", height = " + height +
        ", type = " + type.toString() +
        '}';
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public Type getType() {
    return type;
  }

  public void setType(Type type) {
    this.type = type;
  }
}
