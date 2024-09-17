package com.learnthencode.designpattern;

public class Main {
  public static void main(String[] args) {
    Animal animal = new Animal.Builder("Dog").setType("Mammal").build();
    System.out.println("Name: " + animal.getName() +  " and Type: " + animal.getType());
  }
}