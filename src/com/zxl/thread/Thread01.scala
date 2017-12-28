package com.zxl.thread

/**
  * Created by ZXL on 2016/3/29.
  */
object Thread01 {

  def main(args: Array[String]) {
    val thread = new Thread(
      new Runnable {
      override def run(): Unit = {
        for(i <- 1 to 100) println(i)
      }
    })
    thread.setDaemon(true)
    thread.start()
    println("123")
  }
}

/*
1. setDaemon需要在start方法调用之前使用
2. 线程划分为用户线程和后台(daemon)进程，setDaemon将线程设置为后台进程
3. 如果jvm中都是后台进程，当前jvm将exit。（随之而来的，所有的一切烟消云散，包括后台线程啦）
4. 主线程结束后，
1） 用户线程将会继续运行
2） 如果没有用户线程，都是后台进程的话，那么jvm结束
另外：
setDaemon方法把java的线程设置为守护线程，此方法的调用必须在线程启动之前执行。只有在当前jvm中所有的线程都为守护线程时，jvm才会退出。
如果创建的线程没有显示调用此方法，这默认为用户线程。
 */