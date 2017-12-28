package com.zxl.actor

import scala.actors.Actor

/**
  * Created by ZXL on 2017/10/4.
  * Scala Actor并发编程
  * 初识Actor
  */
object MyActor1 extends Actor {
  //重新act方法
  def act() {
    for (i <- 1 to 20) {
      println("actor-1 " + i)
      Thread.sleep(1000)
    }
  }
}

object MyActor2 extends Actor {
  //重新act方法
  def act() {
    for (i <- 1 to 20) {
      println("actor-2 " + i)
      Thread.sleep(1000)
    }
  }
}

object ActorTest extends App {
  //App特质声明了带有合适签名的main方法
  //启动Actor
  MyActor1.start()
  MyActor2.start()
  println("main")
}
