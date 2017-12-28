package com.zxl.implic

/**
  * Created by ZXL on 2017/10/10.
  */
// 视图界定
// Ordered是包含< >等符号
// 必须传进去一个隐式转换的函数
//class Chooser[T <% Ordered[T]] {
//
//  def choose(first: T, second: T): T = {
//    // 根据first与second为Girl类型去隐式转换中找
//    if(first > second) first else second
//  }
//}

// 上下文界定
// Ordering是包含gt lt等方法
// 必须传进去一个隐式转换的值
class Chooser[T: Ordering] {

  def choose(first: T, second: T): T = {
    val ord = implicitly[Ordering[T]]
    if (ord.gt(first, second)) first else second
  }
}

object Chooser {
  def main(args: Array[String]) {
    import MyPredef._
    val c = new Chooser[Girl]
    val g1 = new Girl("wr", 90)
    val g2 = new Girl("wx", 99)

    val g = c.choose(g1, g2)
    println(g.name)
  }
}
