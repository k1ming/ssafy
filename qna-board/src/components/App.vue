<template>
    <div>
        <nav-header></nav-header>
        <h2 class="text-center">메인페이지</h2>
        <router-view></router-view>
    </div>
</template>

<script>
    import NavHeader from '@/components/NavHeader.vue';

    export default{
        name:'App',
       components: {    
        NavHeader
      }
    }
</script>

<style>

</style>