name := """play-java-forms-example"""

version := "2.8.x"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.13.1"

libraryDependencies += guice

libraryDependencies += "org.twitter4j" % "twitter4j-core" % "4.0.6"
libraryDependencies += "org.apache.commons" % "commons-lang3" % "3.11"
libraryDependencies += "org.hamcrest" % "hamcrest" % "2.1" % Test
libraryDependencies += "org.mockito" % "mockito-core" % "3.5.13" % Test
libraryDependencies += "javadoc" % "javadoc" % "1.3"



libraryDependencies ++= Seq(
  caffeine
)

// Compile the project before generating Eclipse files, so
// that generated .scala or .class files for views and routes are present

EclipseKeys.preTasks := Seq(compile in Compile, compile in Test)

// Java project. Don't expect Scala IDE
EclipseKeys.projectFlavor := EclipseProjectFlavor.Java

// Use .class files instead of generated .scala files for views and routes
EclipseKeys.createSrc := EclipseCreateSrc.ValueSet(EclipseCreateSrc.ManagedClasses, EclipseCreateSrc.ManagedResources)
