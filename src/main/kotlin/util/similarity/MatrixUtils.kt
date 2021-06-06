package util.similarity

class MatrixUtils {
    companion object{
        fun printDeepArray(arr: Array<IntArray>){
            var string = ""
            arr.forEach { ints ->
                ints.forEach { string += "$it, " }
                string += "\n"
            }
            println(string)
        }
    }
}