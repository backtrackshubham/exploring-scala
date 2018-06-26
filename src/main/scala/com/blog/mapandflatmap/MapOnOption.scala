package com.blog.mapandflatmap

object MapOnOption {
  val option: Option[Int] = Some(23)
  val optionList: List[Option[String]] = List(Some("Shubham"), None, Some("Bob"), Some("raja"), Some("yash"))

  val mapRes: Option[Int] = option.map(_ * 3)
  val mapResOnListOfOption: List[Option[String]] = optionList.map(_.map(_.toLowerCase))
  val somRes = optionList.map(option =>
    option.map(OptionTasks.optionTask))
  println(s"printing map res on option after transformation mapRes: $mapRes")
  println(s"printing map res on list of option after transformation mapResOnListOfOption: $mapResOnListOfOption")
}

object OptionTasks{
  def optionTask(x: String): Option[Int] = {
    if (x.length % 2 == 0) Some(x.length) else  None
  }
}

object ApplicationOption extends App{
  println(MapOnOption.somRes)
}
