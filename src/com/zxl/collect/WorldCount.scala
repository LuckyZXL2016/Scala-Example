package com.zxl.collect

object WorldCount {

  def main(args: Array[String]) {
    val lines = Array("hello tom hello jerry", "hello tom hello jerry")
    val grouped = lines.flatMap(_.split(" ")).map((_,1)).groupBy(_._1)
    //val result = grouped.map(t=>(t._1, t._2.foldLeft(0)(_ + _._2)))
    val result = grouped.map(t=>(t._1, t._2.foldLeft(0)((x, y) => (x + y._2))))

    println(result)
  }
}
