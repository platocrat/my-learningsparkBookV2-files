package main.scala.chapter2

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

/**
  * Usage: MnMcount <mnm_file_dataset>
  */
object MnMcount {
  def main(args: Array[String]) {
    val spark = SparkSession
      .builder
      .appName("MnMcount")
      .getOrCreate()

    if (args.length < 1) {
      print("Usage: MnMcount <mnm_file_dataset>")
    }

    // Get the M&M dataset filename
    val mnmFile = args(0)

    // Read the file into a Spark DataFrame
    val mnmDF = spark.read.format("csv")
      .option("header", "true")
      .option("inferSchema", "true")
      .load(mnmFile)

    // Aggregate counts of all colors and groupBy() State and Color
    // orderBy() in descending order
    val countMnMDF = mnmDF
      .select("State", "Color", "State")
      .groupBy("State", "Color")
      .agg(count("Color").alias("Total"))
      .orderBy(desc("Total"))

    // Show the resulting aggregations for all the states and colors
    countMnMDF.show(60)
    println(s"Total Rows = ${countMnMDF.count()}")
    println()

    // Find the aggregate counts for California by filtering
    val caCountMnMDF = mnmDF
      .select("State", "Color", "State")
      .where(col("State") === "CA")
      .groupBy("State", "Color")
      .agg(count("Color").alias("Total"))
      .orderBy(desc("Total"))

    // Show the resulting aggregations for California
    caCountMnMDF.show(10)

    // Stop the SparkSession
    spark.stop()
  }
}
