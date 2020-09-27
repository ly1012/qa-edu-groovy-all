/**
 * assert 关键字
 * @author Li Yun
 * @date 2020/9/17 9:57
 */

def actual = "I am a poor man"
def expected = "I am a rich man"
assert actual == expected

//	In this case, you get error log that show some message for you.
//	1. The first one tell you the actual value, it's "I am a poor man".
//	2. The second one tell you the result were compared between the actual value and the expected value.
//	3. The third  one tell you the expected value, it's "I am a rich man".
//	So now we know the log show these messages in order from left to right.
//	You can get more information by visit the link "https://stackoverflow.com/a/13039605".

//Output =>
//Assertion failed:
//
//assert actual == expected
//        |      |  |
//        |      |  'I am a rich man'
//        |      false
//        'I am a poor man'