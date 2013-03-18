package concept.di.providers

import concept.di.hlist._
import concept.di._

trait Eager[+T] extends Provider[T]

class EagerProvider[H <: HList, +T](val m: Module[H], val f: Module[H] => T) extends Eager[T] {
  val obj = f(m)
}

object EagerProvider{
  def get[H <: HList, T] = new ProviderFactory[H, T] {
    type Out = Eager[T]

    def apply(m: Module[H], f: Module[H] => T): Out = new EagerProvider(m, f)
  }
}