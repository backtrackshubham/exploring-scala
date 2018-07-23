package com.blog.mapandflatmap

object CaseObject extends App {
  trait Message{
   val message: String
  }

  case class WhatsApp(what: Int, message: String = "Whatsapp") extends Message
  case class Messanger(mess: Float, message: String = "Like") extends Message
  case class Hike(hike: Boolean, message: String = "Jingle") extends Message


  def testMatchCase(obj: Message) = {
    obj match {
      case x : WhatsApp =>
        println(s"${x.message}, ${x.what}")
      case y: Messanger =>
        println(s"${y.message}, ${y.mess}")
      case z: Hike =>
        println(s"${z.message}, ${z.hike}")
    }


  }
  val list: List[Message] = List(WhatsApp(23), Messanger(23.45F), Hike(hike = false))

  list.foreach(testMatchCase)
}
