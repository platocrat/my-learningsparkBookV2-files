// Name of the package
name := "main/scala/chapter2"

// Version of our package
version := "1.0"

// Version of Scala
scalaVersion := "2.12.13"

// Spark library dependencies
libraryDependencies ++= Seq(
  "org.apache.spark" && "spark-core" % "3.0.0-bin-hadoop2.7",
  "org.apache.spark" && "spark-sql" % "3.0.0-bin-hadoop2.7"
)
