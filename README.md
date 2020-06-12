最近做一个项目，规定的是用国密SM4来加密，以前从来没用过这个方法，百度了好多的文章，大多说的都是如何使用Java来实现SM4算法的，javascript的实现少之又少。

然后我找到了 `gm-crypt`这个插件，前端实现起来十分方便，但是我一运行我们后端给的代码，我人傻了，前端、后端加解密出来的结果不一样。

然后我就找到了这篇文章：

[SM4算法的ECB模式在java和js中的一些区别](https://blog.csdn.net/qq_37175367/article/details/101756240?utm_medium=distribute.pc_relevant.none-task-blog-baidujs-1 )

大概看懂了是怎么回事儿，觉得很有道理，但是一想，淦，我怎么自己改Java的算法啊，我是一个前端啊，于是我呼叫了场外援助，有请后端大佬帮忙，在网上总算是找到了一个和前端加解密结果一样的Java代码了。

[Java实现国密算法SM2,SM3,SM](https://blog.csdn.net/Soul_Programmer_Swh/article/details/80375958?utm_medium=distribute.pc_relevant.none-task-blog-baidujs-2 )

所以，来记录分享一下这个问题，面向CSDN编程的程序员真的太难了唉。