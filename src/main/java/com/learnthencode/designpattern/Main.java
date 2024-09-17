package com.learnthencode.designpattern;

import com.learnthencode.designpattern.creational.singleton.PrintSpoolerLazyInit;


public class Main {
  public static void main(String[] args) {
    PrintSpoolerLazyInit spooler = PrintSpoolerLazyInit.getInstance();
    System.out.println(spooler);

    PrintSpoolerLazyInit spooler2 = PrintSpoolerLazyInit.getInstance();
    System.out.println(spooler2);
    System.out.println(spooler == spooler2);
  }
}