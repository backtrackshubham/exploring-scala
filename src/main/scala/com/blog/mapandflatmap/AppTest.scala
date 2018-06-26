package com.blog.mapandflatmap

import scala.concurrent.Future
import scala.util.Success
import scala.concurrent.ExecutionContext.Implicits.global

object AppTest extends App{
  val x: Future[Int] = Future{
    Thread.sleep(5000)
    67
  }


  x.onComplete{
    case Success(value) => println(s"future completed and i did not blocked the \n " +
      s"println() after me as in code it is after me as i am a call back and \n " +
      s"here is the value returned from future $value")
  }
  val result = x.map{value =>
    println(s"==============>$value")
    value * 4
  }

  println(result)
  println("Hi the future.onComplete() is above me")

  Thread.sleep(7000)
}
