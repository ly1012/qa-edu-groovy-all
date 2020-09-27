package com.liyun.qa.edu.groovy.grammar

import spock.lang.Narrative
import spock.lang.Specification


/**
 * 字符串
 * @author Li Yun
 * @date 2020/9/16 23:48
 */
@Narrative("""字符串的各种使用语法""")
class StringTest extends Specification{

    def "切片"(){
        given:
            String sample = "0123456";

        expect:
            //第 5 个字符（索引为 4）
            sample[4] == "4"
            //倒数第一个字符
            sample[-1] == "6"
            //索引 1 到 2 之间的字符
            sample[1..2] == "12"
            //从索引 4 开始打印，并往回 2 个字符
            sample[4..2] == "432"

    }

}
