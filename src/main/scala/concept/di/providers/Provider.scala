package concept.di.providers

import concept.di.hlist._
import concept.di._

trait Provider[+T] {
  def obj: T
}

trait ProviderFactory[H <: HList, T] {
  type Out <: Provider[T]

  def apply(m: Module[H], f: Module[H] => T): Out
}