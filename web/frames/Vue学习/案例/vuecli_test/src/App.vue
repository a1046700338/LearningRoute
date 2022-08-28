<template>
  <div id="app">
    <div class="container">
      <h1>Todo</h1>
      <!-- 暂时用到的方法是层层传递组件 -->
      <!-- 回调函数都可以修改为自定义组件，逐渐向事件总线靠拢 -->
      <TodoTop @addTodo="addTodo" />
      <TodoList :todos="todos" :checkTodo="checkTodo" :deleteTodo="deleteTodo" />
      <TodoFooter :todos="todos" @checkTodoAll="checkTodoAll" @chearDoneAll="chearDoneAll" />
    </div>
  </div>
</template>

<script>
import TodoTop from "./components/TodoTop.vue";
import TodoList from "./components/TodoList.vue";
import TodoFooter from "./components/TodoFooter.vue";

export default {
  name: "App",
  components: {
    TodoTop,
    TodoList,
    TodoFooter,
  },
  data() {
    return {
      // todos 存放到浏览器本地存储
      todos: JSON.parse(localStorage.getItem('todos')) || []
    }
  },
  methods: {
    //添加一个todo
    addTodo(todoObj) {
      this.todos.unshift(todoObj)
    },
    //勾选todo or 取消todo
    checkTodo(id) {
      this.todos.forEach((todos) => {
        if (todos.id === id) {
          todos.done = !todos.done
        }
      })
    },
    //删除todo
    deleteTodo(id) {
      this.todos = this.todos.filter((todo) => {
        return todo.id !== id
      })
    },
    //全选 or 取消全选
    checkTodoAll(done) {
      this.todos.forEach((todo) => {
        todo.done = done
      })
    },
    //清楚已完成任务
    chearDoneAll() {
      this.todos = this.todos.filter((todo) => {
        return !todo.done
      })
    }
    // 判断勾选状态
  },
  watch: {
    todos: {
      // 开启深度监视
      deep: true,
      handler(value) {
        localStorage.setItem('todos', JSON.stringify(value))
      }
    }
  }
};
</script>

<style>
* {
  margin: 0px;
  padding: 0px;
}

#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}

.container {
  display: flex;
  justify-content: flex-start;
  flex-direction: column;
  align-items: flex-start;
  margin: 0 auto;
  padding: 10px;
  border: 0.5px solid rgb(209, 207, 207);
  border-radius: 8px;
  height: auto;
  width: 505px;
}
</style>
