# Template for Simple Spark Project

The purpose of this Giter8 template is to make it easier to get started with a simple Spark project.

For example to set up skeleton code for a code test, with unit tests.

This Giter8 template deals with a few common Spark SBT pitfalls.


## Usage

### Run unit test

You can run Spark code in unit test without modifications to build.sbt file.

```sh
sbt test
```


### Run non Spark from

This is fine.

```sh
sbt run
```


### Run Spark from SBT

This does not work because project is set up to build a fat jar that does not contain spark code.

It fails with this message.

```
[info] running com.example.simplesparkproject.SparkWorker
Exception in thread "sbt-bg-threads-1" java.lang.NoClassDefFoundError: org/apache/spark/sql/SparkSession
```

It works if you comment out **% provided** in these two lines in build.sbt

```scala
libraryDependencies += "org.apache.spark" %% "spark-core" % sparkVersion % "provided"
libraryDependencies += "org.apache.spark" %% "spark-sql" % sparkVersion % "provided"
```

To this:

```scala
libraryDependencies += "org.apache.spark" %% "spark-core" % sparkVersion // % "provided"
libraryDependencies += "org.apache.spark" %% "spark-sql" % sparkVersion // % "provided"
```

#### Then run

```sh
sbt run
```


### Package thin jar for deployment to Databricks like Spark cluster

```sh
sbt clean package
```


### Package fat jar for Spark deployment

```sh
sbt clean assembly
```
