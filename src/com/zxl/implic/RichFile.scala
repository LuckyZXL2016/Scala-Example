package com.zxl.implic

import java.io.File

import com.zxl.implic.MyPredef._

import scala.io.Source

/**
  * Created by ZXL on 2017/10/10.
  */
class RichFile(val f: File) {

  def read() = Source.fromFile(f).mkString
}

object RichFile {

  def main(args: Array[String]) {
    val f = new File("D:\\test\\spark\\words.txt")
    // 装饰，显示的增强
    //val contents = new RichFile(f).read()

    // 隐式转换 f会作为参数传入隐式函数中
    val contents = f.read()
    println(contents)
  }
}
