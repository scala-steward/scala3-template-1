val Scala3Version = "3.2.2"
val CatsEffectVersion = "3.4.11"
val CatsVersion = "2.9.0"
val CirceVersion = "0.14.3"
val Fs2Version = "3.6.1"
val Http4sVersion = "0.23.17"
val DoobieVersion = "1.0.0-RC2"
val PureConfigVersion = "0.17.2"
val Log4CatsVersion = "2.5.0"
val LogBackVersion = "1.4.5"
val MunitVersion = "0.7.29"
val MunitCatsEffectVersion = "1.0.7"
val ScalaCheckEffectVersion = "1.0.4"
val TestContainersScalaVersion = "0.40.12"
val FlywayVersion = "7.10.0"

lazy val root = project
  .in(file("."))
  .enablePlugins(DockerPlugin)
  .enablePlugins(AshScriptPlugin)
  .settings(
    name := "scala3-template",
    ThisBuild / run / fork := true,
    Test / fork := true,
    scalaVersion := Scala3Version,
    ThisBuild / version ~= (_.replace('+', '-')),
    scalacOptions += "-Ykind-projector",

    Docker / packageName := "scala3-template",
    dockerUpdateLatest := true,
    dockerUsername := Some("peterstormio"),
    dockerBaseImage := "adoptopenjdk/openjdk11:alpine-jre",
    makeBatScripts := Seq(),

    libraryDependencies ++= Seq(
      "org.typelevel" %% "cats-core" % CatsVersion,
      "org.typelevel" %% "cats-effect" % CatsEffectVersion,
      "io.circe" %% "circe-core" % CirceVersion,
      "io.circe" %% "circe-extras" % CirceVersion,
      "io.circe" %% "circe-generic" % CirceVersion,
      "io.circe" %% "circe-parser" % CirceVersion,
      "io.circe" %% "circe-jawn" % CirceVersion,
      "co.fs2" %% "fs2-core" % Fs2Version,
      "org.tpolecat" %% "doobie-core" % DoobieVersion,
      "org.tpolecat" %% "doobie-hikari" % DoobieVersion,
      "org.typelevel" %% "log4cats-slf4j" % Log4CatsVersion,
      "ch.qos.logback" % "logback-classic" % LogBackVersion,
      "org.http4s" %% "http4s-dsl" % Http4sVersion,
      "org.http4s" %% "http4s-circe" % Http4sVersion,
      "org.http4s" %% "http4s-ember-server" % Http4sVersion,
      "org.http4s" %% "http4s-blaze-client" % Http4sVersion,
      "org.http4s" %% "http4s-ember-client" % Http4sVersion,
      "com.github.pureconfig" %% "pureconfig-core" % PureConfigVersion,
      "org.flywaydb" % "flyway-core" % FlywayVersion,
      "org.scalameta" %% "munit" % MunitVersion % Test,
      "org.typelevel" %% "munit-cats-effect-3" % MunitCatsEffectVersion % Test,
      "com.dimafeng" %% "testcontainers-scala-munit" % TestContainersScalaVersion % Test,
      "com.dimafeng" %% "testcontainers-scala-oracle-xe" % TestContainersScalaVersion % Test,
      "org.typelevel" %% "scalacheck-effect-munit" % ScalaCheckEffectVersion,
      "org.scalameta" %% "munit-scalacheck" % MunitVersion,
      //"com.github.pureconfig" %% "pureconfig-cats-effect" % PureConfigVersion
    ),
  )
