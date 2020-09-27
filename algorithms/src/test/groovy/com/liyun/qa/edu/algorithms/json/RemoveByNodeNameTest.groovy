package com.liyun.qa.edu.algorithms.json

import groovy.json.JsonSlurper
import spock.lang.Specification


/**
 * 移除 JSON 中所有名称为 NodeName 的节点
 *
 * 参考资料：https://stackoverflow.com/a/44066427/8589807
 *
 * @author Li Yun
 * @date 2020/9/17 10:48
 */
class RemoveByNodeNameTest extends Specification{

    def "remove node by node name"(){
        given:
            def origin = '''{
              "id" : 52906,
              "name1" : "559812 Company name1",
              "name2" : "559812 Company name2",
              "country" : "DE",
              "interests" : {
                "id" : 848675,
                "description" : false
              },
              "emails" : [ {
                "id" : 904881,
                "address" : "559812@gmail.com"
              } ]
            }
            '''
            def expect = '''
                {
                    "name1": "559812 Company name1",
                    "name2": "559812 Company name2",
                    "country": "DE",
                    "interests": {
                        "description": false
                    },
                    "emails": [
                        {
                            "address": "559812@gmail.com"
                        }
                    ]
                }
            '''

        when:
            def parser = new JsonSlurper()
            def actual = parser.parseText(origin);
            RemoveByNodeName.removeAttr(actual,"id")

        then:
            actual == parser.parseText(expect)

    }

}
