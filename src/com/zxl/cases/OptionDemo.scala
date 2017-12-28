package com.zxl.cases

/**
  * Created by ZXL on 2017/10/4.
  * 获取map值
  */
object OptionDemo {

  def main(args: Array[String]) {
    val map = Map("a" -> 1, "b" -> 2)

    val v = map.get("b") match {
      case Some(i) => i
      case None => 0
    }
    println(v)
    //更好的方式
    val v1 = map.getOrElse("c", 0)
    println(v1)
  }
}
