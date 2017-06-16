package home

import scala.collection.mutable.ArrayBuffer
import scala.io.StdIn

object Exercise1 {
    def main(args: Array[String]): Unit = {
        val nor = StdIn.readLine.trim.toInt
        val queries = ArrayBuffer[(String, String, String)]()
        (1 to nor).foreach(_ => {
            val line1 = StdIn.readLine.trim
            val line2 = StdIn.readLine.trim
            val line3 = StdIn.readLine.trim
            queries += Tuple3(line1, line2, line3)
        })
        queries.foreach(solve(_))
    }

    def solve(query: (String, String, String)) {
        val s = ArrayBuffer[Cut]()
        var a = query._2 split "[ ]+"
        s ++= a.zipWithIndex.map(tuple2 => Cut("y", tuple2._2 + 1, tuple2._1.toInt))
        a = query._3 split "[ ]+"
        s ++= a.zipWithIndex.map(tuple2 => Cut("x", tuple2._2 + 1, tuple2._1.toInt))

        val solution = s.permutations.map(x => Solution(x)).minBy(sol => sol.cost)
        println(solution.cuts.map(x => x.direction + x.order).mkString(", ") + " " + (solution.cost % (10^9 + 7)))
    }
}

case class Cut(direction: String, order: Integer, cost: Integer)

case class Solution(cuts: ArrayBuffer[Cut]) {
    private var _cost: Option[Integer] = None

    def cost: Integer = {
        _cost match {
            case Some(c) => c
            case _ =>
                var ypieces = 1
                var xpieces = 1
                val _c = cuts.foldLeft(0)((b, cut) => cut match {
                    case Cut("y", _, c) =>
                        ypieces += 1
                        b + c * xpieces
                    case Cut(_, _, c) =>
                        xpieces += 1
                        b + c * ypieces
                })
                _cost = Some(_c)
                _c
        }
    }
}
