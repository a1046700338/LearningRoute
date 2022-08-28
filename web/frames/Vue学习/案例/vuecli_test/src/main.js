import Vue from 'vue'
import App from './App.vue'

Vue.config.productionTip = false

new Vue({
  render: h => h(App),
  beforeCreate(){
    // 在生命周期：数据绑定前，添加全局事件总线
    Vue.prototype.$bus = this
  }
}).$mount('#app')
