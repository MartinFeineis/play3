name := "play3"

version := "1.0"

lazy val `play3` = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq( jdbc , anorm , cache , ws,
"org.reactivemongo" %% "reactivemongo" % "0.11.7"
)

unmanagedResourceDirectories in Test <+=  baseDirectory ( value => value / "target/web/public/test" )