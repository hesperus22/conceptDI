package concept.di

class Qualified[Q, +T](val obj: T)

class Qualifier[Q]

class Qualifiable[T](val obj: T) {
  def qualified[Q] = new Qualified[Q, T](obj)
}