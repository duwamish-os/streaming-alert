package com.flume.channel

import java.util
import java.util.regex.Pattern

import com.flyberrycapital.slack.SlackClient
import com.typesafe.config.ConfigFactory
import org.apache.flume.Event
import org.apache.flume.interceptor.Interceptor

import scala.collection.JavaConverters._

/**
  * Created by prayagupd
  * on 1/12/17.
  */

class EventNotifier(regex: String, toChannel: String) extends Interceptor {

  val config = ConfigFactory.load()
  val s = new SlackClient(config.getString("api.key"))

  override def initialize(): Unit = {}

  override def close(): Unit = {}

  override def intercept(event: Event): Event = {
    Pattern.matches(regex, new String(event.getBody)) match {
      case true => s.chat.postMessage(toChannel, new String(event.getBody))
      case _ => {}
    }
    event
  }

  override def intercept(events: util.List[Event]): util.List[Event] = events.asScala.map(intercept).asJava
}
