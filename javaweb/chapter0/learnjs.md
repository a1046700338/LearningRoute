# JavaScript
## 内联式
```html
<head>
...
<script type="text/javascript">
		alert("弹窗");
		//document文档即网页
		document.write("Hello,World!");//向body中输出一个内容
		//向控制台输出一个内容
		console.log("看见我了吗？");
</script>
...
</head>

```

```html
<body>
	<!-- onclick属性，点击事件 -->
	<bottom onclick="alert('不要点我啊><')">点我点我</bottom>

</body>
```
> 虽然可以写在标签中，但是属于结构与行为耦合，不方便维护，不推荐使用

## 数据类型
```html
		<script type="text/javascript">
			/**
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
			 */
			
			/**
			 * String字符串，用引号引起来
			 */
			var str = "hello,js";
			console.log(str);
			/**
			 * 转义字符同python，java
			 */
			alert("str");//输出字符串
			alert(str);//输出变量
			/* alert函数，输出函数：网页弹对话窗 */
			
			var a = 123;
			
			a = "248";
			
			a = "369";
			
			alert("你好");
			//自上到下，按顺序执行
			console.log("我来了");
			//Number.MAX_VALUE 数值最大值，超过最大值会返回一个 Infinity
			/*Null类型的值只有一个，就是null，
			*null专门表示一个空的对象，所以typeof检查null值时返回的是object
			*/
		   Null null = null;
		   console.log(null);
		</script>
```

```js

```