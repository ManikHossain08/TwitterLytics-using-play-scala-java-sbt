Play Framework Notes
You can find the Play Framework homepage at https://playframework.com/

Documentation is located at https://www.playframework.com/documentation/2.8.x/Home – make sure you look at the Java documentation (it also has Scala documentation) and are viewing the latest version (you can see the Java/Scala and Play version menu on the top right).

Prerequisites
Note you need to have Java installed in version 8 or 11 to work with Play.



Play "Hello World" Project
Go to https://playframework.com/download#starters to download a starter project. Make sure you choose the "Play Java Hello World Tutorial" under "Play 2.8.x Hello World Projects". The starter project comes with sbt (the build tool for Play) included. Note that this is a very minimal example project; on the same page you can also find example projects for different applications. Additional tutorial projects are linked under https://playframework.com/documentation/2.8.x/Tutorials.

Unzip the tutorial file. To run the starter project, simply type:

./sbt run
This will compile and run the Play project (the first time, this will download all required libraries). When the project is ready:

--- (Running the application, auto-reloading is enabled) ---

[info] p.c.s.AkkaHttpServer - Listening for HTTP on /0:0:0:0:0:0:0:0:9000 
you can access it from your web browser by going to http://localhost:9000.

Troubleshooting
If you get an error like:

﻿﻿﻿> ./sbt compile

The java installation you have is not up to date
requires at least version 1.6+, you have
version 11.0.2

Please go to http://www.java.com/getjava/ and download
a valid Java Runtime and install before running .
The problem is actually the bundled sbt version, in this case please download the current version of sbt and use this instead of the included one.

Eclipse and Play
To use Eclipse for Play development, you have to configure the "sbteclipse" plugin. Open the file project/plugins.sbt and add:

// Eclipse plugin, see https://github.com/typesafehub/sbteclipse
addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "5.2.4")
Then, you can run

sbt eclipse
to generate the Eclipse project files. Note that the project must have been compiled for this to work. Finally, import the project in Eclipse through File → Import (General/Existing project); here, select the Play starter project directory.

Play supports mixed-language projects (both Scala and Java in one project); for Java-only projects, you should add the additional configuration options as shown on the Play IDE page.

For more information on Play and IDEs, see https://www.playframework.com/documentation/2.8.x/IDE.


The Scala Build Tool (sbt)
As Play is written in Scala, it uses sbt, the Scala Build Tool. You can use sbt as a command-line tool, e.g.:

sbt run       # compile and run the project
sbt compile   # only compile the project
sbt clean     # clean generated files
sbt test      # run tests
However, sbt is meant to be used as a shell (REPL): simply type sbt and you are in a shell where you can issue commands like run, test, etc.

Note that Play supports hot reload (hot redeploy): when you run a Play project and change the code, it will automatically re-compile and re-deploy your project when you hit "refresh" in your browser – no need to stop the project and manually re-start it!

For more details, refer to the Play build documentation at https://playframework.com/documentation/2.8.x/Build, as well as the sbt documentation at https://www.scala-sbt.org/.

Note: in some older Play documentation (web pages, books, etc.), you may find references to an activator command. However, this is obsolete as activator has been replaced by sbt.



Testing
The starter project comes with some tests, which you can find under the test/ directory. Type

sbt test
to run the test cases (for additional options, such as only running a single test, see the documentation under https://playframework.com/documentation/2.8.x/JavaTest)

The test output is located in target/test-reports.

Computing Test Coverage with JaCoCo
To use JaCoCo with Play, you need to install another sbt module, sbt-jacoco. Similar to adding the Eclipse plugin, open the file project/plugins.sbt and add

// The JaCoCo Plugin, see https://github.com/sbt/sbt-jacoco
addSbtPlugin("com.github.sbt" % "sbt-jacoco" % "3.2.0")
Then, you can run the tests with coverage computation using

sbt jacoco
You will then see a report like this:

...
[info] Passed: Total 1, Failed 0, Errors 0, Passed 1
[info] 
[info] ------- Jacoco Coverage Report -------
[info] 
[info] Lines: 39.33% (>= required 0.0%) covered, 108 of 178 missed, OK
[info] Instructions: 31.03% (>= required 0.0%) covered, 1505 of 2182 missed, OK
[info] Branches: 14.29% (>= required 0.0%) covered, 72 of 84 missed, OK
[info] Methods: 20% (>= required 0.0%) covered, 168 of 210 missed, OK
[info] Complexity: 17.06% (>= required 0.0%) covered, 209 of 252 missed, OK
[info] Class: 57.14% (>= required 0.0%) covered, 9 of 21 missed, OK
[info] 
[info] Check /home/rene/play-samples-play-java-hello-world-tutorial/target/scala-2.13/jacoco/report for detailed report
[info]  
[success] Total time: 5 s, completed Oct 22, 2020, 6:47:22 AM
The report directory (see above) contains the detailed HTML report in the familiar JaCoCo format.



Adding Library Dependencies
If you want to use additional libraries in your project, this is done in the file build.sbt (located in the top-level of your project directory). Simply find the library on Maven Central, like before when you configured ivy, but now select the "SBT" tab to find the configuration line for sbt. For example, to use the Apache Commons Lang library v3.11 in your project, you would add:

libraryDependencies += "org.apache.commons" % "commons-lang3" % "3.11"
to your build.sbt.



A Note on Configuration Files
Don't confuse the following configuration files used in a Play project (see "Anatomy of a Play application"):

project/plugins.sbt: This file contains plugins for the sbt build tool. Here, you configure the build process (such as integration with Eclipse), as well as the version of Play being used for the project.
﻿project/build.properties: This file contains the version of sbt being used (this is different from the version of Play!). Note that the plugins configured above must be compatible with the sbt version you are using in your project – in general, you can't mix plugins for sbt v0.x and v1.x.
build.sbt: This file contains references to libraries and settings used within your application, as explained above under "Adding Library Dependencies". See the documentation on the build.sbt file and sbt settings.
conf/application.conf (as well as production.conf): These files contain the configurations for your specific Play application, such as languages, keys, databases, and security policies. They use the HOCON (Human-Optimized Config Object Notation) format; see Configuration file syntax and features.


Questions? Please ask in the Moodle Discussion Forum!

Last modified: Thursday, 22 October 2020, 8:13 AM