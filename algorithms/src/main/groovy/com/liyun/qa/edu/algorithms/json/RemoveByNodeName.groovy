package com.liyun.qa.edu.algorithms.json
/**
 * 移除 JSON 中所有名称为 NodeName 的节点
 *
 * 参考资料：https://stackoverflow.com/a/44066427/8589807
 *
 * @author Li Yun
 * @date 2020/9/17 10:48
 */
class RemoveByNodeName{

    def static removeAttr(node, attr){
        if(node instanceof Map){
            node.remove(attr)
            node.each{ k,v-> removeAttr(v, attr) }
        }else if(node instanceof List){
            node.each{ i-> removeAttr(i, attr) }
        }
    }

}
