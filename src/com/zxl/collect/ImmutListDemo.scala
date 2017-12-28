package com.zxl.collect

object ImmutListDemo extends App {

  //创建一个不可变的集合
  val lst1 = List(1, 2, 3)
  //将0插入到lst1的前面生成一个新的List
  val lst2 = 0 :: lst1
  val lst3 = lst1.::(0)
  val lst4 = 0 +: lst1
  val lst5 = lst1.+:(0)

  //将一个元素添加到lst1的后面产生一个新的集合
  val lst6 = lst1 :+ 3

  val lst0 = List(4, 5, 6)
  //将2个list合并成一个新的List
  val lst7 = lst1 ++ lst0
  //将lst0插入到lst1前面生成一个新的集合
  val lst8 = lst1 ++: lst0

  //将lst0插入到lst1前面生成一个新的集合
  val lst9 = lst1.:::(lst0)

  println(lst9)

}
