<template>
    <header>
        <nav>
            <ul>
                <li>
                    <router-link to="/create">등록</router-link>
                </li>
                <li>
                    <router-link to="/list">목록</router-link>
                </li>
            </ul>
        </nav>
    </header>
</template>

<script>
export default {
    name: 'AppHeader'
}
</script>

<style>

</style>