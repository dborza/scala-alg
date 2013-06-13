package com.dan.scala.learn

/**
 * User: dan
 * Date: 6/10/13
 * Time: 10:22 AM
 */

object Conway {

  def has(x: Int, y: Int, s: Set[(Int, Int)]): Int = {
    if (s.contains((x, y))) {
      //      print("Found " + x + "," + y)
      return 1;
    } else {
      return 0;
    }
  }

  def neighbour(x: Int, y: Int, s: Set[(Int, Int)]): Int = {
    return has(x - 1, y - 1, s) + has(x, y - 1, s) + has(x + 1, y - 1, s) + has(x - 1, y, s) + has(x + 1, y, s) +
      has(x - 1, y + 1, s) + has(x, y + 1, s) + has(x + 1, y + 1, s);
  }

  def getNeighbours(x: Int, y: Int, t: Int, s: Set[(Int, Int)]): Int = {

    if (t == 0) {
      return neighbour(x, y, s);
    }

    return f(x - 1, y - 1, t - 1, s) + f(x, y - 1, t - 1, s) + f(x + 1, y - 1, t - 1, s) +
      f(x - 1, y, t - 1, s) + f(x + 1, y, t - 1, s)
    f(x - 1, y + 1, t - 1, s) + f(x, y + 1, t - 1, s) + f(x + 1, y + 1, t - 1, s);
  }

  def f(x: Int, y: Int, t: Int, s: Set[(Int, Int)]): Int = {

    if (t == 0) {
      return has(x, y, s)
    }

    val neighbours = getNeighbours(x, y, t - 1, s)

    //    println("Neighbours for " + x +","  + y + "," + neighbours);

    val previous = f(x, y, t - 1, s)

    if (previous == 1) {
      if (neighbours < 2) {
        return 0;
      } else if (neighbours <= 3) {
        return 1;
      } else {
        return 0;
      }
    } else {
      if (neighbours == 3) {
        return 1;
      } else {
        return 0;
      }
    }
    return 1;

  }

  def main(args: Array[String]) {

    val s = Set((1, 1), (2, 3), (2, 0), (2, 1), (2, 2), (3, 4))

    println(">>>" + f(1, 1, 19, s))
    println(">>>" + f(2, 0, 1, s))
    println(">>>" + f(2, 1, 1, s))
    println(">>>" + f(2, 2, 1, s))
    println(">>>" + f(2, 3, 1, s))
    println(">>>" + f(3, 4, 1, s))

  }

}