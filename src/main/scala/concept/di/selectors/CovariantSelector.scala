package concept.di.selectors

import concept.di.hlist._
import concept.di._
import concept.di.providers._

trait CovariantSelector[-L <: HList, +U] {
  type Out <: U

  def apply(l: L): Out
}

trait LowestImportanceCovariantSelector {
  implicit def hlistSelect[H, T <: HList, U](implicit st: CovariantSelector[T, U]) = new CovariantSelector[H :: T, U] {
    type Out = st.Out

    def apply(l: H :: T) = st(l.tail)
  }
}

trait LowerImportanceCovariantSelector extends LowestImportanceCovariantSelector {
  implicit def hlistSelect2[H, T <: HList] = new CovariantSelector[Provider[Qualified[_, H]]:: T, H] {
    type Out = H

    def apply(l: Provider[Qualified[_, H]] :: T) = l.head.obj.obj
  }
}

object CovariantSelector extends LowerImportanceCovariantSelector {
  implicit def hlistSelect1[H, T <: HList] = new CovariantSelector[Provider[H]:: T, H] {
    type Out = H

    def apply(l: Provider[H] :: T) = l.head.obj
  }
}