package com.zxl.thread

import java.util.concurrent.{ExecutorService, Executors, TimeUnit}

/**
  * Created by ZXL on 2016/3/29.
  */
object ThreadPool01 {

  def main(args: Array[String]) {
    val threadPool: ExecutorService = Executors.newFixedThreadPool(10)
    val task = new Runnable {
      override def run(): Unit = {
        println(Thread.currentThread().getName)
        println("sub:--->submitting task...")
        Thread.sleep(10000)
        println("sub:--->task finished")
      }
    }
    println(Thread.currentThread().getName)
    println("main:----pre")
    threadPool.execute(task)
    println("main:----post")

    //threadPool.shutdown()
    threadPool.shutdownNow()
  }

}
