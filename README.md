A [Giter8][g8] template for setting up a simple Spark project

There are a few pitfalls in setting up a Spark project.

The purpose of this Giter8 template is to make it easier to get started with a simple Spark project.
For example, for a code test.

# Features

* Configure what version of Spark and Scala to use
* Setup Spark unit tests example
* Written to build thin jar
* Written to build fat jar
* Explains how to run Spark from sbt without the NoClassDefFoundError exception

# How to use

## Run template directly from sbt

```sh
sbt new sami-badawi/spark-setup.g8
```

## Run template locally

Download template and run

```sh
sbt new file://spark-setup.g8
```

## Parameters with defaults

```
name [Simple Spark Project]:
normalizedName [simplesparkproject]:
organization [com.example]:
package [com.example.simplesparkproject]:
sparkversion [3.3.2]:
scalaversion [2.12.18]:
```


## Note on Giter8 security

Giter8 will not run any code, but only transform names.

Template license
----------------
Written in 2023 by Sami Badawi sami dot badawi at gmail.


To the extent possible under law, the author(s) have dedicated all copyright and related
and neighboring rights to this template to the public domain worldwide.
This template is distributed without any warranty. See https://creativecommons.org/publicdomain/zero/1.0/.

[g8]: https://www.foundweekends.org/giter8/
