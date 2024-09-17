package com.learnthencode.designpattern.creational.singleton;

/**
 * Singleton class that uses eager initialization to create the instance when the class is loaded.
 *
 * What is singleton pattern?
 * It is a creational pattern that ensures that a class has only one instance and provides a global point of access to that instance.
 */
public class PrintSpoolerEagerInit {
  private static final PrintSpoolerEagerInit INSTANCE = new PrintSpoolerEagerInit();

  private PrintSpoolerEagerInit() {
    // Private constructor to prevent instantiation
  }

  public static PrintSpoolerEagerInit getInstance() {
    return INSTANCE;
  }
}
