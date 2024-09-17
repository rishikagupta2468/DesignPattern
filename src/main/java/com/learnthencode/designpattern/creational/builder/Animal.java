package com.learnthencode.designpattern.creational.builder;

/**
 * Animal class with a nested static Builder class.
 *
 * What is the builder pattern?
 * It is a creational pattern that separates the construction of a complex object from its representation.
 * This separation allows the same construction process to create different representations.
 */
public class Animal {
  private String name;
  private String type;

  // Constructor is private to prevent direct instantiation
  private Animal(Builder builder) {
    this.name = builder.name;
    this.type = builder.type;
  }

  public String getName() {
    return name;
  }

  public String getType() {
    return type;
  }

  // Nested static Builder class to create Animal instances
  public static class Builder {
    private String name;
    private String type;

    // Required class members are passed in the constructor of the Builder class
    public Builder(String name) {
      this.name = name;
    }

    public Builder setType(String type) {
      this.type = type;
      return this;
    }

    public Animal build() {
      return new Animal(this);
    }
  }
}
