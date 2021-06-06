package util.seq

class AlphabetUtils {

    companion object{
        val AMINO_ACIDS: CharArray = charArrayOf('A','R','N','D','C','Q','E','G','H','I','L','K','M','F','P','S','T','W','Y','V','B','Z','X','*')
        val NUCLEOTIDE_BASES: CharArray = charArrayOf('A', 'G', 'C', 'T', 'U', 'N')
        fun isValidProteinBase(char: Char): Boolean {
            return char in AMINO_ACIDS
        }

        fun isValidNucleotideBase(char: Char): Boolean {
            return char in NUCLEOTIDE_BASES
        }

        fun sequenceChars(sequenceType: SequenceType): CharArray{
            return if (sequenceType == SequenceType.NUCLEOTIDE) NUCLEOTIDE_BASES else AMINO_ACIDS
        }

        fun validator(sequenceType: SequenceType): (Char) -> Boolean{
            return if (sequenceType == SequenceType.NUCLEOTIDE) { char: Char -> isValidNucleotideBase(char) } else { char: Char -> isValidProteinBase(char) }
        }

    }
}