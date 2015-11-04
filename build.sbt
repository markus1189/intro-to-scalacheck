organization := "de.codecentric"

name := "palindrome-checker"

version := "1.0"

scalaVersion := "2.11.7"

libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.12.5" % "test"

scalacOptions ++= List(
  "-deprecation",
  "-feature",
  "-unchecked",
  "-Xlint:_",
  "-Xstrict-inference",
  "-Ywarn-adapted-args",
  "-Ywarn-dead-code",
  "-Ywarn-inaccessible",
  "-Ywarn-infer-any",
  "-Ywarn-nullary-override",
  "-Ywarn-nullary-unit",
  "-Ywarn-numeric-widen",
  "-Ywarn-unused",
  "-Ywarn-unused-import",
  "-Ywarn-value-discard"
)
