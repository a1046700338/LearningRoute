# 文件路径
```
*
|-----web
|        |-------chapter1
|        |              |------demo1.html
|        |-------chapterxxx
|        |              |------demoxxx.html
|        |-------css
|        |         |------demo1.css
|        |         |------demoxxx.css
|        |
|        |-------frames
|        |         |------xxx
|      	 |
|      	 |-------js
|        |
|        |-------package	bootstrap离线包
|        |
|        |-------ppt
|
|-----------------------------------------------------|


```
# 说明
- html文件
- xxx:number，表数字编号

Frames  
前端框架学习汇总

<hr/>


# Webpack
Webpack，是一种前端资源构建工具，一个静态模块打包器。  
Webpack不能处理非js和json的资源。
## 本地安装
```shell
npm install --save-dev webpack@<version>
```
version 推荐 v4，`v4.40.2`
## 打包
`webpack 路径1 -o 路径2 --mode=development`   会以 `路径1` 为入口文件开始打包，然后输出到 `路径2` 整体打包环境，开发环境  
```
--mode=development

mode : development,production

生产环境会压缩js代码
```


# Express的简单使用
[js文件](express%E5%9F%BA%E6%9C%AC%E4%BD%BF%E7%94%A8.js)
初始化nodejs  
`npm init --yes`  
下载express框架
`npm i express`  
运行node服务
`node` + `文件路径`  
如：`node express基本使用.js`  
