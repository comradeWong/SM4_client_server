/*
 * @Descripttion:
 * @version: SM4国密 加密算法实现
 * @Author: jooey wong
 * @Date: 2020-06-12 09:24:27
 * @LastEditors: jooey wong
 * @LastEditTime: 2020-06-12 14:59:17
 */
/**
 * @author: jooey wong
 * @description: sm4加密算法的实现
 * @param {}
 * @return:
 */
export default class SM4 {
  constructor(data) {
    // 传入的需要加解密的数据
    this.data = data
    // sm4 工具类实例
    this.SM4 = require('gm-crypt').sm4
    //配置sm4参数
    this.sm4Config = {
      // 这里这个key 前后端保持一致
      key: 'FFFAAA333666DDDB',
      // 加密的方式有两种，ecb和cbc两种，也是看后端如何定义的，不过要是cbc的话下面还要加一个iv的参数，ecb不用
      mode: 'ecb',
      // 默认 base64 也可是 text
      cipherType: 'text'
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
    const sm4 = new this.SM4(this.sm4Config)
    // 数据加密
    return sm4.encrypt(this.data)
  }
  decryptEcb() {
    const sm4 = new this.SM4(this.sm4Config)
    return sm4.decrypt(this.data)
  }
}
