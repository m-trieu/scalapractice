package exercises

import scala.annotation.tailrec

abstract class MyList {
  def head: Int
  def tail: MyList
  def isEmpty: Boolean
  def add(num: Int): MyList
  def printElements: String
  override def toString: String = "[ " + printElements + " ]"
}

object Empty extends MyList {
  override def head: Int = throw new NoSuchElementException
  override def tail: MyList = throw new NoSuchElementException
  override def isEmpty: Boolean = true
  override def add(num: Int): MyList = new NotEmpty(num, Empty)
  override def printElements: String = ""
}

class NotEmpty(h: Int, t: MyList) extends MyList {
  override def head: Int = h
  override def tail: MyList = t
  override def isEmpty: Boolean = false
  override def add(num: Int): MyList = new NotEmpty(num, this)

  override def printElements: String = {
    @tailrec
    def append(string: String, list: MyList): String = {
      if(list.isEmpty) string
      else append(string.concat(s"${list.head} "), list.tail)
    }
    append("", this)
  }
}
