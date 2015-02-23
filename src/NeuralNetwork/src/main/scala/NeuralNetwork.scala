package jp.asahima

/**
 * Created by asahima on 2015/02/09.
 */

import breeze.linalg._
import breeze.numerics.{sigmoid, tanh}

import scala.util.Random

class NeuralNetwork(input: Int, hidden: Int, output: Int) {

    val input_layer = input + 1
    val hidden_layer = hidden + 1
    val output_layer = output

    val weight1 = DenseMatrix.rand(hidden_layer, input_layer)
    val weight2 = DenseMatrix.rand(output_layer, hidden_layer)

    val learningLate = 0.2

    def train(inputs: DenseMatrix[Double], outputs: DenseMatrix[Double], numItr: Int): Unit = {
        (0 until numItr) foreach { i =>
            // setting
            var idx = Random.nextInt(inputs.cols)
            var input = inputs(::, idx)
            var output = outputs(::, idx)

            // feed forward
            val h = tanh(weight1 * input)
            val o = sigmoid(weight2 * h)

            // back propagation
            val outputLoss = NeuralNetwork.sigmoidDriv(o) :* (o - output)
            val hiddenLoss = NeuralNetwork.tanhDriv(h) :* (weight2.t * outputLoss)

            weight1 -= (hiddenLoss * input.t) :* 0.2
            weight2 -= (outputLoss * h.t) :* 0.2
        }
    }

    def test(input: DenseVector[Double]): DenseVector[Double] = {
        val h = tanh(weight1 * input)
        val o = sigmoid(weight2 * h)
        o
    }


}

object NeuralNetwork {
    def apply(input: Int, hidden: Int, output: Int) = {
        new NeuralNetwork(input, hidden, output)
    }

    def tanhDriv(x: DenseVector[Double]): DenseVector[Double] = {
        DenseVector.ones[Double](x.length) - (x :* x)
    }

    def sigmoidDriv(x: DenseVector[Double]): DenseVector[Double] = {
        x :* (DenseVector.ones[Double](x.length) - x)
    }
}
