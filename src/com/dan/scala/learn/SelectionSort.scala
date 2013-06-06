package com.dan.scala.learn

/**
 * User: dan
 * Date: 6/5/13
 * Time: 10:22 AM

 Pseudocode:

 for i = 0; i < array.length; i ++
  posOfMinimum = posOfMinimum(i+1, array)
  switch(array, i, posOfMinimum)

 min -> iterate over array and record the minimum and do check for each new element and if lower, then re-assign new minimum.

 */

object SelectionSort {

  def printArray(txt: String, ints: Array[Int]) = {
    println(txt)
    ints.foreach(a => print(a  + " "))
    println
  }

  def selectionSort(ints: Array[Int]): Array[Int] = {

//    printArray("selectionSort", ints)

    if (ints.length == 1) {
      return ints;
    }

    val min = ints.min
    val tail = ints.slice(1, ints.length)
    val indexOfMin = tail.indexOf(min) + 1

//    println("Found min " + min + " with position " + indexOfMin)

    //  Get the minimum at the beginning
    if (ints(0) > ints(indexOfMin)) {
      val t = ints(0)
      ints(0) = ints(indexOfMin)
      tail(indexOfMin - 1) = t
    }

//    printArray("after changing min with first", ints)

    return Array(ints(0)) ++ selectionSort(tail)
  }

  def main(args: Array[String]) {

    val input = Array( -100, 10, 1, 56, 2, 5, 4, 103, 9, 7, 8, 23, 3, 6 );

    val output = selectionSort(input);

    printArray("input", input)

    printArray("output", output)
  }
}