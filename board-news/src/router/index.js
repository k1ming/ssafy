import Vue from "vue";
import VueRouter from "vue-router";

import List from "@/components/page/List.vue";
import Create from "@/components/page/Create.vue";
import Read from "@/components/page/Read.vue";
import Update from "@/components/page/Update.vue";
import Delete from "@/components/page/Delete.vue";

Vue.use(VueRouter);

export default new VueRouter({
  made: 'history',
  routes: [
    {
      path: '/',
      redirect: '/list'
    },
    {
      path: '/list',
      name: 'list',
      component: List
    },
    {
      path: '/read',
      name: 'read',
      component: Read
    },
    {
      path: '/create',
      name: 'create',
      component: Create
    },
    {
      path: '/update',
      name: 'update',
      component: Update
    },
    {
      path: '/delete/:no',
      name: 'delete',
      component: Delete
    }
  ]
});
