<template>
  <div class="todo-list">
    <TodoItem 
    v-for="t in todos" 
    :key="t.id" 
    :todos="t"
    />
  </div>
</template>

<script>
import TodoItem from "./TodoItem.vue";
export default {
  name: "TodoList",
  components: { TodoItem },
  props: ['todos']
};
</script>

<style>
.todo-list {
  margin: 10px 0px 10px 0px;
}
</style>