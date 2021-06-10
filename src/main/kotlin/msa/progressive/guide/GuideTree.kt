package msa.progressive.guide

import msa.alignment.SequenceAligner
import util.seq.Sequence

class GuideTree(val taxa: Array<GuideTreeNode<Sequence>>, private val sequenceAligner: SequenceAligner) {
    var distanceMatrix: DistanceMatrix = DistanceMatrix(taxa, sequenceAligner)
    val root: GuideTreeNode<Sequence> = GuideTreeNode("r", null,null, GuideTreeNodeType.ROOT)

    fun init(){

    }

    fun joinAndMerge(){

    }
}