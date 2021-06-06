package msa.progressive.guide.clustering

import msa.progressive.guide.DistanceMatrix
import msa.progressive.guide.GuideTree

interface ClusteringAlgorithm {
    fun processRawTree(guideTree: GuideTree, distanceMatrix: DistanceMatrix)
}