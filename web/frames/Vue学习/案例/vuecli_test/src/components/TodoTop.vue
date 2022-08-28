<template>
  <div class="todo-top">
    <input type="text" placeholder="请输入你的任务名称，按回车键确认" v-model="title" @keyup.enter="add"/>
  </div>
</template>

<script>
import { nanoid } from 'nanoid'
export default {
  name: "TodoTop",
  data(){
    return {
      title: ''
    }
  },
  methods: {
    add() {
      if(!this.title.trim()){return alert('输入信息不能为空！')}
      var todoObj = {id: nanoid(), title:this.title, done: false}
      // this.addTodo(todoObj)
      this.$emit('addTodo',todoObj)
      this.title = ''
    },
  },

};
</script>

<style scoped>
.todo-top {
  border: 0.5px solid rgb(209, 207, 207);
  border-radius: 6px;
}

.todo-top input {
  border: 0.5px solid rgb(209, 207, 207);
  border-radius: 6px;
  height: 20px;
  padding: 4px;
  width: 495px;
  border: none;
  outline: none;
}

.todo-top input:focus {
  border: 1px solid rgb(65, 140, 221);
  box-shadow: 0 0 15px #03a9f4;
}
</style>