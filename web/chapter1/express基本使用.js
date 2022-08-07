// 引入express
const { request, response } = require('express');
const express = require('express');
// 创建应用对象
const app = express();
// 创建路由规则
app.get('/',(request,response)=>{
    response.send('Hello Express!');
});
app.listen(8000,()=>{
    console.log("服务已经启动,8000 端口监听中...");
})
