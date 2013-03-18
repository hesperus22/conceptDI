package concept

import concept.di.hlist._
import concept.di.providers._

import language.implicitConversions

package object di {
  implicit def anyToQualifiable[T](obj: T) = new Qualifiable[T](obj)
  implicit def anyToFunc[H <: HList, T](obj: T) = { m: Module[H] => obj }

  implicit def additionToModule[H <: HList, T](ma: ModuleAddition[H, T]): Module[Lazy[T] :: H] = ma.as(lazy_)

  def eager[H <: HList, T] = EagerProvider.get[H, T]
  def lazy_[H <: HList, T] = LazyProvider.get[H, T]
  def prototype[H <: HList, T] = PrototypeProvider.get[H, T]

  def qualifyBy[Q] = new Qualifier[Q]

  def emptyModule = new Module[HNil](new HNil)
}