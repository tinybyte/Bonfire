import sbt._

class Bonfire (info:ProjectInfo) extends DefaultProject(info) {
  lazy val greet = task {println("Bonfire is burning...");None}
  // add local maven repo
  val mavenLocal = "Local Maven Repository" at "file://"+Path.userHome+"E:/DEV/BUILD_TOOLS/MAVEN/.m2/repository"  
}
