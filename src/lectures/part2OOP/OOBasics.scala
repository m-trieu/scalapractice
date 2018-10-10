package lectures.part2OOP

object OOBasics extends App {
 val person = new Person("John", 26)
  println(person.age)
}

class Person(val name: String, val age: Int)

class Writer(val firstName: String, val lastName: String, val birthYr: Int) {
  def fullName() = s"$firstName $lastName"
}

class Novel(val name: String, val yearOfRelease: Int, val author: Writer){
  def authorAge() = yearOfRelease - author.birthYr
  def isWrittenBy(author: Writer) = author == this.author
  def copy(newYearOfRelease: Int) = new Novel(name, newYearOfRelease, author)
}

class Counter(val count: Int) {
  def currentCount = count
  def increment(amount: Int = 1) = new Counter(count + amount)
  def decrement(amount: Int = 1) = new Counter(count - amount)
}