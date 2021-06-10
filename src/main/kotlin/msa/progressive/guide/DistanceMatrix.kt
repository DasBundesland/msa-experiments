package msa.progressive.guide

import msa.alignment.SequenceAligner
import util.seq.Sequence

class DistanceMatrix(val taxa: Array<GuideTreeNode<Sequence>>, val sequenceAligner: SequenceAligner) {
    var array: Array<DoubleArray> = Array(taxa.size){ i ->
        DoubleArray(taxa.size){ j ->
            if(taxa[i].data != null && taxa[j].data != null){
                sequenceAligner.alignAndDistance(taxa[i].data!!.sequence, taxa[j].data!!.sequence).toDouble()
            } else{
                0.0
            }
        }
    }


}