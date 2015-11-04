package de.codecentric.palindrome

import scala.annotation._

trait PalindromeCheckers {

  def checkReverse(s: String): Boolean =
    s == s.reverse

  def checkIndices(s: String): Boolean = {
    @tailrec
    def loop(i: Int, j: Int): Boolean = (i,j) match {
      case (i,j) if i+1 == j => s(i) == s(j)
      case (i,j) if i == j => true
      case (i,j) if s(i) != s(j) => false
      case (i,j) if s(i) == s(j) => loop(i+1,j-1)
    }

    s.isEmpty || loop(0,s.length-1)
  }

  // Exercise: write your own implementation, don't forget to add a property first!
  def checkWithOwnAlgorithm(s: String): Boolean = ???

}

trait PalindromeDrafts {

  // FAULTY IMPLEMENTATION: index out of bounds on empty strings
  def checkIndices1(s: String): Boolean = {
    @tailrec
    def loop(i: Int, j: Int): Boolean = (i,j) match {
      case (i,j) if i == j => true
      case (i,j) if s(i) != s(j) => false
      case (i,j) if s(i) == s(j) => loop(i+1,j-1)
    }

    loop(0,s.length-1)
  }

  // FAULTY IMPLEMENTATION: index out of bounds because indices pass
  // each other
  def checkIndices2(s: String): Boolean = {
    @tailrec
    def loop(i: Int, j: Int): Boolean = (i,j) match {
      case (i,j) if i == j => true
      case (i,j) if s(i) != s(j) => false
      case (i,j) if s(i) == s(j) => loop(i+1,j-1)
    }

    s.isEmpty || loop(0,s.length-1)
  }
}
