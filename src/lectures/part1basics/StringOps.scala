package lectures.part1basics

object StringOps extends App {

  val string = "hello, i am learning scala"

  println(string.charAt(2))
  println(string.substring(7, 11))
  println(string.split(" ").toList)
  println(string.startsWith("hello"))


}
