package com.learnthencode.designpattern.creational.singleton;

/**
 * Singleton class that uses lazy initialization to create the instance when it is first requested.
 *
 * What is singleton pattern?
 * It is a creational pattern that ensures that a class has only one instance and provides a global point of access to that instance.
 */
public class PrintSpoolerLazyInit {
  private static PrintSpoolerLazyInit INSTANCE;

  private PrintSpoolerLazyInit() {
    // Private constructor to prevent instantiation
  }

  public static synchronized PrintSpoolerLazyInit getInstance() {
    if (INSTANCE == null) {
      INSTANCE = new PrintSpoolerLazyInit();
    }
    return INSTANCE;
  }
}
