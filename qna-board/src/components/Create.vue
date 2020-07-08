<template>
   <div>
    <div class="form-group">
      <label for="writer">작성자</label>
      <input type="text" class="form-control" id="qnaWriter" ref="qnaWriter" placeholder="작성자를 입력하세요" v-model="qnaWriter">
    </div>
    <div class="form-group">
      <label for="title">질문제목</label>
      <input type="text" class="form-control" id="qnaTitle" ref="qnaTitle" placeholder="제목을 입력하세요" v-model="qnaTitle">
    </div>
    <div class="form-group">
      <label for="content">질문내용</label>
      <textarea type="text" class="form-control" id="qnaContent" ref="qnaContent" placeholder="내용을 입력하세요"
        v-model="qnaContent"></textarea>
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
    name:'Create',
    data: function () {
     return {
        no: '',
        regtime: '',
        qnaWriter: '',
        qnaTitle: '',
        qnaContent: '',
    };
  },
  methods: {
    checkHandler() {
      let err = true;
      let msg = '';
      !this.qnaWriter && ((msg = '작성자를 입력해주세요'), (err = false), this.$refs.qnaWriter.focus());
      err && !this.qnaTitle && ((msg = '제목 입력해주세요'), (err = false), this.$refs.qnaTitle.focus());
      err &&
        !this.qnaContent &&
        ((msg = '내용 입력해주세요'), (err = false), this.$refs.qnaContent.focus());

      if (!err) alert(msg);
      else this.createHandler();
    },
    createHandler() {
      axios
        .post('http://localhost:9999/happyhouse/api/qna', {
          qnaWriter: this.qnaWriter,
          qnaTitle: this.qnaTitle,
          qnaContent: this.qnaContent,
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
      this.$router.push('/qna');
    },
  },
}
</script>

<style>

</style>