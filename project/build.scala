import sbt._
import Keys._
import play.twirl.sbt.SbtTwirl
import play.twirl.sbt.Import.TwirlKeys._

object MyBuild extends Build {

  val Organization = "me.huzi.gitbucket"
  val Name = "gitbucket-desktopnotify-plugin"
  val Version = "3.12"
  val ScalaVersion = "2.11.6"

  lazy val project = Project (
    "gitbucket-desktopnotify-plugin",
    file(".")
  )
  .settings(
    sourcesInBase := false,
    organization := Organization,
    name := Name,
    version := Version,
    scalaVersion := ScalaVersion,
    scalacOptions := Seq("-deprecation", "-language:postfixOps"),
    resolvers ++= Seq(
      "amateras-repo" at "http://amateras.sourceforge.jp/mvn/"
    ),
    libraryDependencies ++= Seq(
      "gitbucket"          % "gitbucket-assembly" % "3.12.0" % "provided",
      "com.typesafe.play" %% "twirl-compiler"     % "1.0.4"  % "provided",
      "javax.servlet"      % "javax.servlet-api"  % "3.1.0"  % "provided",
      "jp.sf.amateras"    %% "scalatra-forms"     % "0.2.0"  % "provided"
    ),
    javacOptions in compile ++= Seq("-target", "8", "-source", "8")
  ).enablePlugins(SbtTwirl)
}
