import Vue from "vue";
import VueRouter from "vue-router";
import List from '@/components/List.vue';
import Read from '@/components/Read.vue';
import Create from '@/components/Create.vue';
import Update from '@/components/Update.vue';
import Delete from '@/components/Delete.vue';

 
Vue.use(VueRouter);

export default new VueRouter({
  mode: 'history',
  routes: [
    {
      path: '/board/free',
      redirect:"/free/list"
    },
    {
      path: '/free/list',
      name: 'list',
      component: List,
    },
    {
      path: '/free/create',
      name: 'create',
      component: Create,
    },
    {
      path: '/free/read',
      name: 'read',
      component: Read,
    },
    {
      path: '/free/update',
      name: 'update',
      component: Update,
    },
    {
      path: '/free/delete/:no',
      name: 'delete',
      component: Delete,
    },
  ],
});
