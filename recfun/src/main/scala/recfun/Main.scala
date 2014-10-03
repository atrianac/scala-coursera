package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {

    def calculatePascal(nr: Int, b: Array[Int]): Int = {

      if (r == 0 || r == 1)
        1
      else if (r == nr)
        b(c)
      else
        calculatePascal(nr + 1, calculateRow(b))
    }

    def calculateRow(b: Array[Int]): Array[Int] = {
      val bn = new Array[Int](b.length + 1)

      bn(0) = 1
      bn(bn.length - 1) = 1

      for (i <- 0 to b.length - 2) {
        bn(i + 1) = b(i) + b(i + 1)
      }

      bn
    }

    calculatePascal(1, Array[Int](1, 1))
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {

    def calculateBalance(charsFor: List[Char], count: Int): Boolean = {
      if (charsFor.isEmpty)
        count == 0
      else if (charsFor.head == '(') {
        calculateBalance(charsFor.tail, count + 1)
      } else if (charsFor.head == ')')
        if (count > 0)
          calculateBalance(charsFor.tail, count - 1)
        else
          false
      else
        calculateBalance(charsFor.tail, count)
    }

    calculateBalance(chars, 0);
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {

    if (money == 0) 
      1
    else if (money < 0) 
      0
    else if (coins.isEmpty) 
      0
    else {
      countChange(money - coins.head, coins) +
        countChange(money, coins.tail)
    }

  }
}
