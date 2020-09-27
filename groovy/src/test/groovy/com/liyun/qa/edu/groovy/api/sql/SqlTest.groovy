package com.liyun.qa.edu.groovy.api.sql

import com.liyun.qa.edu.groovy.sensitive.SensitiveData
import groovy.sql.Sql
import org.junit.BeforeClass
import spock.lang.Specification


/**
 * {@link groovy.sql.Sql} API 用法
 * @author Li Yun
 * @date 2020/9/17 9:24
 */
class SqlTest extends Specification{

    def Sql sql
    def db

    @BeforeClass
    def setup(){
        def ip = "127.0.0.1"
        def port = "3306"
        def dbname = "information_schema"
        def user = "root"
        def password = SensitiveData.LOCAL_MYSQL_ROOT_PASSWORD
        db = [
                url:"jdbc:mysql://$ip:$port/$dbname?serverTimezone=Asia/Shanghai",
                user:"$user",
                password:"$password",
                driver:'com.mysql.cj.jdbc.Driver'
        ]
    }

    def "连接数据库"(){
        when:
            sql = Sql.newInstance(db.url, db.user, db.password, db.driver)

        then:
            sql.close()
    }

    def "查询数据库"(){
        when: "连接数据库成功"
            sql = Sql.newInstance(db.url, db.user, db.password, db.driver)

        then: "执行一条查询 SQL"
            //Now try a query using rows:
            def rows = sql.rows("select * from `TABLES` limit 1,3")
            println(rows.join('\n'))
            sql.close()

        expect: "查询结果有 3 行"
            rows.size() == 3
    }

}
