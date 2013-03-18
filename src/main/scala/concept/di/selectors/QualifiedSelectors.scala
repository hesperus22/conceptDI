package concept.di.selectors

import concept.di.hlist._
import concept.di._
import concept.di.providers._

trait QualifiedSelector[-L <: HList, Q] {
  type Out

  def apply(l: L): Out
}

trait LowerImportanceQualifiedSelector {
  implicit def hlistSelect[H, T <: HList, U](implicit st: QualifiedSelector[T, U]) = new QualifiedSelector[H :: T, U] {
    type Out = st.Out

    def apply(l: H :: T) = st(l.tail)
  }
}

object QualifiedSelector extends LowerImportanceQualifiedSelector {
  implicit def hlistSelect1[H, T <: HList, Q] = new QualifiedSelector[Provider[Qualified[Q, H]]:: T, Q] {
    type Out = H

    def apply(l: Provider[Qualified[Q, H]] :: T) = l.head.obj.obj
  }
}

trait QualifiedSelector2[-L <: HList, Q, +T] {
  type Out

  def apply(l: L): Out
}

trait LowerImportanceQualifiedSelector2 {
  implicit def hlistSelect[H, T <: HList, U, U2](implicit st: QualifiedSelector2[T, U, U2]) = new QualifiedSelector2[H :: T, U, U2] {
    type Out = st.Out

    def apply(l: H :: T) = st(l.tail)
  }
}

object QualifiedSelector2 extends LowerImportanceQualifiedSelector2 {
  implicit def hlistSelect1[H, T <: HList, Q] = new QualifiedSelector2[Provider[Qualified[Q, H]]:: T, Q, H] {
    type Out = H

    def apply(l: Provider[Qualified[Q, H]] :: T) = l.head.obj.obj
  }
}