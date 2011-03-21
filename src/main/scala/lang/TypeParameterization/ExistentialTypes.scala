/*
immutable collections are almost always covariant in their type parameters.
 An immutable.List[String] can equally well be treated as an immutable.
 List[Any] - all the operations are concerned with what values you can get out of the list,
 so can easily be widened to some supertype.
  However, a mutable.List is *not* covariant in its type parameter.
  You might be familiar with the problems that result from treating it as such from Java.
*/

package lang.TypeParameterization

trait Foo

class Bar[+T]  {
    def doStuff[T <: Foo](args:Array[T]) = {
       // do something
     }
    def doCoolStuff(args : Array[T forSome { type T <: Foo }]) = {  //narrows the scope of the type parameter
      // do something
    }

  // all violations of type soundness involved some re-assignable ﬁeld or array element
/*It turns out that as soon as a generic parameter
type appears as the type of a method parameter, the containing class or trait
may not be covariant in that type parameter.*/

}

/*examples of using lower bound to solve covarience type can't be in parameterized method. */
class Queue[+T] (private val leading: List[T],private val trailing: List[T] ) {
  def enqueue[U >: T](x: U) = new Queue[U](leading, x :: trailing)
}

class StrangeIntQueue extends Queue[Int] {
  override def enqueue(x: Int) = {
    println(math.sqrt(x))
    super.enqueue(x)
  }
}

//val x: Queue[Any] = new StrangeIntQueue
//x.enqueue("abc")