package msa.alignment

import util.similarity.SimilarityMatrix

class SequenceAligner(var gapPenalty: Int, var similarityMatrix: SimilarityMatrix) {

    fun align(one: String, two: String): String {
        val a = one.toUpperCase()
        val b = two.toUpperCase()
        // Compute lengths of a and b || compute traceback matrix

        val alength = a.length
        val blength = b.length
        // Compute F-matrix
        val F = Array(alength + 1) { IntArray(b.length + 1) }
        for (i in 0 until alength + 1) {
            F[i][0] = gapPenalty * i
        }
        for (j in 0 until blength + 1) {
            F[0][j] = gapPenalty * j
        }
        for (i in 1 until (alength + 1)) {
            for (j in 1 until (blength + 1)) {
                val match = F[i - 1][j - 1] + similarityMatrix.get(a[i - 1], b[j - 1])
                val delete = F[i - 1][j] + gapPenalty
                val insert = F[i][j - 1] + gapPenalty
                F[i][j] = maxOf(match, insert, delete)
            }
        }

        // Compute alignment with highest possible score || TRACEBACK
        var alignmentA = ""
        var alignmentB = ""

        var i = alength
        var j = blength

        while ((i > 0) || (j > 0)) {
            if ((i > 0) && (j > 0) && F[i][j] == F[i - 1][j - 1] + similarityMatrix.get(a[i - 1], b[j - 1])) {
                alignmentA += a[i - 1]
                alignmentB += b[j - 1]
                --i
                --j
            } else if ((i > 0) && F[i][j] == F[i - 1][j] + gapPenalty) {
                alignmentA += a[i - 1]
                alignmentB += "-"
                --i
            } else {
                alignmentA += "-"
                alignmentB += b[j - 1]
                --j
            }
        }

        return alignmentA.reversed() + "\n" + alignmentB.reversed()
    }

    fun distance(alignment: String): Int {
        /*println("Alignment")
        println(alignment)*/
        val one: String = alignment.split("\n")[0]
        val two: String = alignment.split("\n")[1]
        assert(one.length == two.length)
        var sum: Int = one.length
        for (i in one.indices) {
            sum -= if (one[i] == '-' || two[i] == '-') {
                gapPenalty
            } else {
                similarityMatrix.get(one[i], two[i])
            }
        }
        /*println("Score: $sum")
        println("-------------------")*/
        return sum
    }

    fun alignAndDistance(a: String, b: String): Int {
        return distance(align(a, b))
    }


}
