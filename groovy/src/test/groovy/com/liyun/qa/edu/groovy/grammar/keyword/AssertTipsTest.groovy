/**
 * assert 关键字，使用提示信息
 * @author Li Yun
 * @date 2020/9/17 10:09
 */

//	You can give some tips in error log as shown in this example.
//	In fact, we use ternary operator to give our tips.
//	It should be written as
//	    '''
//	        assert actual == expected ? "if sucess return this string" : "if fail retrun this string"
//	    '''
//	in full statement.

def actual = 1
def expected = 3
assert actual == expected : "Here are some tips."

//a another way to give tips
//assert actual == expected , "Here are some tips."

//	Output =>
//   java.lang.AssertionError: Here are some tips.. Expression: (actual == expected). Values: actual = 1, expected = 3
