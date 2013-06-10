package com.dan.scala.learn

/**
 * User: dan
 * Date: 6/10/13
 * Time: 10:22 AM
 */

object QuickSort {

  def printArray(txt: String, ints: Array[Int]) = {
    println(txt)
    ints.foreach(a => print(a  + " "))
    println
  }

  def quickSort(ints: Array[Int]): Array[Int] = {

    if (ints.length <= 1) {
      return ints
    }

    if (ints.length == 2) {
      if (ints(0) > ints(1)) {
        val t = ints(0)
        ints(0) = ints(1)
        ints(1) = t
      }

      return ints
    }

    val m = ints(0)

    val restOfArray = ints.slice(1, ints.length)

    val smallerOrEqualThanM = restOfArray.filter(e => e <= m)
    val greaterThanM = restOfArray.filter(e => e > m)

    return quickSort(smallerOrEqualThanM) ++ Array(m) ++ quickSort(greaterThanM)
  }

  def main(args: Array[String]) {

    val input = Array( -100, 10, 1, 56, 2, 5, 4, 103, 9, 7, 8, 23, 3, 6 );

    val output = quickSort(input);

    printArray("input", input)

    printArray("output", output)
  }
}