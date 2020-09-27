package com.liyun.qa.edu.groovy.api.collection.list

import spock.lang.Specification


/**
 * List 用法
 * @author Li Yun
 * @date 2020/9/17 15:23
 */
class ArrayListTest extends Specification{

    def "添加元素"(){
        given: "一个列表"
            def list = new ArrayList()
            def map = new HashMap()
            map.put("key", "value")

        when: "添加一些元素"
            //正常写法
            list.add(map)
            list.add("one element")
            //简洁写法，等价于 list.add(element)
            list += "Third"
            list += 444

        then: "验证列表大小和内容"
            list.size() == 4
            list.get(2) == "Third"
            list.get(3) == 444
    }

}
