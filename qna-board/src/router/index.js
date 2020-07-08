import Vue from "vue";
import VueRouter from "vue-router";

// import Index from '@/components/Index.vue';
import List from '@/components/List.vue';
import Create from '@/components/Create.vue';
import Read from '@/components/Read.vue';
import Update from '@/components/Update.vue';
import Delete from '@/components/Delete.vue';

Vue.use(VueRouter);

export default new VueRouter({
  mode: 'history',
  routes: [
    {
      path: '/',
      redirect:"/qna"
    },
    {
      path: '/qna',
      name: 'list',
      component: List,
    },
    {
      path: '/create',
      name: 'create',
      component: Create,
    },
    {
      path: '/read',
      name: 'read',
      component: Read,
    },
    {
      path: '/update',
      name: 'update',
      component: Update,
    },
    {
      path: '/delete/:no',
      name: 'delete',
      component: Delete,
    },
  ],
});