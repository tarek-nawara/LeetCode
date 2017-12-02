package codeforces

import scala.collection.mutable
import scala.io.StdIn._

object B758 {
  def main(args: Array[String]): Unit = {
    val grid = readLine().toCharArray
    val positions = findPositions(grid)
    val state = solve(grid)
    println(s"${state(positions('R'))} ${state(positions('B'))} ${state(positions('Y'))} ${state(positions('G'))}")
  }

  def findPositions(grid: Array[Char]): mutable.Map[Char, Int] = {
    val positions = new mutable.HashMap[Char, Int]()
    for (i <- 0 until grid.length; if grid(i) != '!') positions += (grid(i) -> i % 4)
    positions
  }

  def solve(grid: Array[Char]): Array[Int] = {
    val state = Array(0, 0, 0, 0)
    for (i <- 0 until grid.length; if grid(i) == '!') state(i % 4) += 1
    state
  }
}
