package de.codecentric.palindrome

import org.scalacheck._
import org.scalacheck.Prop.forAll
import org.scalacheck.Arbitrary.arbitrary
import org.scalacheck.Shrink.shrink

object PalindromeCheck
    extends Properties("Palindrome")
    with PalindromeCheckers
    with PalindromeDrafts {

  val palindromeGen: Gen[String] = for {
    base <- arbitrary[String]
    middle <- Gen.option(arbitrary[Char])
  } yield base + middle.getOrElse("") + base.reverse

  val maybePalindrome: Gen[String] = Gen.oneOf(palindromeGen,arbitrary[String])

  property("checkReverse") = forAll(palindromeGen) { s =>
    checkReverse(s)
  }

  property("FAULTY: checkIndices1") = forAll(maybePalindrome) { s =>
    checkReverse(s) == checkIndices1(s)
  }

  property("FAULTY: checkIndices2") = forAll(maybePalindrome) { s =>
    checkReverse(s) == checkIndices2(s)
  }

  property("checkIndices") = forAll(maybePalindrome) { s =>
    checkReverse(s) == checkIndices(s)
  }
}
