<template>
  <div>
      <div class="text-center" v-if="user != null && (user.no == item.newsMemno || user.type == 1)" align="right">
        <router-link :to="'/update?no=' + item.newsNo"><button class="btn btn-primary">수정</button></router-link>
        <router-link :to="'/delete/' + item.newsNo"><button class="btn btn-primary">삭제</button></router-link>
      </div>
      <table class="table table-bordered w-50" align="center">
        <tr>
          <th>번호</th>
          <td>{{item.newsNo}}</td>
        </tr>
        <tr>
          <th>조회수</th>
          <td>{{item.newsViews}}</td>
        </tr>
        <tr>
          <th>작성날짜</th>
          <td>{{getFormatDate(item.newsCreateDate)}}</td>
        </tr>
        <tr>
          <th>작성자</th>
          <td>{{item.newsMemid}}</td>
        </tr>
        <tr>
          <th>제목</th>
          <td>{{item.newsTitle}}</td>
        </tr>
        <tr>
          <th>내용</th>
          <td>{{item.newsContents}}</td>
        </tr>
        <tr>
          <th>원작자</th>
          <td>{{item.refWriter}}</td>
        </tr>
        <tr>
          <th>출처</th>
          <td>{{item.refSource}}</td>
        </tr>
        <tr v-if="item.refDate">
          <th>원작 작성일자</th>
          <td>{{getFormatDate(item.refDate)}}</td>
        </tr>
        <tr>
          <td colspan="2">
            {{item.content}}
          </td>
        </tr>
      </table>
      <br />
      <div class="text-center" align="center">
        <router-link :to="'/list'"><button class="btn btn-primary">목록</button></router-link>
      </div>
    </div>
</template>

<script>
import axios from 'axios';
import moment from 'moment';
export default {
    name: 'Read',
    data: function () {
        return {
          item: {},
          user: []
        };
    },
    created() {
        // login 처리 
        // console.log(localStorage.getItem("userinfo"));
        this.user = JSON.parse(localStorage.getItem("userinfo"));
        // console.log(this.user);

        // const params = new URL(document.location).searchParams;
        axios.get(`http://localhost:9999/board/news/${this.$route.params.no}`)
        .then(({ data }) => {
            this.item = data;
            console.log(this.item);
        });
    },
    methods: {
    getFormatDate(regtime) {
        return moment(new Date(regtime)).format('YYYY.MM.DD');
        // return moment(new Date(regtime)).format('YYYY.MM.DD HH:mm:ss');
    }
    }
}
</script>

<style>

</style>