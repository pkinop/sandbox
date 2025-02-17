sealed trait List[+A]

case object Nil extends List[Nothing]

case class Cons[+A](head: A, tail: List[A]) extends List[A]

object List {
  def sum(ints: List[Int]): Int = ints match {
    case Nil => 0
    case Cons(x, xs) => x + sum(xs)
  }

  def product(ds: List[Double]): Double = ds match {
    case Nil => 1.0
    case Cons(0.0, _) => 0.0
    case Cons(x, xs) => x * product(xs)
  }

  def apply[A](as: A*): List[A] =
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))

  def drop[A](xs: List[A], n: Int): List[A] =
    if (n == 0) xs
    else xs match {
      case Cons(_, t) => drop(t, n - 1)
      case l => l
    }
}

val xs = List(1, 2, 3)
println(List.drop(xs, 2))  // => Cons(3, Nil)
println(List.drop(xs, 4))  // => Nil
println(List.drop(Nil, 1)) // => Nil

