package jp.asahima

import breeze.linalg._
import breeze.plot._

object Main extends App {
  val f = Figure()
  val p = f.subplot(0)

  // first: mu, second: sigma
  val g = breeze.stats.distributions.Gaussian(0, 1)

  val x = g.sample(100)
  val y = g.sample(100)

  p += plot(x, y, '.')

  p.xlabel = "x axis"
  p.ylabel = "y axis"
}
