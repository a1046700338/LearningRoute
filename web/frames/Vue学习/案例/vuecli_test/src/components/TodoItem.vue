<template>
  <div class="todo-item">
    <input
      type="checkbox"
      class="color-input"
      :checked="todos.done"
      @click="handleClick(todos.id)"
      @change="lineThrough"
    />
    <label ref="lineStatus">{{ todos.title }}</label>
    <button class="btn-danger" @click="handleDelete(todos.id)">x</button>
  </div>
</template>

<script>
export default {
  name: "TodoItem",
  // 声明接收 todo 对象
  props: ["todos"],
  methods: {
    // 判断勾选状态
    lineThrough() {
      if (this.todos.done) {
        this.$refs.lineStatus.style.textDecoration = 'line-through'
      }else{
        this.$refs.lineStatus.style.textDecoration = 'none'
      }
    },
    // 点击多选框 传送id
    handleClick(id) {
      // console.log(id)
      // this.checkTodo(id)
      this.$bus.$emit('checkTodo',id)
    },
    // 点击删除按钮 传送id
    handleDelete(id){
      if(confirm('确定删除吗？')){
        // this.deleteTodo(id)
        this.$bus.$emit('deleteTodo',id)
      }
    }
  },
};
</script>

<style scoped>
.todo-item {
  border: 0.5px solid rgb(209, 207, 207);
  border-radius: 6px;
  width: 495px;
  height: 20px;
  display: flex;
  justify-content: flex-start;
  align-items: center;
  padding: 4px;
}
.todo-item:hover{
  background-color: #ddd;
}
.todo-item:hover .btn-danger{
  display: block;
}
.todo-item label{
  flex: 1;
  text-align: left;
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
}
.btn-danger {
  display: none;
  background-color: rgb(229, 13, 13);
  border: 0.5px solid rgb(209, 207, 207);
  border-radius: 5px;
  padding: 5px;
  color: white;
  font-size: 2px;
  margin-right: auto;
  text-align: center;
  line-height: 0;
  height: 20px;
  width: 20px;
}
.btn-danger:hover {
  background-color: rgb(231, 68, 68);
  color: rgb(255, 245, 245);
  font: bolder;
}
</style>