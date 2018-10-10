package lectures.part2OOP

object MethodNotations extends App {
  class Person(val name: String, val favoriteMovie: String,  val age: Int = 0){
    def likes(movie: String) = movie == favoriteMovie
    def hangoutWith(person: Person) = s"$name is hanging out with ${person.name}"
    def +(adj: String) = s"${this.name} ($adj)"
    def unary_+ = new Person(name, favoriteMovie, age + 1)
    def learns(topic: String) = s"$name learns $topic"
    def learnsScala = this learns "Scala"
    def apply(number: Int) = s"$name watched $favoriteMovie $number times"

  }

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))
  println(mary likes "Inception")
}
