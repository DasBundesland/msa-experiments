package util.similarity

import util.similarity.SimilarityMatrix
import util.seq.SequenceType

data class FixedSimilarityMatrix(override var matrix: HashMap<Char, HashMap<Char, Int>>,
                                 override var sequenceType: SequenceType
) : SimilarityMatrix