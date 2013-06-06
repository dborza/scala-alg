package com.dan.scala.learn

/**
 * User: dan
 * Date: 6/5/13
 * Time: 10:22 AM
 */
object BubbleSort {

  def printArray(txt: String, ints: Array[Int]) = {
    println(txt)
    ints.foreach(a => print(a  + " "))
    println
  }

  def bubbleSort(ints: Array[Int]): Array[Int] = {

    /**
     * Do one iteration of the bubble sort algorithm
     * </p>
     * Start with the first element and swap it with the next if the first is greater.
     */
    def bubbleSortOneRun(shouldRerun: Boolean, ints: Array[Int]): (Boolean, Array[Int]) = {

      printArray("bubbleSortOneRun", ints)

      if (ints.length <= 1) {

        return (shouldRerun, ints)

      } else {

        val head = ints(0)
        val second = ints(1)
        var shouldRerunForTail = shouldRerun;

        if (head > second) {
          //  Swap the first two elements
          ints(0) = ints(1)
          ints(1) = head

          printArray("ints after swap", ints)

          //  Apply the algorithm for the tail of the array
          shouldRerunForTail = true;
        }

        var tail = ints.slice(1, ints.length)

        val resultTupleForTail = bubbleSortOneRun(shouldRerunForTail, tail)

        val partialResult = Array(ints(0)) ++ resultTupleForTail._2

        printArray("partialResult", partialResult)

        return (resultTupleForTail._1, partialResult)

      }
    }

    val (shouldRerun, partiallySortedArray) = bubbleSortOneRun(false, ints)

    if (shouldRerun) {
      return bubbleSort(partiallySortedArray)
    } else {
      return ints
    }

  }

  def main(args: Array[String]) {

    val input = Array( -100, 10, 1, 56, 2, 5, 4, 103, 9, 7, 8, 23, 3, 6 );

    val output = bubbleSort(input);

    printArray("input", input)  sadsa

    printArray("output", output)
  }
}
