/*
 * @Descripttion:
 * @version: SM4国密 加密算法实现
 * @Author: jooey wong
 * @Date: 2020-06-12 09:24:27
 * @LastEditors: jooey wong
 * @LastEditTime: 2020-06-12 14:56:39
 */
/**
 * @author: jooey wong
 * @description: sm4加密算法的实现
 * @param {}
 * @return:
 */
export default class SM4 {
  // 传入的需要加解密的数据
  data: any
  // sm4 工具类实例
  SM4: any
  //配置sm4参数
  sm4Config: {
    // 这里这个key值是跟后端要的
    key: any
    // 加密的方式有两种，ecb和cbc两种，也是看后端如何定义的，不过要是cbc的话下面还要加一个iv的参数，ecb不用
    mode: string
    //
    cipherType: string
  }
  constructor(data: any) {
    this.data = data
    this.SM4 = require('gm-crypt').sm4
    this.sm4Config = {
      //配置sm4参数
      key: 'FFFAAA333666DDDB', //这里这个key值是跟后端要的
      mode: 'ecb', // 加密的方式有两种，ecb和cbc两种，也是看后端如何定义的，不过要是cbc的话下面还要加一个iv的参数，ecb不用
      cipherType: 'text' //
    }
  }
  /**
   * @author: jooey wong
   * @description: 加密算法
   * @param
   * @return: void
   */
  encryptEcb() {
    console.log(this.sm4Config)
    //这里new一个函数，将上面的sm4Config作为参数传递进去。然后就可以开心的加密了
    let sm4 = new this.SM4(this.sm4Config)
    // 数据加密
    return sm4.encrypt('中国')
  }
  decryptEcb() {
    let sm4 = new this.SM4(this.sm4Config)
    return sm4.decrypt(
      'EUKMu2sNtvketCJdIafjK2ilg4QaScULfVwjE1Mh364a8ChXOfOci3ylbeIX6lCk0x2MizjrqhAQxsHu00lEuP6hlOktPRi1wIzIVVr1G4ROgeExZIJM+DR2rBvtwVEEjTBPy1pTXZyXaZ8AAL7bk1G5fMm+PUHiWY5oPHdXcHoyuWljfg6RYps95PferFFjk2wjROMjvDIBx0avZqZE04Nn2NQ7AqK32osL0m0NxB8J3fNaW1bIFMi3TfbIH8+mST8SD0dv7Qb79iSaaB0icZa1rLQi80UpKXsDdf82p/rjzB/flJn/7mH5tKpEcZ7mwf2c3ORytoY0kAEbUtldykYi+AzsKbGOBf15DJKWazJaXEMKM8WstYyoThdULzgqzK5j1qpcPaVUqZWkzR+W/hdSTbZFJHJFvJn0y7lN970='
    )
  }
}
