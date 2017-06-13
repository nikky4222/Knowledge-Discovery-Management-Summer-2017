
name := "Kdm1"

version := "1.0"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "1.6.0" % "provided",
  "org.apache.spark" %% "spark-streaming" % "1.6.0",
  "org.apache.spark" %% "spark-mllib" % "1.6.0"

)


scalaVersion := "2.11.8"
