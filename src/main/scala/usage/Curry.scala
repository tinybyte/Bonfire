package usage

/*
  Original artical for this: http://www.codecommit.com/blog/scala/function-currying-in-scala
  It turns out that the best rationale for using currying has to do with general and specialized functions.
  It would be nice to define a function for the general case,
  but allow users to specialize the function and then used the specialized version on different data sets.
  Take the following code as an exampl
*/

class Curry {
  def process[A](filter: A => Boolean)(list: List[A]): List[A] = {
    lazy val recurse = process[A](filter) _ //the underscore just tells the compiler to treat the suffixed value as a functional, rather than a method to be evaluated.

    list match {
      case head :: tail => if (filter(head)) {
        head :: recurse(tail)
      } else {
        recurse(tail)
      }

      case Nil => Nil
    }
  }

  val even = (a: Int) => a % 2 == 0
  val processEvens = process(even) _

  val numbersAsc = 1 :: 2 :: 3 :: 4 :: 5 :: Nil
  val numbersDesc = 5 :: 4 :: 3 :: 2 :: 1 :: Nil

  processEvens(numbersAsc) // [2, 4]
  processEvens(numbersDesc) // [4, 2]

}