package com.zxl.implic

import com.zxl.implic.Context._
/**
  * Created by ZXL on 2017/10/10.
  */
object Context {
  implicit val aaaaa = "laozhao"
  implicit val i = 1
}

object ImplicitValue {

  def sayHi()(implicit name: String = "laoduan"): Unit = {
    println(s"hi~ $name")
  }

  def main(args: Array[String]) {

    println(1 to 10)

    sayHi()
  }

}
