package com.zxl.cases

/**
  * Created by ZXL on 2017/10/3.
  * 样例类
  */
object CaseDemo03 {

  //  val arr = Array(0, 1, 5, 7)
  //  arr match {
  //    case Array(1, x, y) => println(x + " " + y)
  //    case Array(1, 1, 5) => println("only 0")
  //    case Array(0, _*) => println("0 ...")
  //    case _ => println("something else")
  //  }

  //  val lst = List(0, 3, 4,5)
  //  lst match {
  //    case 0 :: Nil => println("only 0")
  //    case x :: y :: Nil => println(s"x: $x y: $y")
  //    case 0 :: a => println(s"0 ... $a")
  //    case _ => println("something else")
  //  }

  val tup = (6, 3, 5)
  tup match {
    case (1, x, y) => println(s"hello 123 $x , $y")
    case (_, z, 5) => println(z)
    case  _ => println("else")
  }
  //
  //  val lst1 = 9 :: (5 :: (2 :: Nil))
  //  val lst2 = 9 :: 5 :: 2 :: List()
  //  println(lst2)
}
