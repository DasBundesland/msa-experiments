package util.similarity

import util.seq.AlphabetUtils
import util.seq.SequenceType

/**
 * Similarity matrix interface
 */
interface SimilarityMatrix {
    var matrix: HashMap<Char, HashMap<Char, Int>>
    var sequenceType: SequenceType


    fun get(a: Char, b: Char): Int{
        val dummyChar: Char = if (this.sequenceType == SequenceType.NUCLEOTIDE) 'N' else '*'
        return if(AlphabetUtils.validator(this.sequenceType).invoke(a) && AlphabetUtils.validator(this.sequenceType).invoke(b)){
            if(matrix[a]?.get(b) != null) matrix[a]?.get(b)!! else matrix[dummyChar]?.get(dummyChar)!!
        } else{
            matrix[dummyChar]?.get(dummyChar)!!
        }
    }

    companion object{
        fun generateMapFromIntArray(intArray: Array<IntArray>, sequenceType: SequenceType): HashMap<Char, HashMap<Char, Int>>{
            val referenceArray: CharArray = AlphabetUtils.sequenceChars(sequenceType)
            assert(intArray.size == referenceArray.size)
            intArray.forEach { assert(it.size == referenceArray.size) }

            val fullMap: HashMap<Char, HashMap<Char, Int>> = HashMap()

            for(it in intArray.indices) {
                val array: IntArray = intArray[it]
                val rowMap: HashMap<Char, Int> = HashMap()

                for(index in array.indices){
                    rowMap[referenceArray[index]] = array[index]
                }
                fullMap[referenceArray[it]] = rowMap
            }

            return fullMap
        }
    }

}

typealias ValidationFunction = (Char) -> Int