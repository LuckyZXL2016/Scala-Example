package com.zxl.implic

/**
  * Created by ZXL on 2017/10/10.
  */
class Boy(val name: String, val faceValue: Int) extends Comparable[Boy] {
  override def compareTo(o: Boy): Int = {
    this.faceValue - o.faceValue
  }
}
