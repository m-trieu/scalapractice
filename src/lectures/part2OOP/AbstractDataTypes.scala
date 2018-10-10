package lectures.part2OOP

object AbstractDataTypes extends App {
  abstract class Animal {
    val creatureType: String
    def eat: Unit
  }

  class Dog extends Animal {
    override val creatureType: String = "dog"
    override def eat: Unit = println("bite")
  }

  trait Carnivore {
    def eat(animal: Animal):Unit
  }

  class Crocodile extends Animal with Carnivore {

    override val creatureType: String = "reptile"

    override def eat: Unit = println("chunk")

    override def eat(animal: Animal): Unit = s"I'm a croc and I'm eating ${animal.creatureType}"
  }
}
