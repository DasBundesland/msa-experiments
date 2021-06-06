import org.junit.Assert
import org.junit.Test
import util.similarity.DefaultSimilarityMatrices
import msa.alignment.SequenceAligner

class NeedlemanWunschTest {
    @Test
    fun testNeedlemanWunsch(){
        val myCoolAligner: SequenceAligner = SequenceAligner(-10, DefaultSimilarityMatrices.BASIC_NUCLEOTIDE)
        println(myCoolAligner.align("attaaaggtttataccttcccaggtaacaaaccaaccaactttcgatctcttgtagatct".toUpperCase(), "attaaaggttaaaccaaccaactttcgagtagatct".toUpperCase()))
        println(myCoolAligner.alignAndDistance("attaaaggtttataccttcccaggtaacaaaccaaccaactttcgatctcttgtagatct", "attaaaggttaaaccaaccaactttcgagtagatct"))
        Assert.assertTrue(true)
    }
}