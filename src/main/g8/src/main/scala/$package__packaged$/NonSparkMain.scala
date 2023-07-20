package $package$

/**
  * Code not using Spark can be run with sbt run without commenting out % "provided" in build.sbt
  */
object NonSparkMain {

  def main(args: Array[String]): Unit = {
    println("Hello, world!")
  }
}
