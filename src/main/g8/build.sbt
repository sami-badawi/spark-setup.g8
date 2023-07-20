version := "0.1.0"
organization := "$organization$"
organizationName := "ACME Inc."

scalaVersion := "$scalaversion$"

val sparkVersion = "$sparkversion$"

// comment out provided to run Spark code with sbt run
libraryDependencies += "org.apache.hadoop" % "hadoop-common" % sparkVersion
libraryDependencies += "org.apache.spark" %% "spark-core" % sparkVersion % "provided"
libraryDependencies += "org.apache.spark" %% "spark-sql" % sparkVersion % "provided"
libraryDependencies += "org.scalatest" %% "scalatest" % "latest.integration" % "test"

// Only needed for fat jar for testing
assembly / assemblyMergeStrategy := {
  case PathList("META-INF","services",xs @ _*) => MergeStrategy.filterDistinctLines
  case PathList("META-INF",xs @ _*) => MergeStrategy.discard
  case "application.conf" => MergeStrategy.concat
  case _ => MergeStrategy.first
}

assembly / assemblyExcludedJars := {
  val cp = (assembly / fullClasspath).value
  cp filter { f =>
    f.data.getName.contains("hadoop-hdfs-2")
    f.data.getName.contains("hadoop-client")
  }
}
