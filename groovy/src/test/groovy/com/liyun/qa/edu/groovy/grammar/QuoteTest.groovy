package com.liyun.qa.edu.groovy.grammar

import groovy.json.JsonSlurper
import spock.lang.Narrative
import spock.lang.Specification

/**
 * 引号
 *
 * 引号交叉可用：相同的引号需要转义，不同的引号不需要。比如，单引号内双引号不用转义。
 * 单引号：不支持插值表达式。
 * 双引号：支持插值表达式，格式：$var 或 ${var}。
 * 三个单/双引号：支持换行，内容中单引号/双引号都不需要转义。
 *
 * @author Li Yun
 * @date 2020/9/16 23:30
 */
@Narrative("""测试引号的各种使用语法""")
class QuoteTest extends Specification{

    def "单引号"(){
        given:
            def person = "tom"
            def actual = '$person'
            //交叉可用：单引号内，单引号需要转义，双引号不需要。
            def quote = 'He said: "I\'m yun."'
            println(quote)

        expect:
            //单引号不支持插值表达式
            actual == '$person'
    }

    def "单引号（3个）"(){
        given:
            //支持换行书写
            //三个单引号内，如果有单/双引号，都不需要转义
            def multiline = '''
                {
                    "Java":"JAVA",
                    "Groovy":"GROOVY",
                    "Python":"PYTHON",
                    "quote": "I'm"
                }
            '''
            def json = new JsonSlurper().parseText(multiline)   //解析为 JSON 对象

        expect:
            json.Java == "JAVA"
    }

    def "双引号"(){
        given:
            def you = "{'james':'詹姆斯','tom':'汤姆'}"
            def me = "云"
            //双引号支持插值表达式
            def quote2 = "{'you':${you},'me':'${me}','her':'她'}"
            //交叉可用：双引号内，双引号需要转义，单引号不需要。
            def quote = "He said: \"I'm yun.\""
            println(quote)

        expect:
            quote2 == "{'you':{'james':'詹姆斯','tom':'汤姆'},'me':'云','her':'她'}"
    }

    def "双引号（3个）"(){
        given:
            //支持换行书写
            def var = "JAVA"
            //三个双引号内，如果有单/双引号，都不需要转义
            def multiline = """
                    {
                        "Java":"$var",
                        "Groovy":"GROOVY",
                        "Python":"PYTHON",
                        "quote": "I'm"
                    }
                """
            def json = new JsonSlurper().parseText(multiline)   //解析为 JSON 对象

        expect:
            json.Java == "JAVA"
    }

}
