package com.learnthencode.designpattern.creational.prototype;

import java.util.List;
import java.util.ArrayList;


public class Forest {
  List<Tree> xTrees = new ArrayList<>();

  List<Tree> yTrees = new ArrayList<>();

  List<Tree> zTrees = new ArrayList<>();

  public Forest() {
    Tree tree1 = new Tree(1, 2, new Type("X")); // x type
    Tree tree2 = new Tree(3, 4, new Type("Y")); // y type
    Tree tree3 = new Tree(5, 6, new Type("Z")); // z type

    Tree tree4 = tree1.clone();
    tree1.getType().setValue("A");

    xTrees.add(tree1);
    xTrees.add(tree4);
    yTrees.add(tree2);
    zTrees.add(tree3);
  }

  public List<Tree> getXTrees() {
    return xTrees;
  }

  public List<Tree> getYTrees() {
    return yTrees;
  }

  public List<Tree> getZTrees() {
    return zTrees;
  }
}
