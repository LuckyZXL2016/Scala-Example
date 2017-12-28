package com.zxl.cases

import scala.util.Random

/**
  * Created by ZXL on 2017/10/4.
  * 样例类：
  *   多例：class
  *   单例：object
  */
case class SubmitTask(id: String, name: String)
// 多例
case class HeartBeat(time: Long)

// 单例
case object CheckTimeOutTask

object CaseDemo04 extends App {

  val arr = Array(CheckTimeOutTask, HeartBeat(12333), SubmitTask("0001", "task-0001"))


  val a = CheckTimeOutTask
  val b = CheckTimeOutTask

  arr(Random.nextInt(arr.length)) match {
    case SubmitTask(id, name) => {
      println(s"$id, $name")
    }
    case HeartBeat(time) => {
      println(time)
    }
    case CheckTimeOutTask => {
      println("check")
    }
  }
}
