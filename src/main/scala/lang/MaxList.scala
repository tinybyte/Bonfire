package lang

class MaxList {
  def maxList[T <% Ordered[T]](elements:List[T]):T = elements match {
    case List() => throw new IllegalArgumentException("Empty Args")
    case List(x) => x
    case x::rest =>
      val maxRest = rest
      if(x > maxRest) x
      else maxList(maxRest)
  }
}