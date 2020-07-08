<template>
  <div class="container" align="center">
    <div v-if="type==null">
       권한이 없습니다.
    </div>
    <div v-else-if="type==1">
    <div class="form-group">
      <label for="title">제목</label>
      <input type="text" class="form-control" id="noticeTitle" ref="noticeTitle" placeholder="제목을 입력하세요" v-model="noticeTitle">
    </div>
    <div class="form-group">
      <label for="content">내용</label>
      <textarea type="text" class="form-control" id="noticeContent" ref="noticeContent" placeholder="내용을 입력하세요"
        v-model="noticeContent"></textarea>
    </div>
    <div class="text-right">
      <button class="btn btn-primary" @click="checkHandler">등록</button>
         &nbsp;
      <button class="btn btn-primary" @click="moveList">목록</button>
    </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
export default {
  name: 'Create',
  data: function(){
    return{
      noticeTitle:'',
      noticeContent:'',
      memno:'',
      no:'',
      type:'',
    }
  },
  created() {
            this.no=localStorage.getItem('userNo');
            this.type=localStorage.getItem("userType");
        
  },
  methods:{
    checkHandler(){
      let err = true;
      let msg = '';
      !this.noticeTitle && ((msg = '제목 입력해주세요'), (err = false), this.$refs.noticeTitle.focus());
      err &&
        !this.noticeContent &&
        ((msg = '내용 입력해주세요'), (err = false), this.$refs.noticeContent.focus());

      if (!err) alert(msg);
      else this.createHandler();

    },
    createHandler(){
      axios
        .post('http://localhost:9999/board/notice', {
        
          title: this.noticeTitle,
          contents: this.noticeContent,
          memno: this.no,
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
      this.$router.push('/notice/list');
    },
  }

}
</script>

<style>

</style>