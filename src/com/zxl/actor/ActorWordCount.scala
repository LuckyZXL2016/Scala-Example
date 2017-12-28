package com.zxl.actor

import scala.actors.{Future, Actor}
import scala.collection.mutable.HashSet
import scala.collection.mutable.ListBuffer
import scala.io.Source

/**
  * Created by ZXL on 2017/10/4.
  * 根据actor机制简单实现WordCount
  */
class Task extends Actor {
  override def act(): Unit = {
    loop {
      react {
        case SubmitTask(filename) => {
          // 局部统计, 结果是Map[String, Int]
          val result = Source.fromFile(filename).getLines().flatMap(_.split(" ")).map((_, 1)).toList.groupBy(_._1).mapValues(_.size)
          // sender将结果返回给发送者
          sender ! ResultTask(result)
        }
        case StopTask => {
          exit()
        }
      }
    }
  }
}

// 样例类
case class SubmitTask(filename: String)
case class ResultTask(result: Map[String, Int])
case object StopTask

object ActorWordCount {

  def main(args: Array[String]) {
    val replySet = new HashSet[Future[Any]]()
    val resultList = new ListBuffer[ResultTask]()

    val files = Array[String]("d://test//spark//words.txt", "d://test//spark//words.log")
    for(f <- files) {
      val actor = new Task
      // 启动,并发送消息,返回Future, 当sender后reply才有值
      // !!表示异步执行并且有返回值(返回值为future) !?为同步执行  !为异步执行但没有返回值
      val reply = actor.start() !! SubmitTask(f)
      replySet += reply // 把这些Future放到集合中
    }

    while(replySet.size > 0) {
      // 取出有效的结果, 待处理的数据
      val toCompute = replySet.filter(_.isSet)
      for(f <- toCompute) {
        // 获取实例, 注意f后要加(), 调用apply(), 否则会报转换异常
        val result = f().asInstanceOf[ResultTask]
        resultList += result
        replySet -= f
      }
      Thread.sleep(100)
    }

    // 多个文件执行后汇总的功能
    // flatMap(_.result)中的result与定义样例类时的参数名一致
    val fr = resultList.flatMap(_.result).groupBy(_._1).mapValues(_.foldLeft(0)(_+_._2))
    println(fr)
  }
}
