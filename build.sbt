lazy val commonSettings = Seq(
  organization := "home",
  scalaVersion := "2.11.11"
)

val log4jVersion = "2.8.2"

lazy val root = project in file(".")

lazy val rwas = (project in file("reactive-web-applications"))
  .settings(
    commonSettings,
    name := "reactive web applications",
    version := "0.2-SNAPSHOT",
    libraryDependencies ++= Seq(
      cache,
      ws,
      "org.scalatestplus.play" %% "scalatestplus-play" % "2.0.0" % Test
    )
  )
  .enablePlugins(PlayScala)

lazy val sh2 = (project in file("slick-h2-example"))
  .settings(
    commonSettings,
    name := "slick h2 example",
    version := "0.1-SNAPSHOT",
    libraryDependencies ++= Seq(
      "com.h2database" % "h2" % "1.4.195",
      "com.typesafe.slick" %% "slick" % "3.2.0",
      "com.typesafe.slick" %% "slick-hikaricp" % "3.2.0",
      "org.apache.logging.log4j" % "log4j-api" % log4jVersion,
      "org.apache.logging.log4j" % "log4j-slf4j-impl" % log4jVersion,
      "junit" % "junit" % "4.12" % Test,
      "org.scalatest" %% "scalatest" % "3.0.1" % Test
    )
  )

lazy val awsl = (project in file("aws-lambda"))
  .settings(
    organization := "home",
    name := "AWS Lambda",
    version := "0.1-SNAPSHOT",
    javacOptions ++= Seq("-source", "1.8", "-target", "1.8"),
    mainClass in assembly := Some("home.Main"),
    assemblyJarName in assembly := "aws-lambda.jar",  // otherwise the project name is used
    assemblyOption in assembly := (assemblyOption in assembly).value.copy(includeScala = false),
    libraryDependencies ++= Seq(
      "org.apache.logging.log4j" % "log4j-api" % log4jVersion,
      "org.apache.logging.log4j" % "log4j-core" % log4jVersion,
      "com.amazonaws" % "aws-lambda-java-core" % "1.1.0"
    )
  )