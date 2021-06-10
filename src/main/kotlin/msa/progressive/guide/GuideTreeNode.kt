package msa.progressive.guide

class GuideTreeNode<T>(val identifier: String,
                       val data: T?,
                       var parent: GuideTreeNode<T>?, val treeNodeType: GuideTreeNodeType) {
    var child1: GuideTreeNode<T>? = null
        set(value) {
            field = value
            if (value != null) {
                value.parent = this
            }
        }

    var child2: GuideTreeNode<T>? = null
        set(value) {field = value
            if (value != null) {
                value.parent = this
            }
        }

    fun isRoot(): Boolean{
        return (this.parent == null)
    }

    fun isAlignment(): Boolean{
        return (this.treeNodeType == GuideTreeNodeType.ALIGNMENT)
    }


}