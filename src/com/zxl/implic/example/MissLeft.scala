package com.zxl.implic.example

//class MissLeft[T <% Ordered[T]] {
//
//  def choose(first: T, second: T) : T = {
//    if (first > second) first else second
//  }
//
//}

class MissLeft[T : Ordering] {

  def choose(first: T, second: T): T = {
    val ord = implicitly[Ordering[T]]
    if(ord.gt(first, second)) first else second
  }
}

object MissLeft {
  def main(args: Array[String]) {
    import MyPreDef.girlOrdering
    val ml = new MissLeft[Girl]
    val g1 = new Girl("hatanao", 98, 28)
    val g2 = new Girl("sora", 95, 33)
    val g = ml.choose(g1, g2)
    println(g.name)
  }
}
