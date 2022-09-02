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
- **[vue-cli](#vue-cli)**
- **[vue-router](#vue-router)**
- **[vuex](#vuex)**
- **[vueUI组件库](#VueUI组件库)**
- **[vue3](#vue3)**

# Vue基础
vue 有许多语法糖，`:`是`v-on`的简写形式，在标签中给属性加上 冒号 vue 可解析为 js 表达式。
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

# vuex
vuex 是什么：专门在Vue中实现`集中式`状态管理的一个Vue插件，对Vue应用中多个组件的共享状态进行集中式管理（读/写），也是一种组件间的通信方式，且适用于任意组件间的通信。  
GitHub地址：https://github.com/vuejs/vuex   

什么时候使用 vuex ：  
1. 多个组件依赖同一个组件时
2. 来自不同组件的行为需要变更同一状态

生命周期...

使用 vuex，注意 vue2 只能安装 vuex@3版本，vue3 只能安装 vuex@4版本。
```js
npm i vuex@3
```

mapState,mapGetters,mapActions,mapMutations  

使用 mapState,mapGetters 映射 State 和 Getters，实现复用  
引入 mapState,mapGetters  
```js
import { mapState,mapGetters } from 'vuex'
```
在`计算属性中设置`
```js
    computed:{
        ...mapState(['sum']),
        ...mapGetters({demoSum:'demoSum'}) // 简写形式：...mapGetters(['demoSum'])
		// {key:'value'}
    },
```

使用 mapActions,mapMutations   
```js
import { mapActions,mapMutations } from 'vuex'
```
在 `methods`中设置  
```js
    methods:{
		...mapMutations({increment:'JIA',decrement:'DEC',...})  
		// {方法名,'Mutations里的名字'}
    },
```

命名空间 namespace  
```
namespaced: true
```
# vue-router
多个路由经过路由器的管理  
为了实现单页面应用（SPA）  
使用 vuex，注意 vue2 只能安装 vuerouter@3版本，vue3 只能安装 vuerouter@4版本。
```js
npm i vue-router@3
```
引入 vue-router  
```
import VueRouter from 'vue-router'
```
在 router/index.js 中的配置
```js
import Vue from 'vue'
import VueRouter from 'vue-router'
import HelloHi from '../components/HelloHi'

Vue.use(VueRouter)

export default new VueRouter({
	routes: [
		{
			path: '/',
			name: 'HelloHi'
			component: HelloHi
		}
	]
})
```
注意点：
- 路由组件一般存放在`pages`文件夹，非路由组件存放在`component`文件夹
- 通过切换路由组件，默认是被销毁掉的，需要的时候再挂载的
## 嵌套路由
```js
import Vue from 'vue'
import VueRouter from 'vue-router'
import HelloHi from '../pages/HelloHi'
import HomeHi from '../pages/HomeHi'
import NewSe from '../pages/NewSe'

Vue.use(VueRouter)

export default new VueRouter({
	routes: [
		{
			path: '/',
			name: 'HelloHi'
			component: HelloHi
		}，{
			path: '/home',
			name: 'Hone',
			component: HomeHi,
			children:[
				path: 'news',
				name: 'News',
				component: NewSe
			]
		}
	]
})
```
## 声明式路由导航
```html
<router-link class="xxx" to="/home">Home</router-link>
```
> active-class：router-link标签中的api，可以点击状态时更新样式

会将 router-link 解析成 a 标签  
https://router.vuejs.org/zh/guide/#html  

组件展示指定位置
```html
<router-view></router-view>
```

## 编程式路由导航
不借助`router-link`实现路由跳转就叫做编程式路由导航  
一些API：
```
this.$router.back()     //前进
this.$router.forward()	//后退
this.$router.go(number)	//可前进可后退，取决正数还是负数，number: 步数
```

## 缓存路由
作用：让不展示的路由保持挂载，不被销毁
```
<keep-alive include="缓存的组件名">
	<router-view></router-view>
</keep-alive>
```
缓存多个路由组件
```
<keep-alive include="['xxx','xxxx']">
	<router-view></router-view>
</keep-alive>
```
两个生命周期  
`activated`和`deactivated`

## 路由守卫


### 全局前置路由守卫

### 全局后置路由守卫


## history模式和hash模式
hash模式的路径不会请求服务器

在nodejs中解决history模式404的问题
```
connect-history-api-fallback
```

# VueUI组件库

移动端常用UI组件库：
- Vant
- Cube UI
- Mint UI

PC端常用UI组件库：
- [Element UI](https://element.eleme.cn)
- IView UI

npm 安装Element UI  
`npm i element-ui`  
`main.js`中的配置项
```js
// 引入vue
import Vue from 'vue'
// 引入elementui组件库
import ElementUI from 'element-ui';
// 引入elementui全部样式
import 'element-ui/lib/theme-chalk/index.css';
// 引入App组件
import App from './App.vue'

Vue.config.productionTip = false
//注册elementui组件库
Vue.use(ElementUI)

new Vue({
  render: h => h(App),
}).$mount('#app')

```
## 按需引入组件库 https://element.eleme.cn/#/zh-CN/component/quickstart#an-xu-yin-ru  

在`babel.config.js`文件中配置项
```js
  presets: [["@babel/preset-env", { "modules": false }]],
  plugins: [
    [
      "component",
      {
        "libraryName": "element-ui",
        "styleLibraryName": "theme-chalk"
      }
    ]
  ]
}

```

# vue3
