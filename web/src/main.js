import Vue from 'vue'
import App from './App.vue'
//在main.js里面全局引入element-ui，使用起来方便
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
// 全局通用的 css 文件
import './assets/global.css';
// 全局引入axios
import axios from "axios";





Vue.prototype.$axios=axios;// $axios：这是一个自定义的名称，你可以根据需要选择其他名称。通常，开发者使用 $ 前缀来表示它是一个附加到Vue实例上的属性或方法。

//设置后端服务器的全局地址
Vue.prototype.$httpUrl='http://localhost:9090'

//将element作为插件引入
Vue.use(ElementUI)

Vue.config.productionTip = false

new Vue({
  render: h => h(App),
}).$mount('#app')


