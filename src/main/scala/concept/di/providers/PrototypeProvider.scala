package concept.di.providers

import concept.di.hlist._
import concept.di._

trait Prototype[+T] extends Provider[T]

class PrototypeProvider[H <: HList, +T](val m: Module[H], val f: Module[H] => T) extends Prototype[T] {
  def obj = f(m)
}

object PrototypeProvider{
  def get[H <: HList, T] = new ProviderFactory[H, T] {
    type Out = Prototype[T]

    def apply(m: Module[H], f: Module[H] => T): Out = new PrototypeProvider(m, f)
  }
}