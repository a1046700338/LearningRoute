# 路径
- [demo1](demo1.html)  
- [demo2](demo2.html)  
- [demo3](demo3.html)  
- [demo4](demo4.html)  
- [demo5](demo5.html)  
- [demo6](demo6.html)  
- [demo7](demo7.html)  
- [demo8](demo8.html)  
- [demo9](demo9.html)  
- [demo10](demo10.html)  
- [demo11](demo11.html)  
- [demo12](demo12.html)  
- [demo13](demo13.html)  
- [demo14](demo14.html)  
- [demo15](demo15.html)  
- [demo16](demo16.html)  
- [demo17](demo17.html)  
- [demo18](demo18.html)  
- [demo19](demo19.html)  
- [demo20](demo20.html)  
- [demo21](demo21.html)  
- [demo22](demo22.html)  
- [demo23](demo23.html)  
- [demo24](demo24.html)  
- [demo25](demo25.html)  
- [demo26](demo26.html)  
- [demo27](demo27.html)  
- [demo28](demo28.html)  
- [demo29](demo29.html)  
- [DOM操作练习](demo30.html)  
- [图片切换练习](demo31.html)  
- [选择练习](demo32.html)  
- [Dom增删改](demo33.html)  
- [Dom增删改2](demo34.html)  
- [Dom操作CSS](demo35.html)  
- [箭头函数](demo36.html)  

# 说明
re·从<b>零</b>开始的前端  
从demo12到demo36是js学习过程  
[导航网站](../navigation/index.html)

# ES6
> ECMAScript，是一种由Ecma国际(前身为欧洲计算机制造商协会,英文名称是European Computer Manufacturers Association)通过ECMA-262标准化的脚本程序设计语言。  

- 新特性
- 前端必学
- [兼容性](https://kangax.github.io/compat-table/es6/)

## 传统var声明变量会污染全局作用域，会存在变量提升
```js
//var v;
console.log(v)
var v = `你好`;
// -------------------------------
{
    var lookme = `看我`;
}
    console.log(lookme);//看我
```
## 块级作用域
* let，只在代码块里生效，不影响作用链，不能重复声明，不存在变量提升
```js
let a,b,c;
let d = 2;
let e = [];
let d = 3;//重复声明就会报错
{
    let f = `你好`;
}
    console.log(f);//undefined
// 不影响作用链
{
    let school = `四川大学`;
    function fun() {
        console.log(school);
    }
    fun();//四川大学
}
```
* const，用来声明常量，不能修改赋值
```js
const SCHOOL = 'aaa';//声明常量一定要赋初始值
const ARR = ['香蕉','苹果','荔枝'];
ARR.push('西瓜');//对于数组和对象的元素修改，不算做对常量的修改，不会报错
```

## 解构赋值
es6 允许按照一定模式从数组和对象中提取值，对变量进行赋值，这被称为解构赋值。  
```js
const F4 = ['小沈阳','宋小宝','刘能','赵四'];
let [xiao,song,liu,zhao] = F4;//let数组中的值对应F4中的值
```
```js
const zhao = {
    name = '赵本山';
    age = '不详';
    xiaopin:function(){
        console.log("演小品");
    }
};
let {name,age,xiaopin} = zhao;
console.log(name，age， xiaopin);
```

## 简化对象写法
```js
let name = '张三';
let change = function(){
    console.log('改变');
}
const school = {
    name,//name: name,
    change,
    fun(){
        console.log(name);
    }
}
```

## 箭头函数
不能作为构造函数实例化对象  
[demo36.html](demo36.html)  
this是静态的，this始终指向函数声明时所在作用域下的this的值。直接调用函数this是指向windows的。
```js
function getName(){
    console.log(this.name);
}
let getName2 = () => {
    console.log(this.name);
}
window.name = '王麻子';
const SCHOOL = {
    name: '李四'
}
getName();
getName2();
getName().call(SCHOOL);//李四
getName2().call(SCHOOL);//箭头函数还是指向的全局this
```
## rest参数 
用来获取函数的实参，代替argumens
```js
function data(...args){
    console.log(args);
}
```

## 扩展运算符
... 扩展运算符  
扩展运算符能将 数组 转换为逗号分隔的 参数序列  

```js
const tfboys = ['易烊千玺','王俊凯','王源'];
function biaoyan(){
    console.log(arguments);
}
biaoyan(...tfboys);
```

```js
//1.数组的合并
const kuaizi = ['肖央','王太利'];
const fenghuang = ['曾毅','玲花'];
//const zuixuanxiaopingguo = kuaizi.concat(fenghuang);
const zuixuanxiaopingguo = [...kuaizi,...fenghuang];
console.log(zuixuanxiaopingguo);//['肖央','王太利','曾毅','玲花'];
```

```js
//2.数组的克隆
const sanzhihua = ['E','S','O'];
const eso = [...sanzhihua];//浅拷贝
console.log(eso);//['E','S','O']
```
3.可以将伪数组转换成真正的数组
## Symbol
表示独一无二的值，唯一性，内部的，不能参与运算  
js语言的第七种数据类型,  
六种数据类型：
```
    USONB
			 * 数据类型
			 * 在js中一共有六种数据类型:
			 * String 字符串
			 * Number 数值
			 * Boolean 布尔值
			 * Null 空值
			 * Undefined	未定义
			 * Object 对象
			 * 
			 * 其中String number boolean null undefined属于基本类型
			 * Object属于引用数据类型

```

```js
//创建Symbol
let s = Symbol();
let s2 = Symbol('尚硅谷');
let s3 = Symbol('尚硅谷');
console.log(s2 === s3);//false

```

Symbol 创建对象属性
```js
        let youxi = {
            name: '狼人杀',
            [Symbol('say')]:function(){
                console.log('我可以发言')
            },
            [Symbol('zibao')]:function(){
                console.log('我可以自爆')
            }
        }
        console.log(youxi);
```
```js
const arr1 = [1,2,3];
const arr2 = [4,5,6];
arr2[Symbol.isConcatSpreadable] = false;//用来控制是否可以展开
```
扩展对象功能

## 迭代器
Iterator 是一种接口，为不同的数据结构提供统一的访问机制  
ES6 创造了一种新的遍历命令 for...of 循环，Iterator接口主要供 for...of 消费。  
原生具备Iterator接口的数据：
* Array
* Arguments
* Set
* Map
* String
* TypedArray
* NodeList

```js
//使用 for...of 循环里面保存的是键值
const ARR = ['打发掉','大多数的','达达'];
for(let v of ARR){
    console.log(v);
}
```

```js
const ARR = ['打发掉','大多数的','达达'];
let iterators = ARR[Symbol.iterator]();
console.log(iterators.next());
console.log(iterators.next());
console.log(iterators.next());
console.log(iterators.next());//返回 value ， done 属性的对象
```

## 生成器
生成器函数是ES6提供的一种异步编程解决方案  
```js
function * gen(){
    // console.log("hello iterator")
    yield '一只没有耳朵';
    yield '一只没有尾巴';
    yield '真奇怪';//yield关键字，函数代码的分隔符
}
let iterator = gen();
iterator.next();
```

[生成器函数实例](demo38.html)  
