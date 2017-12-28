package com.zxl.collect

object ListTest {
  def main(args: Array[String]) {
    //创建一个List
    val lst0 = List(1,7,9,8,0,3,5,4,6,2)
    //将lst0中每个元素乘以10后生成一个新的集合
    val lst1 = lst0.map(x => x * 2)
    //将lst0中的偶数取出来生成一个新的集合
    val lst2 = lst0.filter(x => x % 2 == 0)
    //将lst0排序后生成一个新的集合
    val lst3 = lst0.sorted
    val lst4 = lst0.sortBy(x => x)
    val lst5 = lst0.sortWith((x, y) => x < y)
    //反转顺序
    val lst6 = lst3.reverse
    //将lst0中的元素4个一组,类型为Iterator[List[Int]]
    val it = lst0.grouped(4)
    //将Iterator转换成List
    val lst7 = it.toList
    //将多个list压扁成一个List
    val lst8 = lst7.flatten

    //先按空格切分，在压平
    val a = Array("a b c", "d e f", "h i j")
    a.flatMap(_.split(" "))


    //并行计算求和
    lst0.par.sum
    lst0.par.map(_ % 2 == 0)
    lst0.par.reduce((x, y) => x + y)
    //化简：reduce
    //将非特定顺序的二元操作应用到所有元素
    val lst9 = lst0.reduce((x, y) => x + y)
    //安装特点的顺序
    val lst10 = lst0.reduceLeft(_+_)

    //折叠：有初始值（无特定顺序）
    val lst11 = lst0.fold(100)((x, y) => x + y)
    //折叠：有初始值（有特定顺序）
    val lst12 = lst0.foldLeft(100)((x, y) => x + y)


    //聚合
    val arr = List(List(1, 2, 3), List(3, 4, 5), List(2), List(0))
    val result = arr.aggregate(10)(_+_.sum, _+_)

    val l1 = List(5,6,4,7)
    val l2 = List(1,2,3,4)
    //求并集
    val r1 = l1.union(l2)
    //求交集
    val r2 = l1.intersect(l2)
    //求差集
    val r3 = l1.diff(l2)
    println(r3)

    val m = Map(("a", 1))

  }
}
