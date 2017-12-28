package com.zxl.cases

import scala.util.Random

/**
  * Created by ZXL on 2017/10/3.
  * 样例类
  */
object CaseDemo01 extends App {

  val arr = Array("Z1", "Z2", "Z3")
  val name = arr(Random.nextInt(arr.length))
  println(name)
  name match {
    case "Z1" => println("张一")
    case "Z2" => println("张二")
    case _ => println("张三")
  }
}
