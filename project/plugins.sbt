logLevel := Level.Warn

resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"

addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.3.8")

libraryDependencies ++= Seq(
  "org.reactivemongo" %% "reactivemongo" % "0.11.7"
)