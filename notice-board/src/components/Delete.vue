<template>
    <div>
        삭제중....
    </div>
</template>

<script>
    import axios from 'axios';
    export default {
        name: 'Delete',
        created() {
            axios
                .delete(`http://localhost:9999/board/notice/${this.$route.params.no}`)
                .then(({data}) => {
                    let msg = '삭제 처리시 문제가 발생했습니다.';
                    if (data === 'success') {
                        msg = '삭제가 완료되었습니다.';
                    }
                    alert(msg);
                    this
                        .$router
                        .push('/notice/list');
                })
        }
    }
</script>

<style></style>