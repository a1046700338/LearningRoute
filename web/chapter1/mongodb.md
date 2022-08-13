# MongoDB基础
[官方文档](https://www.mongodb.com/docs/manual/tutorial/getting-started/)  
本篇文章参考：[https://github.com/Vacricticy/mongodb_practice/](https://github.com/Vacricticy/mongodb_practice/)
## MongoDB简介
MongoDB（非关系型数据库，NoSQL，Not Only SQL）。  
MongoDB 是为了快速开发互联网web应用而设计的数据系统。  
MongoDB 的数据模型是面向文档的，所谓文档就是一种类似JSON的结构。  

```shell
mongod --dbpath 数据库路径 --port 端口号
```

## MongoDB指令
- `show dbs`或者`show databases`  查看数据库  
- `use <database>`    进入数据库  
- `db`    显示当前数据库   
- `show collections`    显示集合
- ``

## MongoDB数据库的CRUD操作
- `db.<collection>.insert(doc)`    向数据库集合中插入文档
    - 举例：向数据库中，stus集合插入一个新的学生对象  
    `db.stus.insert({name:"孙悟空",age:20,gender:"男"})`
- `db.<collection>.find()`  查询集合内数据
- `db.<collection>.update(condiction,newDocument)`  修改数据库集合内的对象数据
    - 1.修改对应的属性，需要用到修改操作符，比如$set,$unset,$push,$addToSet
    ```
    db.collectionName.update(
	    # 查询条件
	    {_id:222},
	    {
		    #修改对应的属性
		    $set:{ 
			    name:'kang2',
			    age:21
		    }
		    #删除对应的属性
		    $unset:{
			    gender:1 //这里的1可以随便改为其他的值，无影响
		    }
		
	    }
    )
    ```
    - 2.updateMany()可以用来更改匹配到的所有文档
    ```
    db.students.updateMany(
	    {name:'admin'},
	    {
		    $set:{
			    age:21,
			    gender:222
		    }
	    }
    )
    ```
    - 3.向数组中添加数据
    ```
    db.users.update({username:'xxx'},{$push:{"hobby.movies":'movie4'}})
    ```
    - 4.如果数据已经存在，则不会添加
    ```
    db.users.update({username:'xxx'},{$addToSet:{"hobby.movies":'movie4'}})
    ```


- `db.collectionName.remove()`  删除数据

    - remove默认会删除所有匹配的文档。相当于deleteMany()
    ```
        # 1.remove可以加第二个参数，表示只删除匹配到的第一个文档。此时相当于deleteOne()
        db.students.remove({name:'xxx',true})

        # 2. db.collectionName.deleteOne()
        # 3. db.collectionName.deleteMany()
        db.students.deleteOne({name:'xxx'})

        # 4. 删除所有数据：db.students.remove({})----性能较差，内部是在一条一条的删除文档。
        # 可直接通过**db.students.drop()**删除整个集合来提高效率。

        # 5.删除集合
        db.collection.drop()

        # 6.删除数据库
        db.dropDatabase()

        # 7.注意：删除某一个文档的属性，应该用update。  
        remove以及delete系列删除的是整个文档

        # 8.当删除的条件为内嵌的属性时：
        db.users.remove({"hobby.movies":'movie3'})
    ```

## 查询操作符的使用
比较操作符  
**$gt 大于**  
**$gte 大于等于**  
**$lt 小于**  
**$lte 小于等于**  
**$ne 不等于**  
**$eq 等于的另一种写法**  
```
db.users.find({num:{$gt:200}}) #查询num大于200
db.users.find({num:{$gt:200,$lt:300}}) #查询num大于200小于300
```

$or 或者
```
db.users.find(
    {
        $or:[
            {num:{$gt:300}},
            {num:{$lt:200}}
        ]
    }
)
#大于300或小于200
```

## 分页查询
```
db.users.find().skip(页码-1 * 每页显示的条数).limit(每页显示的条数)

db.users.find().limit(10) #前10条数据
db.users.find().skip(50).limit(10) #跳过前50条数据，即查询的是第61-70条数据，即第6页的数据

```

## 排序
```
db.emp.find().sort({sal:1}) #1表示升序排列，-1表示降序排列
db.emp.find().sort({sal:1,empno:-1}) #先按照sal升序排列，如果遇到相同的sal，则按empno降序排列
```

```
db.users.find().sort({sal:1}).skip(9 * 20).limit(10)
```

## 设置查询结果的投影，即只过滤出自己想要的字段
```
db.emp.find({},{ename:1,_id:0}) #在匹配到的文档中只显示ename字段
```

## mongoose
mongoose是nodejs中专门用于操作mongoDB数据库的js库。  
- 安装
    ```shell
    npm install mongoose
    ```
- 项目引入
    ```js
    var mongoose = require('mongoose');
    ```
- 连接数据库
    ```js
    mongoose.connect('mongodb://localhost/test'); #连接本地mongodb
    var db = mongoose.connection;
    db.on('error', console.error.bind(console, 'connection error:'));
    db.once('open', function() {
    // we're connected!
        console.log("连接成功");
    });
    // 绑定数据库连接失败事件
    db.once("close", function () {
    console.log("数据库连接已经断开");
    });
    // 断开数据库连接(一般不用)
    mongoose.disconnect();
    ```
