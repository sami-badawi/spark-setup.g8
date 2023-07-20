package $package$

import org.scalatest.BeforeAndAfter
import org.scalatest.funspec._

class WorkerSpec extends AnyFunSpec with BeforeAndAfter {

  describe("create a simple dataframe in a unit test") {
    it("should work and show the dataframe") {
      val (actual, spark) = SparkWorker.makeDfAndSparkSession()
      import spark.implicits._
      actual.show()
      actual.printSchema()
      val actualSet = actual.as[(String, Int)].collect().toSet
      val expectedSet = Set(
        ("a", 1),
        ("b", 2)
      )
      assertResult(2) { actualSet.size }
      assertResult(expectedSet) { actualSet }
    }
  }
}
