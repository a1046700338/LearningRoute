# 文件路径
```
*
|-----web
|        |-------chapter1
|        |              |------demo1.html
|        |-------chapterxxx
|                       |------demoxxx.html
|
|
|
|-----------------------------------------------------|


```
# 说明
- html文件
- xxx:number，表数字编号

# Vue
组件化开发  
把一个单页应用拆分成一个个单独的组件，在父级组件中写好各组件标签，整个应用就可以完成了。  


# 学习AJAX
[AJAX](ajax.html)  
特点：无刷新获取数据

ajax请求
`https://api.apiopen.top/api/getTime?a=100&b=50&c=1`  链接带参数请求  

## nodemon
[nodemon](https://nodemon.io/) 可以不用重启服务，修改就会刷新node服务，热部署  
安装nodemon，  
`npm install -g nodemon`

## ie缓存
在IE浏览器对AJAX有缓存，并不会像chrome浏览器那样实时刷新，解决办法  
`xhr.open('GET','http://127.0.0.1:8000/ie?t='+Date.now())`  
通过添加时间戳的方法，使每次请求都是一个新的url，ie就会呈现最新的资源。

## 手动取消请求
`xhr.abort();`

## 重复请求问题
[ajax4.html](ajax4.html)

## axios
基于promise的http库  
标签引入  
`<script src="https://cdn.bootcdn.net/ajax/libs/axios/0.27.2/axios.min.js"></script>`  
[国内cdn](https://www.bootcdn.cn/axios/)  

## 解决跨域问题
JSONP， JSONP是一个非官方的跨域解决方案，只支持get请求  

[CORS](https://developer.mozilla.org/zh-CN/docs/Web/HTTP/CORS#http_%E5%93%8D%E5%BA%94%E9%A6%96%E9%83%A8%E5%AD%97%E6%AE%B5)，CORS是官方的跨域解决方案，它的特点是不需要客户端做特殊的操作，完全在服务器中进行处理，支持get和post请求。  
`response.setHeader('Access-Control-Allow-Origin','*');`


# Express的简单使用
[js文件](express%E5%9F%BA%E6%9C%AC%E4%BD%BF%E7%94%A8.js)
初始化nodejs  
`npm init --yes`  
下载express框架
`npm i express`  
运行node服务
`node` + `文件路径`  
如：`node express基本使用.js`  
