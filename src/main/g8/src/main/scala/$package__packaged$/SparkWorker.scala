package $package$

import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.SparkSession

import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.SparkSession

/** In order to call this with sbt run you need to comment out % "provided" in
  * build.sbt
  */
object SparkWorker {

  def makeSparkSession(
      name: String = "Test job",
      master: String = "local"
  ): SparkSession = {
    val spark = SparkSession
      .builder()
      .appName(name)
      .config("spark.master", master)
      .getOrCreate()
    spark.sparkContext.setLogLevel("ERROR")
    spark
  }

  def makeDfAndSparkSession() = {
    val spark = makeSparkSession()
    import spark.implicits._
    val seq = Seq(
      ("a", 1),
      ("b", 2)
    )
    val df = seq.toDF("letter", "number")
    (df, spark)
  }

  def main(args: Array[String]): Unit = {
    val (df, spark) = makeDfAndSparkSession()
    df.show()
    spark.stop()
  }
}
