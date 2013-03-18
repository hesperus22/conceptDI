package concept.di.hlist

import language.implicitConversions

sealed trait HList

final class ::[+H, +T <: HList](val head: H, val tail: T) extends HList
 
final class HNil extends HList
 
final class HListOps[L <: HList](val l: L) extends AnyVal{
  def ::[H](h: H): H :: L = new ::(h, l)
  def :::[P <: HList](prefix: P)(implicit prepend: Prepend[P, L]): prepend.Out = prepend(prefix, l)
}

object HList{
  implicit def hlistOps[L <: HList](l : L) : HListOps[L] = new HListOps(l)
}
