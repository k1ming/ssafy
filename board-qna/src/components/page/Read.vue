<template>
    <div>
        <table class="table table-bordered w-50">
            <tr>
                <th>번호</th>
                <td>{{item.qnaNo}}</td>
            </tr>
            <tr>
                <th>글쓴이</th>
                <td>{{item.qnaMemid}}</td>
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
                    {{item.content}}
                </td>
            </tr>
        </table>
        <br />
        <div class="text-center">
            <router-link :to="'/list'"><button class="btn btn-primary">목록</button></router-link>
            <router-link v-if="user.no == item.qnaMemno || user.type == 1" :to="'/updateQ?no=' + item.qnaNo"><button class="btn btn-primary">수정</button></router-link>
            <router-link v-if="user.no == item.qnaMemno || user.type == 1" :to="'/deleteQ/' + item.qnaNo"><button class="btn btn-primary">삭제</button></router-link>
            
            <!-- 관리자라면 -->
            <router-link v-if="user.type == 1" :to="'/createA?no=' + item.qnaNo"><button class="btn btn-primary">답변 등록</button></router-link>
        </div>

        <!-- 답변 -->
        <div id="answer" v-if="user && item.reply > 0">
            <br />
            <br />
            <table class="table table-bordered w-50">
                <tr>
                    <th>답변자</th>
                    <td>{{item.replyMemid}}</td>
                </tr>
                <tr>
                    <th>답변 날짜</th>
                    <td>{{getFormatDate(item.replyDatetime)}}</td>
                </tr>
                <tr>
                    <td colspan="2">
                        {{item.replyContent}}
                    </td>
                </tr>
            </table>
            <br />
            <div class="text-center" v-if="user.type == 1">
                <router-link :to="'/updateA?no=' + item.qnaNo"><button class="btn btn-primary">수정</button></router-link>
                <router-link :to="'/deleteA/' + item.qnaNo"><button class="btn btn-primary">삭제</button></router-link>
            </div>
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
    
    this.user = JSON.parse(localStorage.getItem("userinfo"));

    if(!this.user){
        alert("접근 권한이 없습니다.");
        // 로그인창으로 이동
        location.href="/";
    }
    else{
        // const params = new URL(document.location).searchParams;
        axios.get(`http://localhost:9999/board/qna/${this.$route.params.no}`)
        .then(({ data }) => {
          this.item = data;
          // 로그인창으로 이동
          console.log(this.item);
        });
    }
  },
  methods: {
    getFormatDate(regtime) {
      return moment(new Date(regtime)).format('YYYY.MM.DD HH:mm:ss');
    }
  }
}
</script>

<style>

</style>