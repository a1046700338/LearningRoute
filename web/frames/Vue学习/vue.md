# Vue
组件化开发  
把一个单页应用拆分成一个个单独的组件，在父级组件中写好各组件标签，整个应用就可以完成了。  
## component
注册一个全局组件，语法格式如下：
```js
Vue.component(tagName,options)
//tagName 组件名，options 配置选项
//注册后，可以使用以下方式调用组件
<tagName></tagName>
```
组件页面三要素：

- 模板结构
- 行为
- 样式

模板和实例一一对应

注意：Vue所管理的函数都不要使用箭头函数，否则this会指向全局window

vue2到vue3  
学习过渡： 前端小白-->熟练掌握vue2-->轻松玩转vue3  

# 目录
- **[vue基础](#Vue基础)**
- **[vue-cli]()**
- **[vue-router]()**
- **[vuex]()**
- **[element-ui]()**
- **[vue3]()**

# Vue基础
## 模板语法
## 内置指令
- v-bind:    绑定，可以简写成冒号
- v-model   双向绑定，支持data到value，value到data，但是一般只用于表单类元素
- v-on:xxx	事件绑定，冒号后，其中xxx是事件名，事件的回调需要配置在methods对象中
- v-show="false"	相当于display:none，布尔值
- v-if,v-else-if,v-else 隐藏元素，不为false时，元素都没有
- v-text 向其所在的节点中渲染文本内容
- v-html 
- v-cloak 常见应用于 骨架屏
- v-once 所在节点初次动态渲染后，就视为静态内容了。以后的数据改变不会引起 v-once 所在结构的更新
- v-pre 跳过其所在节点的编译过程

## 自定义指令
需要在实例中添加`directives`属性

## MVVM模型
	1. M：模型，data中的数据
	2. V：视图，模板代码
	3. VM：视图模型，Vue实例

- data中所有的属性都会出现在实例上，
- vm上所有的属性以及Vue原型的所有属性，在Vue模板中都可以直接使用。

## 事件处理
methods中配置的函数，都是Vue所管理的函数，this指向 实例 或 组件实例对象。  
`@click="demo1"` 无参  
`@click="demo2($event,xxx)` 有参，并且有`$event`  
### 事件修饰符
prevent：阻止默认事件，  
stop：阻止事件冒泡，  
once：事件只触发一次，  
capture：使用事件的捕获模式，  
self：只有event.target是当前操作元素时才触发，  
passive：事件的默认行为立即执行，无需等待事件回调  

### 键盘事件
...
## 计算属性
...
## 监视属性



跳过 课时25，

## 绑定样式

## 条件渲染
- v-show
- v-if,v-else-if,v-else
使用这些做条件渲染 会连结构都没有
```html
<!-- 连同h2标签元素也会消失 -->
<h2 v-if="false">欢迎</h2>
```
v-if 可以与 template 标签 一起使用，就可以避免出现 改变结构 的问题。  
```html
<template v-if="false">
	<h2>ss</h2>
	<h2>sss</h2>
</template>
<!-- 当页面渲染后。会脱掉 template 这层外套 -->
```
## 列表渲染
当 computed 和 watch 都能实现业务逻辑时，优先使用 computed。


## 生命周期

# Vue组件
传统方式编写应用，依赖关系混乱，不好管理，代码复用率不高。  

## VueComponent

# vue-cli
Vue 脚手架 ，官方提供的 Vue 标准化构建工具  
[文档](https://cli.vuejs.org/zh/)  


- 配置淘宝镜像
	`npm config set registry https://registry.npm.taobao.cn`
- 全局安装@vue/cli
	`npm install -g @vue/cli`
- 选择好目录，创建项目
	`vue create <project_name>`

- Vue 脚手架隐藏了webpack的具体配置，执行查看
	`vue inspect > output.js`
- VueCli 的具体配置需要在根目录下创建一个 `vue.config.js` 文件，[配置参考](https://cli.vuejs.org/zh/config/)

## ref属性
唯一标识自定义标签，提供对标签元素的dom操作
## props配置
## mixin

## scoped样式
让样式在局部生效，防止冲突
```vue
<template>...</template>
<script>...</script>
<style scoped>
...
</style>
```
