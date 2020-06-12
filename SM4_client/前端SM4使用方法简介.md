# 前端SM4使用方法简介

## 安装依赖

```
yarn add gm-crypt
// or npm install
```

## 使用方法

```javascript
import SM4 from './SM4'
// json 为传入的需要加解密的参数
const data = new SM4(json).encryptEcb() // ecb加密方法
const data = new SM4(json).decryptEcb() // ecb解密方法
```

