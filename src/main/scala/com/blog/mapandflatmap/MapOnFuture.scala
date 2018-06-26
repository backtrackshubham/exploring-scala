package com.blog.mapandflatmap

import scala.concurrent.{Await, Future}
import scala.concurrent.duration.DurationInt

import scala.concurrent.ExecutionContext.Implicits.global

/**
  * May either run test case in package test
  * FutureSpec.scala Or can also see the output
  * on console using below object
  */
object Application extends App {
 val result = FutureRunningTasks.futureTask/*.map(x => x.map(_ / 2))*/
//  Thread.sleep(2000)
  println("now I will wait")
  //commenting the below
  println(Await.result(result, 5.second))

  println("I was waiting")
}

object FutureRunningTasks{
  val list = (1 to 20).toList
  def futureTask: Future[List[Int]] = Future {
    Thread.sleep(1234)
    list.map(_ * 2)
  }
}
