val scala3Version = "3.3.1"
val slf4jVersion = "2.0.13"
val zioVersion = "2.0.21"
val zioLoggingVersion = "2.2.3" // last version supporting JDK 8

ThisBuild / useCoursier := false

lazy val commonSettings = Seq(
  version := "0.1.0-SNAPSHOT",
  scalaVersion := scala3Version,
  scalacOptions ++= Seq("-Wunused:all", "-Xmax-inlines", "128"),
  resolvers ++= Seq(
    Resolver.mavenLocal,
    "Jitpack" at "https://jitpack.io",
    "Shibboleth" at "https://build.shibboleth.net/nexus/content/groups/public"
  )
)

lazy val baseDependencies = Seq(
  "org.slf4j" % "slf4j-api" % slf4jVersion,
  "org.apache.logging.log4j" % "log4j-slf4j2-impl" % "2.23.1",
  "dev.zio" %% "zio" % zioVersion,
  "dev.zio" %% "zio-logging" % zioLoggingVersion,
  "dev.zio" %% "zio-logging-slf4j" % zioLoggingVersion,
  "org.apache.logging.log4j" % "log4j-core" % "2.12.4"
)

lazy val root = project
  .in(file("."))
  .settings(
    commonSettings,
    name := "app",
    libraryDependencies ++= baseDependencies
  )
