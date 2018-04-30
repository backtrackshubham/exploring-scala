package com.blog.mapandflatmap

case class CustomMaps[T, U](list: List[T]) {
  def customMap(f: T => U): List[U] = {
    val initialList = List.empty[U]

    def customMapHelper(in: List[T], out: List[U]): List[U] = {
      in match {
        case Nil => out
        case head :: Nil => f(head) :: out
        case head :: tail => customMapHelper(tail, f(head) :: out)
      }
    }
    customMapHelper(list, initialList) reverse
  }

  def customFlatMap(f: T => List[U]): List[U] = {
    val initialList = List.empty[U]
    def customFlatMapHelper(in: List[T], out: List[U]): List[U] = {
      in match {
        case Nil => out
        case head :: Nil => out ::: f(head)
        case head :: tail => customFlatMapHelper(tail, out ::: f(head))
      }
    }
    customFlatMapHelper(list, initialList)
  }
}
