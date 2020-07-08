<template>
    <div>
        <div class="form-group">
            <label for="newsTitle">제목</label>
            <input type="text" class="form-control" id="newsTitle" ref="newsTitle" placeholder="(*)제목을 입력하세요" v-model="newsTitle">
        </div>
        <div class="form-group">
            <label for="newsContents">내용</label>
            <textarea type="text" class="form-control" id="newsContents" ref="newsContents" placeholder="(*)내용을 입력하세요"
                v-model="newsContents"></textarea>
        </div>
        <div class="form-group">
            <label for="refWriter">원작자</label>
            <input type="text" class="form-control" id="refWriter" ref="refWriter" placeholder="(*)원작자를 입력하세요" v-model="refWriter">
        </div>
        <div class="form-group">
            <label for="refSource">출처</label>
            <input type="text" class="form-control" id="refSource" ref="refSource" placeholder="(*)출처를 입력하세요" v-model="refSource">
        </div>
        <div class="form-group">
          <button @click="ckHvDate" v-show="!hvDate">원작 작성일자</button>
          <label for="refDate" v-show="hvDate" @click="ckHvDate">출처</label>
          <input type="date" class="form-control" id="refDate" ref="refDate" placeholder="yyyy-mm-dd" v-model="refDate" v-show="hvDate">
        </div>
        <div class="text-right">
            <div class="text-right">
              <button class="btn btn-primary" @click="checkHandler">수정</button>
            </div>
        </div>
    </div>
</template>

<script>
import axios from 'axios';
export default {
    name: 'Update',
    data: function () {
    return {
        newsNo: '',
        newsViews: '',
        newsCreateDate: '',
        newsMemno: '',
        newsTitle: '',
        newsContents: '',
        refWriter: '',
        refSource: '',
        refDate: '',
        user: [],
        hvDate: false
    };
  },
  methods: {
    checkHandler() {
      let err = true;
      let msg = '';
      !this.newsTitle && ((msg = '제목을 입력해주세요'), (err = false), this.$refs.newsTitle.focus());
      err && !this.newsContents && ((msg = '내용을 입력해주세요'), (err = false), this.$refs.newsContents.focus());
      err && !this.refWriter && ((msg = '원작자를 입력해주세요'), (err = false), this.$refs.refWriter.focus());
      err && !this.refSource && ((msg = '출처를 입력해주세요'), (err = false), this.$refs.refSource.focus());

      if (!err) alert(msg);
      else this.updateHandler();
    },
    updateHandler() {
      axios
        .put(`http://localhost:9999/board/news/${this.no}`, {
            newsMemno: this.user.no,
            newsTitle: this.newsTitle,
            newsContents: this.newsContents,
            refWriter: this.refWriter,
            refSource: this.refSource,
            refDate: this.refDate,
            newsNo: this.newsNo,
            newsViews: this.newsViews,
            newsCreateDate: this.newsCreateDate
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
    ckHvDate() {
      this.hvDate = !this.hvDate;
    }
  },
  created() {
    // login 처리 구현
    console.log(localStorage.getItem("userinfo"));
    this.user = JSON.parse(localStorage.getItem("userinfo"));
    console.log(this.user);

    axios.get(`http://localhost:9999/board/news/${this.$route.query.no}`)
    .then(({ data }) => {
        this.newsTitle = data.newsTitle;
        this.newsContents = data.newsContents;
        this.refWriter = data.refWriter;
        this.refSource = data.refSource;
        this.newsNo = data.newsNo;
        this.newsViews = data.newsViews;
        this.newsCreateDate = data.newsCreateDate;
        this.newsMemno = data.newsMemno;
        if(this.refDate != null){
            this.refDate = data.refDate;
        }
    });

    if(this.newsMemno != this.user.no && this.user.type != 1){
      alert("접근 권한이 없습니다.");
      location.href = "list.html";
    }

  },
}
</script>

<style>

</style>