package lectures.part1basics

object Function extends App {

  def aFunction(a: String, b: Int): String = a + " " + b

  //a greeting function
  def greeting(name: String, age:Int) =
    "hi, my name is " + name + " and I am " + age + " years old"

  def factorial(n: Int): Int = {
    if(n <= 0) 1
    else n * factorial(n - 1)
  }

  def fib(n: Int): Int = {
    if(n <= 1) 1
    else fib(n - 1) + fib(n - 2)
  }

  def isPrime(n :Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean =
      if(t <= 1) true
      else n % t != 0 && isPrimeUntil(t - 1)
    isPrimeUntil(n / 2)
  }

  def concatN(string: String, times: Int): String = {
    def helper(string: String, timesLeft: Int): String = {
      if(timesLeft == 1) string
      else helper(string + string, timesLeft - 1)
    }

    helper(string, times)
  }
}
