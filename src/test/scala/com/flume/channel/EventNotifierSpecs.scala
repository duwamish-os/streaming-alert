package com.flume.channel

import com.typesafe.config.ConfigFactory
import org.apache.flume.event.JSONEvent

/**
  * Created by prayagupd
  * on 1/13/17.
  */

class EventNotifierSpecs extends org.scalatest.FunSuite {

  test("sends slack message if matches the regex") {
    val eventNotifier = new EventNotifier(".*error.*", "#test-bytecode", ConfigFactory.load().getString("api.key"))

    val event = new JSONEvent
    event.setBody("{\"message\":\"error\"}".stripMargin.trim.getBytes())

    eventNotifier.intercept(event)
  }

  test("does not send slack message if event does not match the regex") {
    val eventNotifier = new EventNotifier(".*dreams.*", "#test-bytecode", ConfigFactory.load().getString("api.key"))

    val event = new JSONEvent
    event.setBody(
      """
        {
          "message" : "error"
        }
      """.stripMargin.getBytes())

    eventNotifier.intercept(event)
  }
}
