package com.zxl.implic.example

class MissRight[T] {

  def choose(first: T, second: T)(implicit ord : T => Ordered[T]): T = {
    // 如果first没有方法>，则调用ord(first) > second
    if(first > second) first else second
  }

  def select(first: T, second: T)(implicit ord : Ordering[T]): T ={
    if(ord.gt(first, second)) first else second
  }

  def random(first: T, second: T)(implicit ord : Ordering[T]): T ={
    import Ordered.orderingToOrdered
    if(first > second) first else second
  }

}

object MissRight {
  def main(args: Array[String]) {
    val mr = new MissRight[Girl]
    val g1 = new Girl("hatanao", 98, 28)
    val g2 = new Girl("sora", 95, 33)

    import MyPreDef.girlOrdering
    val g = mr.choose(g1, g2)
//    val g = mr.select(g1, g2)
    println(g.name)
  }
}
