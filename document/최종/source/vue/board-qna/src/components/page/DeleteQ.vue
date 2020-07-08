<template>
    <div>
        삭제중...
    </div>
</template>

<script>
import axios from 'axios';
export default {
  name: 'DeleteQ',
  data: function(){
    return{
      memno: "",
      user: []
    }
  },
  created() {

    this.user = JSON.parse(localStorage.getItem("userinfo"));

    axios.get(`http://localhost:9999/board/news/${this.$route.params.no}`)
    .then(({ data }) => {
        this.memno = data.qnaMemno;
        console.log(this.memno);
    });

    if(this.user && (this.user.no == this.memno || this.user.type == 1)){
      // const params = new URL(document.location).searchParams;
      axios.delete(`http://localhost:9999/board/qna/${this.$route.params.no}`)
      .then(({ data }) => {
        let msg = '삭제 처리시 문제가 발생했습니다.';
        if (data === 'success') {
          msg = '삭제가 완료되었습니다.';
        }
        alert(msg);
        this.$router.push('/list');
      });
    }
    else{
      alert("접근 권한이 없습니다.");
      // 로그인창으로 이동
      location.href="/";
    }

  }
}
</script>

<style>

</style>