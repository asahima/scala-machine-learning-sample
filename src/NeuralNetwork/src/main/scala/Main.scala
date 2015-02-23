/**
 * Created by asahima on 2015/02/09.
 */

import breeze.linalg._
import breeze.numerics._
import jp.asahima.NeuralNetwork

object Main {
    def main(args: Array[String]): Unit = {
        val nn = NeuralNetwork(input = 2, hidden = 5, output = 1)
        val datas = DenseMatrix(
            (1.0, 0.0, 0.0),
            (1.0, 0.0, 1.0),
            (1.0, 1.0, 0.0),
            (1.0, 1.0, 1.0)
        )

        val outputs = DenseMatrix(
            (0.0),
            (1.0),
            (1.0),
            (0.0)
        )

        nn.train(inputs = datas.t, outputs = outputs.t, numItr = 2000)

        println(nn.test(DenseVector(1.0, 0.0, 0.0)))
        println(nn.test(DenseVector(1.0, 0.0, 1.0)))
        println(nn.test(DenseVector(1.0, 1.0, 0.0)))
        println(nn.test(DenseVector(1.0, 1.0, 1.0)))
    }
}
