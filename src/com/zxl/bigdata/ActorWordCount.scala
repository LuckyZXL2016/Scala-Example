package com.zxl.bigdata

import scala.actors.{Future, Actor}
import scala.collection.mutable.ListBuffer
import scala.io.Source

/**
  * Created by ZXL on 2017/10/8.
  * 利用actor机制实现简易版WordCount
  */

case class Submit(filePath: String)

case object Stop

class Task extends Actor {

  override def act(): Unit = {
    while (true) {
      receive {
        case Submit(f) => {
          val result = Source.fromFile(f).getLines().toList.flatMap(_.split(" "))
            .map((_, 1)).groupBy(_._1).mapValues(_.size)
          sender ! result
        }
        case Stop => {
          println("stop")
          exit()
        }
      }
    }
  }
}

object ActorWordCount {

  def main(args: Array[String]) {

    val futures = new ListBuffer[Future[Any]]
    val results = new ListBuffer[Map[String, Int]]
    val files = Array("c://words.txt", "c://words.log")
    for (f <- files) {
      val t = new Task
      t.start()
      val future = t !! Submit(f)
      futures += future
    }

    while (futures.size > 0) {
      val toComFutus = futures.filter(_.isSet)
      for(f <- toComFutus) {
        results += f.apply().asInstanceOf[Map[String, Int]]
        futures -= f
      }
      Thread.sleep(500)
    }

    val finalRsult = results.flatten.groupBy(_._1).mapValues(_.foldLeft(0)(_+_._2))
    println(finalRsult)

  }
}
