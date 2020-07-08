import Vue from "vue";
import VueRouter from "vue-router";

import List from '@/components/page/List.vue';
import Read from '@/components/page/Read.vue';
import CreateQ from '@/components/page/CreateQ.vue';
import UpdateQ from '@/components/page/UpdateQ.vue';
import DeleteQ from '@/components/page/DeleteQ.vue';
import CreateA from '@/components/page/CreateA.vue';
import UpdateA from '@/components/page/UpdateA.vue';
import DeleteA from '@/components/page/DeleteA.vue';

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
      path: '/createQ',
      name: 'createQ',
      component: CreateQ
    },
    {
      path: '/updateQ',
      name: 'updateQ',
      component: UpdateQ
    },
    {
      path: '/deleteQ/:no',
      name: 'deleteQ',
      component: DeleteQ
    },
    {
      path: '/createA',
      name: 'createA',
      component: CreateA
    },
    {
      path: '/updateA',
      name: 'updateA',
      component: UpdateA
    },
    {
      path: '/deleteA/:no',
      name: 'deleteA',
      component: DeleteA
    }
  ]
});
