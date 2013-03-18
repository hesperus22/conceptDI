package concept.di

import concept.di.hlist._
import concept.di.selectors._
import concept.di.providers._

class Module[H <: HList](val list: H) {
  type CS[T] = CovariantSelector[H, T]

  def add[T](f: Module[H] => T) = new UnqualifiedModuleAddition(this, f)
  def thenAdd[T](f: Module[H] => T) = new UnqualifiedModuleAddition(this, f)
  def get[T](implicit selector: CovariantSelector[H, T]): selector.Out = selector(list)
  def getQualified[Q](implicit selector: QualifiedSelector[H, Q]): selector.Out = selector(list)
  def getQualified[Q, T](implicit selector: QualifiedSelector2[H, Q, T]): selector.Out = selector(list)

  def autowire[R, U1: CS](f: (U1) => R) = f(get[U1])
  def autowire[R, U1: CS, U2: CS](f: (U1, U2) => R) = f(get[U1], get[U2])
  def autowire[R, U1: CS, U2: CS, U3: CS](f: (U1, U2, U3) => R) = f(get[U1], get[U2], get[U3])
  def autowire[R, U1: CS, U2: CS, U3: CS, U4: CS](f: (U1, U2, U3, U4) => R) = f(get[U1], get[U2], get[U3], get[U4])
  def autowire[R, U1: CS, U2: CS, U3: CS, U4: CS, U5: CS](f: (U1, U2, U3, U4, U5) => R) = f(get[U1], get[U2], get[U3], get[U4], get[U5])
  def autowire[R, U1: CS, U2: CS, U3: CS, U4: CS, U5: CS, U6: CS](f: (U1, U2, U3, U4, U5, U6) => R) = f(get[U1], get[U2], get[U3], get[U4], get[U5], get[U6])
  def autowire[R, U1: CS, U2: CS, U3: CS, U4: CS, U5: CS, U6: CS, U7: CS](f: (U1, U2, U3, U4, U5, U6, U7) => R) = f(get[U1], get[U2], get[U3], get[U4], get[U5], get[U6], get[U7])
  def autowire[R, U1: CS, U2: CS, U3: CS, U4: CS, U5: CS, U6: CS, U7: CS, U8: CS](f: (U1, U2, U3, U4, U5, U6, U7, U8) => R) = f(get[U1], get[U2], get[U3], get[U4], get[U5], get[U6], get[U7], get[U8])
  def autowire[R, U1: CS, U2: CS, U3: CS, U4: CS, U5: CS, U6: CS, U7: CS, U8: CS, U9: CS](f: (U1, U2, U3, U4, U5, U6, U7, U8, U9) => R) = f(get[U1], get[U2], get[U3], get[U4], get[U5], get[U6], get[U7], get[U8], get[U9])
  def autowire[R, U1: CS, U2: CS, U3: CS, U4: CS, U5: CS, U6: CS, U7: CS, U8: CS, U9: CS, U10: CS](f: (U1, U2, U3, U4, U5, U6, U7, U8, U9, U10) => R) = f(get[U1], get[U2], get[U3], get[U4], get[U5], get[U6], get[U7], get[U8], get[U9], get[U10])
  def autowire[R, U1: CS, U2: CS, U3: CS, U4: CS, U5: CS, U6: CS, U7: CS, U8: CS, U9: CS, U10: CS, U11: CS](f: (U1, U2, U3, U4, U5, U6, U7, U8, U9, U10, U11) => R) = f(get[U1], get[U2], get[U3], get[U4], get[U5], get[U6], get[U7], get[U8], get[U9], get[U10], get[U11])
  def autowire[R, U1: CS, U2: CS, U3: CS, U4: CS, U5: CS, U6: CS, U7: CS, U8: CS, U9: CS, U10: CS, U11: CS, U12: CS](f: (U1, U2, U3, U4, U5, U6, U7, U8, U9, U10, U11, U12) => R) = f(get[U1], get[U2], get[U3], get[U4], get[U5], get[U6], get[U7], get[U8], get[U9], get[U10], get[U11], get[U12])
  def autowire[R, U1: CS, U2: CS, U3: CS, U4: CS, U5: CS, U6: CS, U7: CS, U8: CS, U9: CS, U10: CS, U11: CS, U12: CS, U13: CS](f: (U1, U2, U3, U4, U5, U6, U7, U8, U9, U10, U11, U12, U13) => R) = f(get[U1], get[U2], get[U3], get[U4], get[U5], get[U6], get[U7], get[U8], get[U9], get[U10], get[U11], get[U12], get[U13])
  def autowire[R, U1: CS, U2: CS, U3: CS, U4: CS, U5: CS, U6: CS, U7: CS, U8: CS, U9: CS, U10: CS, U11: CS, U12: CS, U13: CS, U14: CS](f: (U1, U2, U3, U4, U5, U6, U7, U8, U9, U10, U11, U12, U13, U14) => R) = f(get[U1], get[U2], get[U3], get[U4], get[U5], get[U6], get[U7], get[U8], get[U9], get[U10], get[U11], get[U12], get[U13], get[U14])
  def autowire[R, U1: CS, U2: CS, U3: CS, U4: CS, U5: CS, U6: CS, U7: CS, U8: CS, U9: CS, U10: CS, U11: CS, U12: CS, U13: CS, U14: CS, U15: CS](f: (U1, U2, U3, U4, U5, U6, U7, U8, U9, U10, U11, U12, U13, U14, U15) => R) = f(get[U1], get[U2], get[U3], get[U4], get[U5], get[U6], get[U7], get[U8], get[U9], get[U10], get[U11], get[U12], get[U13], get[U14], get[U15])
  def autowire[R, U1: CS, U2: CS, U3: CS, U4: CS, U5: CS, U6: CS, U7: CS, U8: CS, U9: CS, U10: CS, U11: CS, U12: CS, U13: CS, U14: CS, U15: CS, U16: CS](f: (U1, U2, U3, U4, U5, U6, U7, U8, U9, U10, U11, U12, U13, U14, U15, U16) => R) = f(get[U1], get[U2], get[U3], get[U4], get[U5], get[U6], get[U7], get[U8], get[U9], get[U10], get[U11], get[U12], get[U13], get[U14], get[U15], get[U16])
  def autowire[R, U1: CS, U2: CS, U3: CS, U4: CS, U5: CS, U6: CS, U7: CS, U8: CS, U9: CS, U10: CS, U11: CS, U12: CS, U13: CS, U14: CS, U15: CS, U16: CS, U17: CS](f: (U1, U2, U3, U4, U5, U6, U7, U8, U9, U10, U11, U12, U13, U14, U15, U16, U17) => R) = f(get[U1], get[U2], get[U3], get[U4], get[U5], get[U6], get[U7], get[U8], get[U9], get[U10], get[U11], get[U12], get[U13], get[U14], get[U15], get[U16], get[U17])
  def autowire[R, U1: CS, U2: CS, U3: CS, U4: CS, U5: CS, U6: CS, U7: CS, U8: CS, U9: CS, U10: CS, U11: CS, U12: CS, U13: CS, U14: CS, U15: CS, U16: CS, U17: CS, U18: CS](f: (U1, U2, U3, U4, U5, U6, U7, U8, U9, U10, U11, U12, U13, U14, U15, U16, U17, U18) => R) = f(get[U1], get[U2], get[U3], get[U4], get[U5], get[U6], get[U7], get[U8], get[U9], get[U10], get[U11], get[U12], get[U13], get[U14], get[U15], get[U16], get[U17], get[U18])
  def autowire[R, U1: CS, U2: CS, U3: CS, U4: CS, U5: CS, U6: CS, U7: CS, U8: CS, U9: CS, U10: CS, U11: CS, U12: CS, U13: CS, U14: CS, U15: CS, U16: CS, U17: CS, U18: CS, U19: CS](f: (U1, U2, U3, U4, U5, U6, U7, U8, U9, U10, U11, U12, U13, U14, U15, U16, U17, U18, U19) => R) = f(get[U1], get[U2], get[U3], get[U4], get[U5], get[U6], get[U7], get[U8], get[U9], get[U10], get[U11], get[U12], get[U13], get[U14], get[U15], get[U16], get[U17], get[U18], get[U19])
  def autowire[R, U1: CS, U2: CS, U3: CS, U4: CS, U5: CS, U6: CS, U7: CS, U8: CS, U9: CS, U10: CS, U11: CS, U12: CS, U13: CS, U14: CS, U15: CS, U16: CS, U17: CS, U18: CS, U19: CS, U20: CS](f: (U1, U2, U3, U4, U5, U6, U7, U8, U9, U10, U11, U12, U13, U14, U15, U16, U17, U18, U19, U20) => R) = f(get[U1], get[U2], get[U3], get[U4], get[U5], get[U6], get[U7], get[U8], get[U9], get[U10], get[U11], get[U12], get[U13], get[U14], get[U15], get[U16], get[U17], get[U18], get[U19], get[U20])
  def autowire[R, U1: CS, U2: CS, U3: CS, U4: CS, U5: CS, U6: CS, U7: CS, U8: CS, U9: CS, U10: CS, U11: CS, U12: CS, U13: CS, U14: CS, U15: CS, U16: CS, U17: CS, U18: CS, U19: CS, U20: CS, U21: CS](f: (U1, U2, U3, U4, U5, U6, U7, U8, U9, U10, U11, U12, U13, U14, U15, U16, U17, U18, U19, U20, U21) => R) = f(get[U1], get[U2], get[U3], get[U4], get[U5], get[U6], get[U7], get[U8], get[U9], get[U10], get[U11], get[U12], get[U13], get[U14], get[U15], get[U16], get[U17], get[U18], get[U19], get[U20], get[U21])

}

class UnqualifiedModuleAddition[H <: HList, T](override val m: Module[H], override val f: Module[H] => T)
  extends ModuleAddition[H, T](m, f) {
  def and[Q](q: Qualifier[Q]) = new ModuleAddition(m, f.andThen { _.qualified[Q] })
}

class ModuleAddition[H <: HList, T](val m: Module[H], val f: Module[H] => T) {
  def as(p: ProviderFactory[H, T]) = new Module[p.Out :: H](p(m, f) :: m.list)
}