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
      path: '/board/notice',
      redirect:"/notice/list"
    },
    {
      path: '/notice/list',
      name: 'list',
      component: List,
    },
    {
      path: '/notice/create',
      name: 'create',
      component: Create,
    },
    {
      path: '/notice/read',
      name: 'read',
      component: Read,
    },
    {
      path: '/notice/update',
      name: 'update',
      component: Update,
    },
    {
      path: '/notice/delete/:no',
      name: 'delete',
      component: Delete,
    },
  ],
});
