<template>
    <div>
        삭제중...
      </div>
</template>

<script>
import axios from 'axios';
export default {
    name:'Delete',
    created() {
    // const params = new URL(document.location).searchParams;
    axios.delete(`http://localhost:9999/happyhouse/api/qna/${this.$route.params.no}`).then(({ data }) => {
      let msg = '삭제 처리시 문제가 발생했습니다.';
      if (data === 'success') {
        msg = '삭제가 완료되었습니다.';
      }
      alert(msg);
      this.$router.push('/qna');
    });
  },
}
</script>

<style>

</style>