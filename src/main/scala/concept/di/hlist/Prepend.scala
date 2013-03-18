package concept.di.hlist

trait Prepend[P <: HList, S <: HList] {
  type Out <: HList
  def apply(prefix: P, suffix: S): Out
}

trait PrependAux[P <: HList, S <: HList, Out <: HList] {
  def apply(prefix: P, suffix: S): Out
}

trait LowPriorityPrepend {
  implicit def hnilPrepend1[S <: HList] = new Prepend[HNil, S] {
    type Out = S
    def apply(prefix: HNil, suffix: S) = suffix
  }
}

object Prepend extends LowPriorityPrepend {
  implicit def hnilPrepend2[P <: HList] = new Prepend[P, HNil] {
    type Out = P
    def apply(prefix: P, suffix: HNil) = prefix
  }

  implicit def prepend[P <: HList, S <: HList, Out0 <: HList](implicit prepend: PrependAux[P, S, Out0]) =
    new Prepend[P, S] {
      type Out = Out0
      def apply(prefix: P, suffix: S): Out = prepend(prefix, suffix)
    }
}

object PrependAux {
  implicit def hnilPrepend[S <: HList] = new PrependAux[HNil, S, S] {
    def apply(prefix: HNil, suffix: S): S = suffix
  }

  implicit def hlistPrepend[PH, PT <: HList, S <: HList, OutT <: HList](implicit pt: PrependAux[PT, S, OutT]) =
    new PrependAux[PH :: PT, S, PH :: OutT] {
      def apply(prefix: PH :: PT, suffix: S): PH :: OutT = new ::(prefix.head, pt(prefix.tail, suffix))
    }
}