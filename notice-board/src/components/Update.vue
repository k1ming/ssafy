<template>
  <div class="container" align="center">
    <br>
        <div class="form-group">
              <h2>제목</h2>
              <!-- <label for="title">제목</label> -->
              <input type="text" class="form-control" id="title" ref="title" placeholder="제목을 입력하세요" v-model="title">
        </div>
        <div class="form-group">
              <h2>내용</h2>
              <!-- <label for="content">내용</label> -->
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
  name: 'Update',
  data: function(){
    return{
      no:'',
      title:'',
      content:''
    }
  },
  methods:{
    checkHandler(){
       let err = true;
      let msg = '';
      !this.title && ((msg = '제목 입력해주세요'), (err = false), this.$refs.title.focus());
      err &&
        !this.content &&
        ((msg = '내용 입력해주세요'), (err = false), this.$refs.content.focus());

      if (!err) alert(msg);
      else this.updateHandler();
    },
    updateHandler() {
      axios
        .put(`http://localhost:9999/board/notice/${this.no}`, {
          no: this.no,
          title: this.title,
          contents: this.content,
        })
        .then(({ data }) => {
          let msg = '수정 처리시 문제가 발생했습니다.';
          if (data === 'success') {
            msg = '수정이 완료되었습니다.';
          }
          alert(msg);
          this.$router.push('/notice/list');
        });
    },
  },
  created(){
    axios.get(`http://localhost:9999/board/notice/${this.$route.query.no}`).then(({ data }) => {
      this.no = data.no;
      this.title = data.title;
      this.content = data.contents;
    });
  }

}
</script>

<style>

</style>