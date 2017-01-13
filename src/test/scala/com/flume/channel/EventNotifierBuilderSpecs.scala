package com.flume.channel

import org.apache.flume.Context
import org.scalatest.FunSuite

/**
  * Created by prayagupd
  * on 1/13/17.
  */
class EventNotifierBuilderSpecs extends FunSuite {

  val eventNotifierBuilder = new EventNotifierBuilder

  test("sets regex, to-channel") {
    val context = new Context
    context.put("regex", ".*error.*")
    context.put("toChannel", "to-channel")

    eventNotifierBuilder.configure(context)

    assert(eventNotifierBuilder.regex == ".*error.*")
    assert(eventNotifierBuilder.toChannel == "to-channel")
  }
}
