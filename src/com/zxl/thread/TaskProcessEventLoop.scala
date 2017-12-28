package com.zxl.thread

/**
  * Created by ZXL on 2016/3/29.
  */
class TaskProcessEventLoop(name:String) extends EventLoop[TaskEvent](name){




  /*
  override protected def onReceive(event: TaskEvent): Unit = event match {
    case TaskSubmitted(name) => {
      println(name + " submitted")
    }

    case TaskSucceeded(name) => {
      println(name + " succeeded")
    }

    case TaskFailed(name) => {
      println(name + " filled")
    }
  }
  */



  /**
    * Invoked in the event thread when polling events from the event queue.
    *
    * Note: Should avoid calling blocking actions in `onReceive`, or the event thread will be blocked
    * and cannot process events in time. If you want to call some blocking actions, run them in
    * another thread.
    */
  override protected def onReceive: PartialFunction[TaskEvent, Unit] = {  //偏函数, 不同的任务作出不同的处理
    case TaskSubmitted(taskName) => println(taskName)
  }

  override protected def onError(e: Throwable): Unit = {

  }

  /**
    * Invoked when `start()` is called but before the event thread starts.
    */
  override protected def onStart(): Unit = {
    println("on start invoke")
  }
}
