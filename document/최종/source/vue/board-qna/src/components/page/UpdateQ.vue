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
            <button class="btn btn-primary" @click="checkHandler">수정</button>
        </div>
    </div>
</template>

<script>
import axios from 'axios';
export default {
    name: 'UpdateQ',
    data: function () {
    return {
      qnaNo: '',
      qnaMemno: '',
      qnaTitle: '',
      qnaContent: '',
      user: []
    };
  },
  methods: {
    checkHandler() {
      let err = true;
      let msg = '';
      !this.qnaTitle && ((msg = '제목 입력해주세요'), (err = false), this.$refs.qnaTitle.focus());
      err && !this.qnaContent && ((msg = '내용 입력해주세요'), (err = false), this.$refs.qnaContent.focus());

      if (!err) alert(msg);
      else this.updateHandler();
    },
    updateHandler() {
      axios
        .put(`http://localhost:9999/board/qna/updateQ/${this.no}`, {
          qnaNo: this.qnaNo,
          qnaMemno: this.qnaMemno,
          qnaTitle: this.qnaTitle,
          qnaContent: this.qnaContent
        })
        .then(({ data }) => {
          let msg = '수정 처리시 문제가 발생했습니다.';
          if (data === 'success') {
            msg = '수정이 완료되었습니다.';
          }
          alert(msg);
          this.$router.push('/list');
        });
    },
  },
  created() {

    this.user = JSON.parse(localStorage.getItem("userinfo"));

    axios.get(`http://localhost:9999/board/qna/${this.$route.query.no}`).then(({ data }) => {
      this.qnaNo = data.qnaNo;
      this.qnaMemno = data.qnaMemno;
      this.qnaTitle = data.qnaTitle;
      this.qnaContent = data.qnaContent;
    });

    if(!(this.user && (this.user.no == this.qnaMemno || this.user.type == 1))){
      alert("접근 권한이 없습니다.");
      // 로그인창으로 이동
      location.href="/";
    }
  },
}
</script>

<style>

</style>