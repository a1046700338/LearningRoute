//引入 fs 模块
const fs = require('fs');

//实例化promis
const p = new Promise(function (resolve, reject) {
    //调用方法读取文件
    fs.readFile('web/res/苏轼.txt', (err, data) => {
        if (err) reject(err);
        resolve(data);
    });
});
p.then((value) => {
    console.log(value.toString());
}, (reason) => {
    console.log("读取失败，请检查文件路径是否正确");
});
