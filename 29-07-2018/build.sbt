val commonSettings= Seq(

version := "0.1",
  scalaVersion := "2.12.6"
)
lazy val root = (project in file("."))
  .settings(commonSettings)
  .settings(
    name := "29-7-2018",
    libraryDependencies ++= Seq ("org.scalatest" %% "scalatest" % "3.0.5" % Test,
      "org.mockito" % "mockito-all" % "1.9.5"
    )
  )
  .dependsOn(availableProducts,cart)
  .aggregate(availableProducts,cart)

lazy val availableProducts=(project in file("availableProducts"))
  .settings(commonSettings)
  .settings(
    name := "availableProducts",
    libraryDependencies ++= Seq( "org.scalatest" %% "scalatest" % "3.0.5" % Test,
      "org.mockito" % "mockito-all" % "1.9.5")
  )
lazy val cart=(project in file("cart"))
  .settings(commonSettings)
  .settings(
    name := "cart",
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.0.5" % Test,
      "org.mockito" % "mockito-all" % "1.9.5")
  )
  .dependsOn(availableProducts)