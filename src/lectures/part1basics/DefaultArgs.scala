package lectures.part1basics

object DefaultArgs extends App {
  def factorial(n: Int, accum: Int = 1): Int = {
    if(n <= 1) accum
    else factorial(n - 1, accum * n)
  }
  val fact10 = factorial(10)
}

