import org.junit.Assert
import org.junit.Test
import util.similarity.DefaultSimilarityMatrices
import msa.alignment.SequenceAligner
import util.seq.Sequence
import util.seq.SequenceType

class UPGMATest {
    @Test
    fun testUPGMA() {
        println("UPGMA example test")

        val sequenceAligner = SequenceAligner(-1, DefaultSimilarityMatrices.BASIC_NUCLEOTIDE)

        // Define sequences
        val a = Sequence("TGCCTGGCGGCCGTAGCGCGGTGGTCCCACCTGACCCCATGCCGAACTCAGAAGTGAAACGCCGTAGCGCCGATGGTAGTGTGGGGTCTCCCCATGCGAGAGTAGGGAACTGCCAGGCAT", SequenceType.NUCLEOTIDE)
        val b = Sequence("TCTGGTGATGATGGCGAAGAGGTCACACCCGTTCCCATGCCGAACACGGAAGTTAAGCTCTTCAGCGCCG" +
                "ATGGTAGTCGGGGGTTTCCCCCTGTGAGAGTAGGACATCGCCAGGC", SequenceType.NUCLEOTIDE)
        val c = Sequence("TTACGGCGGCCACAGCGGCAGGGAAACGCCCGGTCCCATTCCGAACCCGGAAGCTAAGCCTGCCAGCGCC" +
                "GATGATACTGCCCCTCCGGGTGGAAAAGTAGGACACCGCCGAACA", SequenceType.NUCLEOTIDE)
        val d = Sequence("TGCTTGACGATCATAGAGCGTTGGAACCACCTGATCCCTTCCCGAACTCAGAAGTGAAACGACGCATCGC" +
                "CGATGGTAGTGTGGGGTCTCCCCATGTGAGAGTAGGTCATCGTCAAGCTC", SequenceType.NUCLEOTIDE)
        val e = Sequence("TGGCGACCATAGCGTTTTGGACCCACCTGATTTCCATGCCGAACTCAGAAGTGAAACGAAATAGCGCCGA" +
                "TGGTAGTGTGGGGCTTCCCCATGTGAGAGTAGGACATCGCCAGGCT", SequenceType.NUCLEOTIDE)

        val taxa: Array<Sequence> = arrayOf(a,b,c,d,e)
        // Calculate pairwise distance matrix
        var matrix: Array<Array<Double>> = Array(taxa.size) { Array(taxa.size) { 0.0 } }
        for(i in taxa.indices){
            for(j in taxa.indices){
                matrix[i][j] = sequenceAligner.alignAndDistance(taxa[i].sequence, taxa[j].sequence).toDouble()
            }
        }
        matrix.forEach { e ->
            e.forEach {
                print("$it, ")
            }
            println()
        }

        Assert.assertTrue(true)

    }
}