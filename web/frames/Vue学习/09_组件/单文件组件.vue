<template>
  <div class="demo">
    {{name}}
  </div>
  <button>点我呀</button>
</template>

<script>
export default {
    name: 'demo',
    data() {
        return {
            name: '你的名字',
        }
    },

}
</script>

<style>
    .demo{
        background-color: orange;
    }
</style>