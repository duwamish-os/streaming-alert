package com.flume.channel

import org.apache.flume.Context
import org.apache.flume.interceptor.Interceptor

/**
  * Created by prayagupd
  * on 1/13/17.
  */

class EventNotifierBuilder extends Interceptor.Builder {

  var regex : String = ""
  var toChannel : String = ""
  var secretKey : String = ""

  override def build(): Interceptor = new EventNotifier(regex, toChannel, secretKey)

  override def configure(context: Context): Unit = {
    regex = context.getString("regex", ".*")
    toChannel = context.getString("toChannel")
  }
}
