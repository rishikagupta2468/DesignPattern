package com.learnthencode.designpattern;

import com.learnthencode.designpattern.creational.prototype.Forest;


public class Main {
  public static void main(String[] args) {
    Forest forest = new Forest();
    forest.getXTrees().forEach(tree -> System.out.println(tree.toString()));
    forest.getYTrees().forEach(tree -> System.out.println(tree.toString()));
    forest.getZTrees().forEach(tree -> System.out.println(tree.toString()));
  }
}