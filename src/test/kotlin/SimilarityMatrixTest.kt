import org.junit.Assert
import org.junit.Test
import util.similarity.DefaultSimilarityMatrices

class SimilarityMatrixTest {
    @Test
    fun testBLOSUM62(){
        Assert.assertEquals(DefaultSimilarityMatrices.BLOSUM62.get('A', 'A'), 4)
        Assert.assertEquals(DefaultSimilarityMatrices.BLOSUM62.get('Q', 'Z'), 3)
    }
}