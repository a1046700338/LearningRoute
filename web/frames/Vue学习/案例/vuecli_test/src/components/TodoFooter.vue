<template>
  <div class="footer" v-show="allCount">
    <input type="checkbox" v-model="isAll"/>已完成{{already}}&nbsp;/&nbsp;全部{{allCount}}
    <button class="btn-danger" v-text="clearTip" @click="clearAll"></button>
  </div>
</template>

<script>
export default {
  name: "TodoFooter",
  props: ['todos','checkTodoAll','chearDoneAll'],
  data() {
    return {
      clearTip: '清除已完成任务',
    };
  },
  methods:{
    clearAll(){
      if(confirm('确定清除吗？')){
        this.chearDoneAll()
      }
    }
  },
  computed: {
    already(){
      let newList = this.todos.filter(item => item.done === true).length
      return newList
    },
    allCount() {
      return this.todos.length
    },
    isAll:{
      get(){
        return this.already === this.allCount && this.allCount > 0
      },
      set(value){
        this.checkTodoAll(value)
      }
    }
  }
};
</script>

<style>
.footer {
  text-align: center;
  width: 495px;
  height: 30px;
  display: flex;
  justify-content: flex-start;
  flex-wrap: wrap;
  align-items: center;
  padding: 4px;
}

.footer input {
  margin-right: 20px;
}

.btn-danger {
  background-color: rgb(229, 13, 13);
  border: 0.5px solid rgb(209, 207, 207);
  border-radius: 5px;
  padding: 5px;
  color: white;
  font-size: 2px;
  margin-left: 255px;
}

.btn-danger:hover {
  background-color: rgb(231, 68, 68);
  color: rgb(255, 245, 245);
  font: bolder;
}
</style>