package com.learnthencode.designpattern;

import com.learnthencode.designpattern.creational.Animal;


public class Main {
  public static void main(String[] args) {
    Animal animal = new Animal.Builder("Dog").setType("Mammal").build();
    System.out.println("Name: " + animal.getName() +  " and Type: " + animal.getType());
  }
}