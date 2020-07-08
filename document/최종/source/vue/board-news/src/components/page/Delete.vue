<template>
    <div>
        삭제중...
    </div>
</template>

<script>
import axios from 'axios';
export default {
    name: 'Delete',
    data: function(){
      return{
        item: [],
        user: []
      }
    },
    created() {
    // login 처리 구현
    console.log(localStorage.getItem("userinfo"));
    this.user = JSON.parse(localStorage.getItem("userinfo"));
    console.log(this.user);

    
    axios.get(`http://localhost:9999/board/news/${this.$route.params.no}`)
    .then(({ data }) => {
      this.item = data;
        console.log(this.item);
    });

    if(this.item.newsMemno != this.user.no && this.user.type != 1){
      alert("접근 권한이 없습니다.");
      location.href = "list.html";
    }
    else{
      // const params = new URL(document.location).searchParams;
      axios.delete(`http://localhost:9999/board/news/${this.$route.params.no}`)
      .then(({ data }) => {
        let msg = '삭제 처리시 문제가 발생했습니다.';
        if (data === 'success') {
          msg = '삭제가 완료되었습니다.';
        }
        alert(msg);
        this.$router.push('/list');
      });
    }
  },
}
</script>

<style>

</style>