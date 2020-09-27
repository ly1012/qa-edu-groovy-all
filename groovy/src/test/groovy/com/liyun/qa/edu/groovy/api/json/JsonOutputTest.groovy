package com.liyun.qa.edu.groovy.api.json

import groovy.json.JsonOutput
import groovy.json.JsonSlurper
import spock.lang.Specification

import java.text.SimpleDateFormat

/**
 * JsonOutput.toJson
 * @author Li Yun
 * @date 2020/9/17 11:09
 */
class JsonOutputTest extends Specification{

    def "toJson 方法的时间问题"(){
        given: "一个 JSON 对象，time 字段的值为时间对象"
            def json = new JsonSlurper().parseText("{}")
            def format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")
            def date = format.parse("2020-09-17 12:30:45.547")
            json["time"] = date

        expect:
            json.toString() == "{time=Thu Sep 17 12:30:45 CST 2020}"
            //JsonOutput.toJson 方法在将对象转换文本时，date 值按照美国时区进行转换了，导致时间提前了8个小时
            JsonOutput.toJson(json) == '{"time":"2020-09-17T04:30:45+0000"}'
    }

}

