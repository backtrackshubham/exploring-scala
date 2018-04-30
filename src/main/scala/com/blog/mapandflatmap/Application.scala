package com.blog.mapandflatmap

object Application extends App {
  val list = (1 to 5).toList //List of integers

  val customMapsObject = CustomMaps[Int, Int](list) //Instantiating a CustomMaps Object

  val mapLambda = (x: Int) => x * 2 //A lambda for customMap method

  val addSubUnity = (x: Int) => List(x - 1, x + 1) //another a lambda for flatMap method

  //using custom map
  val mapResult = customMapsObject.customMap(mapLambda)

  //using custom flatMap
  val flatMapResult = customMapsObject.customFlatMap(addSubUnity)
  println("(===========> printing result of custom map ")
  println(mapResult)
  println("(===========> printing result of custom flatMap ")
  println(flatMapResult)

}
