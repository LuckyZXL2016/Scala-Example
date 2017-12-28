package com.zxl.thread

/**
  * Created by ZXL on 2016/3/29.
  */
trait TaskEvent

case class TaskSubmitted(name: String) extends TaskEvent

case class TaskSucceeded(name: String) extends TaskEvent

case class TaskFailed(name: String) extends TaskEvent
