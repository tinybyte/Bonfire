import scala.xml._
import transform.{RuleTransformer, RewriteRule}

object AddAttribute extends {
  val foo = <a>Hello</a>

  val xmlTrans = new RewriteRule {
    override def transform(n: Node): NodeSeq = n match {
      case e: Elem if !(e \ "@href").isEmpty =>
      new Elem(e.prefix, e.label,
		  Attribute(None, "href", Text("/hello"), Null),
		  e.scope)
      case n => n
    }
  }

  println(new RuleTransformer(xmlTrans).transform(foo).toString)
}