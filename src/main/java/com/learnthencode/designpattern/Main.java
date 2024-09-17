package com.learnthencode.designpattern;

import com.learnthencode.designpattern.creational.builder.Animal;


public class Main {
  public static void main(String[] args) {
    // Create an Animal object using the Builder pattern
    Animal animal = new Animal.Builder("Dog").setType("Mammal").build();
    System.out.println("Name: " + animal.getName() +  " and Type: " + animal.getType());
  }
}