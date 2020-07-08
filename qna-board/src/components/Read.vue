<template>
  <div>
      <table class="table table-bordered w-50">
        <tr>
          <th>번호</th>
          <td>{{item.qnaNo}}</td>
        </tr>
        <tr>
          <th>글쓴이</th>
          <td>{{item.qnaWriter}}</td>
        </tr>
        <tr>
          <th>제목</th>
          <td>{{item.qnaTitle}}</td>
        </tr>
        <tr>
          <th>날짜</th>
          <td>{{getFormatDate(item.qnaDatetime)}}</td>
        </tr>
        <tr>
          <td colspan="2">
            {{item.qnaContent}}
          </td>
        </tr>
      </table>
      <br />
      <div class="text-center">
        <router-link :to="'/qna'"><button class="btn btn-primary">목록</button></router-link>
         <router-link :to="'/update?no=' + item.qnaNo"><button class="btn btn-primary">수정</button></router-link>
        <router-link :to="'/delete/' + item.qnaNo"><button class="btn btn-primary">삭제</button></router-link>       </div>
    </div>
</template>

<script>
import axios from 'axios';
import moment from 'moment';
export default {
    name:'Read',
    data: function () {
    return {
      item: {},
    };
  },
  created() {
    // const params = new URL(document.location).searchParams;
    axios.get(`http://localhost:9999/happyhouse/api/qna/${this.$route.params.no}`).then(({ data }) => {
      this.item = data;
      console.log(this.item);
    });
  },
  methods: {
    getFormatDate(regtime) {
      return moment(new Date(regtime)).format('YYYY.MM.DD HH:mm:ss');
    },
  },
}
</script>

<style>

</style>