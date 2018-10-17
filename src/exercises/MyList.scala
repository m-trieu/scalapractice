package exercises


import scala.annotation.tailrec

abstract class MyList[+T] {
  def head: T
  def tail: MyList[T]
  def isEmpty: Boolean
  def add[S >: T](num: S): MyList[S]
  def printElements: String
  def map[B](transformer: MyTransformer[T, B]): MyList[B]
  def flatMap[B](transformer: MyTransformer[T, MyList[B]]) : MyList[B]
  def filter(filter: MyPredicate[T]): MyList[T]
  def ++[S >: T](list: MyList[S]): MyList[S]
  override def toString: String = "[ " + printElements + " ]"
}

object Empty extends MyList[Nothing] {
  override def head: Nothing = throw new NoSuchElementException
  override def tail: MyList[Nothing] = throw new NoSuchElementException
  override def isEmpty: Boolean = true
  override def add[S >: Nothing](num: S): MyList[S] = new Construct[S](num, Empty)
  override def printElements: String = ""
  override def map[B](transformer: MyTransformer[Nothing, B]): MyList[B] = Empty
  override def flatMap[B](transformer: MyTransformer[Nothing, MyList[B]]): MyList[B] = Empty
  override def filter(filter: MyPredicate[Nothing]): MyList[Nothing] = Empty
  override def ++[S >: Nothing](list: MyList[S]): MyList[S] = list
}

class Construct[+T](h: T, t: MyList[T]) extends MyList[T] {
  override def head: T = h
  override def tail: MyList[T] = t
  override def isEmpty: Boolean = false
  override def add[S >: T](num: S): MyList[S] = new Construct[S](num, this)
  override def map[B](transformer: MyTransformer[T, B]): MyList[B] =
    new Construct[B](transformer.transform(h), t.map(transformer))

  override def flatMap[B](transformer: MyTransformer[T, MyList[B]]): MyList[B] =
    transformer.transform(h) ++ t.flatMap(transformer)

  override def filter(predicate: MyPredicate[T]): MyList[T] = {
    if(predicate.test(h)) new Construct(h, t.filter(predicate))
    else t.filter(predicate)
  }

  override def ++[S >: T](list: MyList[S]): MyList[S] = new Construct[S](h, t ++ list)

  override def printElements: String = {
    @tailrec
    def append(string: String, list: MyList[T]): String =
      if(list.isEmpty) string
      else append(string.concat(s"${list.head} "), list.tail)
    append("", this)
  }

}

trait MyPredicate[-T] {
  def test(element: T): Boolean
}

trait MyTransformer[-A, B] {
  def transform(element: A): B
}
