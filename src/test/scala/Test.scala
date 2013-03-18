import concept.di._

object Test extends App {
  class T1
  class T2 extends T1
  class T3

  trait Q1
  trait Q2

  val l = emptyModule add 3.qualified[Q1] thenAdd (new T2).qualified[Q1] as eager thenAdd "sss"
  val i: Int = l.get[Int]
  val t1: T2 = l.get[T2]
  val t2: T2 = l.get[T1]
  val t3: T2 = l.getQualified[Q1]
  val i2: Int = l.getQualified[Q1, Int]
  //  val s = l.get[T3]
  //  val q = l.getQualified[Q2]
  //  val q2 = l.getQualified[Q1, String]

  def autoTest(i: Int, s: String) = println(s, i)

  val a = l.autowire((_: Int, _: String))
  val a2 = l.autowire(autoTest _)

  (1 to 21) foreach { i =>
    val l = (1 to i) map { "U" + _ }
    print("def autowire[R, ")
    print(l.map(_ + ":CS").mkString(", "))
    print("](f: (")
    print(l.mkString(", "))
    print(") =>R) = f(")
    print(l.map { "get[" + _ + "]" }.mkString(", "))
    println(")")
  }
}