import Vue from "vue";
import App from "@/components/App.vue";
import router from "./router";
import VueLocalStorage from 'vue-localstorage'

Vue.config.productionTip = false;
Vue.use(VueLocalStorage, {
  name: 'ls',
  bind: true //created computed members from your variable declarations
})

new Vue({
  router,
  render: h => h(App)
}).$mount("#app");
