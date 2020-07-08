<template>
        <div>
            <div class="form-group">
              <label for="writer">작성자</label>
              <input type="text" class="form-control" id="writer" ref="writer" placeholder="작성자를 입력하세요" v-model="writer">
            </div>
            <div class="form-group">
              <label for="title">제목</label>
              <input type="text" class="form-control" id="title" ref="title" placeholder="제목을 입력하세요" v-model="title">
            </div>
            <div class="form-group">
              <label for="content">내용</label>
              <textarea type="text" class="form-control" id="content" ref="content" placeholder="내용을 입력하세요"
                v-model="content"></textarea>
            </div>
            <div class="text-right">
              <button class="btn btn-primary" @click="checkHandler">수정</button>
            </div>
          </div>
</template>

<script>
import axios from 'axios';

export default {
    name:'Update',
    data: function () {
    return {
      no: '',
      writer: '',
      title: '',
      content: '',
    };
  },
  methods: {
    checkHandler() {
      let err = true;
      let msg = '';
      !this.writer && ((msg = '작성자를 입력해주세요'), (err = false), this.$refs.writer.focus());
      err && !this.title && ((msg = '제목 입력해주세요'), (err = false), this.$refs.title.focus());
      err &&
        !this.content &&
        ((msg = '내용 입력해주세요'), (err = false), this.$refs.content.focus());

      if (!err) alert(msg);
      else this.updateHandler();
    },
    updateHandler() {
      axios
        .put(`http://localhost:9999/happyhouse/api/qna/${this.no}`, {
            qnaNo: this.no,
          qnaWriter: this.writer,
          qnaTitle: this.title,
          qnaContent: this.content,
        })
        .then(({ data }) => {
          let msg = '수정 처리시 문제가 발생했습니다.';
          if (data === 'success') {
            msg = '수정이 완료되었습니다.';
          }
          alert(msg);
          this.$router.push('/qna');
        });
    },
  },
  created() {
    axios.get(`http://localhost:9999/happyhouse/api/qna/${this.$route.query.no}`).then(({ data }) => {
      this.no = data.qnaNo;;
      this.writer = data.qnaWriter;
      this.title = data.qnaTitle;
      this.content = data.qnaContent;
    });
  },
}
</script>

<style>

</style>