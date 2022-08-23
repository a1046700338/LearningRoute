# vuecli_test
这是一个TodoList案例  
初次使用`Vue-cli`开发，由于目前没有学习到 vuex ，暂时数据层层传递。
1. 组件化编码流程
    * 1).拆分静态组件：组件要按照功能拆分，命名不要与 html 元素冲突。
    * 2).实现动态组件：考虑好数据存放位置，数据时一个组件在用，还是多个组件。
    * 3).实现交互：从绑定事件开始，`@click`...。
2. props
3. v-model 绑定的值不能是props传过来的值，因为 props 是不可以修改的。
4. props 传过来的若是对象类型的值，修改对象中的属性时 Vue 不会报错，但不推荐这样做。
## 项目结构
```
*
|-----vuecli_test
|      |
|      |-------node_modules     依赖
|      |
|      |-------public
|      |          |-----favicon.ico     网站页签图标TodoTop.vue
|      |          |-----index.html      网站首页
|      |-------src
|      |        |------assets       资源文件夹
|      |        |------components   组件文件夹
|      |        |           |
|      |        |           |------TodoTop.vue      todolist的顶部组件
|      |        |           |------TodoList.vue     todolist的列表组件
|      |        |           |------TodoItem.vue     todolist的单项组件
|      |        |           |------TodoFooter.vue   todolist的底部组件
|      |        |
|      |        |------App.vue      父组件
|      |        |------main.js      入口文件
|      |
|      |-------.gitignore       git忽略文件
|      |
|      |-------babel.config.js      babel，ES6转ES5
|      |
|      |-------package.json         包管理文件
|      |
|      |-------package-lock.json        包版本锁定文件
|      |
|      |-------README.md        说明文件
|      |
|      |-------vue.config.js        vuecli配置文件
|
|------------------------------------------------------------------------------------|

```

## 初始化项目
```
npm install
```

### 运行服务
```
npm run serve
```

### 打包项目
```
npm run build
```

### 检查代码
```
npm run lint
```

### Customize configuration
See [Configuration Reference](https://cli.vuejs.org/config/).
