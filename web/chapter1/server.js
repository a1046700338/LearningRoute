const express = require('express');
const app = express();
app.all('/server',(request,response)=>{
    // 设置响应头 , * 设置允许跨域
    response.setHeader('Access-Control-Allow-Origin','*');
    response.setHeader('Access-Control-Allow-Headers','*');
    response.send("Hello AJAX");
});

app.all('/json-server',(request,response)=>{
    const data = {
        name:'ajax',
        age: 12,
    }
    let str = JSON.stringify(data);
    // 设置响应头 , * 设置允许跨域
    response.setHeader('Access-Control-Allow-Origin','*');
    response.setHeader('Access-Control-Allow-Headers','*');
    response.send(str);
});
app.all('/delay',(request,response)=>{
    const data = {
        name:'ajax',
        age: 12,
    }
    let str = JSON.stringify(data);
    // 设置响应头 , * 设置允许跨域
    response.setHeader('Access-Control-Allow-Origin','*');
    response.setHeader('Access-Control-Allow-Headers','*');
    response.send(str);
});
app.all('/jquery',(request,response)=>{
    // 设置响应头 , * 设置允许跨域
    response.setHeader('Access-Control-Allow-Origin','*');
    response.setHeader('Access-Control-Allow-Headers','*');
    response.setHeader('Access-Control-Allow-Method','*')
    response.send('hello jquery');
});
app.all('/check-user',(request,response)=>{
    const data = {
        exist : 1,
        msg : '用户名已经存在'
    }
    let str = JSON.stringify(data);
    response.send(`handle(${str})`);
});

app.listen(8000,()=>{
    console.log("服务已启动，8000 端口监听中...")
})