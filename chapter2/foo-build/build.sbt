ThisBuild / scalaVersion := "2.13.3"
ThisBuild / organization := "com.donotforgetaboutthegoalsiwrotedown"

/**
  * The following lines of code below are used to provide clean
  * imports for libraries `scalaTest`, `gigahorse-okhttp`, and
  * `play-json`.
  */
val scalaTest = "org.scalatest" %% "scalatest" % "3.2.0" % "test"
val gigahorse = "com.eed3si9n" %% "gigahorse-okhttp" % "0.5.0"
val playJson = "com.typesafe.play" %% "play-json" % "2.9.0"

lazy val hello = (project in file("."))
  // Add `aggregate` setting so the command sent to `hello` is broadcast 
  // to `helloCore` as well.
  .aggregate(helloCore) // `.aggregate()` is useful for broadcasting commands across projects
  .dependsOn(helloCore) // `.dependsOn()` is useful for adding a dependency _that is on on_ subprojects
  .settings(
    name := "Hello",
    libraryDependencies += scalaTest
  )

lazy val helloCore = (project in file("core"))
  .settings(
    name := "Hello Core",
    libraryDependencies ++= Seq(gigahorse, playJson),
    libraryDependencies += scalaTest
  )
