name := """BigDataWeb"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  javaWs
)

libraryDependencies += "postgresql" % "postgresql" % "9.1-901-1.jdbc4"

libraryDependencies += "org.apache.mahout" % "mahout-core" % "0.9"

libraryDependencies += "junit" % "junit" % "3.8.1"

libraryDependencies += "com.mashape.unirest" % "unirest-java" % "1.3.27"

libraryDependencies += "org.apache.httpcomponents" % "httpclient" % "4.3.6"

libraryDependencies += "org.apache.httpcomponents" % "httpasyncclient" % "4.0.2"

libraryDependencies += "org.apache.commons" % "commons-io" % "1.3.2"

libraryDependencies += "com.googlecode.json-simple" % "json-simple" % "1.1.1"