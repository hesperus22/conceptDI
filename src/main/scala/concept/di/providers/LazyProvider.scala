package concept.di.providers

import concept.di.hlist._
import concept.di._

trait Lazy[+T] extends Provider[T]

class LazyProvider[H <: HList, +T](val m: Module[H], val f: Module[H] => T) extends Lazy[T] {
  lazy val obj = f(m)
}

object LazyProvider{
  def get[H <: HList, T] = new ProviderFactory[H, T] {
    type Out = Lazy[T]

    def apply(m: Module[H], f: Module[H] => T): Out = new LazyProvider(m, f)
  }
}