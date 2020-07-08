<template>
    <div>
        <div class="form-group">
            <label for="qnaTitle">제목</label>
            <input type="text" class="form-control" id="qnaTitle" ref="qnaTitle" placeholder="제목을 입력하세요" v-model="qnaTitle">
        </div>
        <div class="form-group">
            <label for="qnaContent">내용</label>
            <textarea type="text" class="form-control" id="qnaContent" ref="qnaContent" placeholder="내용을 입력하세요" v-model="qnaContent"></textarea>
        </div>
        <div class="text-right">
            <button class="btn btn-primary" @click="checkHandler">등록</button>
            <button class="btn btn-primary" @click="moveList">목록</button>
        </div>
    </div>
</template>

<script>
import axios from 'axios';
export default {
    name: 'CreateQ',
    data: function () {
      return {
        qnaTitle: '',
        qnaContent: '',
        user: []
      };
    },
    created() {

      this.user = JSON.parse(localStorage.getItem("userinfo"));
      if(!this.user){
        alert("접근 권한이 없습니다.");
        // 로그인창으로 이동
        location.href = "/";
      }
      
    },
    methods: {
    checkHandler() {
      let err = true;
      let msg = '';
      !this.qnaTitle && ((msg = '제목 입력해주세요'), (err = false), this.$refs.qnaTitle.focus());
      err && !this.qnaContent && ((msg = '내용 입력해주세요'), (err = false), this.$refs.qnaContent.focus());

      if (!err) alert(msg);
      else this.createHandler();
    },
    createHandler() {
      axios
        .post('http://localhost:9999/board/qna', {
          qnaMemno: this.user.no,
          qnaTitle: this.qnaTitle,
          qnaContent: this.qnaContent
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
    },
  },
}
</script>

<style>

</style>