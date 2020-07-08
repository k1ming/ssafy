<template>
    <div>
        <div class="form-group">
            <label for="replyContent">내용</label>
            <textarea type="text" class="form-control" id="replyContent" ref="replyContent" placeholder="내용을 입력하세요" v-model="replyContent"></textarea>
        </div>
        <div class="text-right">
            <button class="btn btn-primary" @click="checkHandler">등록</button>
        </div>
    </div>
</template>

<script>
import axios from 'axios';
export default {
    name: 'CreateA',
    data: function () {
    return {
        replyMemno: '13',
        replyContent: '',
        user: []
    };
  },
  created(){
    this.user = JSON.parse(localStorage.getItem("userinfo"));
    if(!(this.user && this.user.type == 1)){
      alert("접근 권한이 없습니다.");
      // 로그인창으로 이동
      location.href = "/";
    }
  },
  methods: {
    checkHandler() {
      let err = true;
      let msg = '';
      !this.replyContent && ((msg = '내용 입력해주세요'), (err = false), this.$refs.replyContent.focus());

      if (!err) alert(msg);
      else this.createHandler();
    },
    createHandler() {
      axios
        .put(`http://localhost:9999/board/qna/writeA/${this.$route.query.no}`, {
            qnaNo: this.$route.query.no,
            replyMemno: this.replyMemno,
            replyContent: this.replyContent,
            reply: 1
        })
        .then(({ data }) => {
          let msg = '등록 처리시 문제가 발생했습니다.';
          if (data === 'success') {
            msg = '등록이 완료되었습니다.';
          }
          alert(msg);
          this.moveList();
        });
    },
    moveList() {
      this.$router.push('/list');
    }
  }
}
</script>

<style>

</style>