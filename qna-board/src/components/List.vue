<template>
    <div>
      <div v-if="items.length">
        <table class="table table-bordered table-condensed">
          <colgroup>
            <col :style="{width: '5%'}"/>
            <col :style="{width: '15%'}"/>
            <col :style="{width: '50%'}"/>
            <col :style="{width: '15%'}"/>
            <col :style="{width: '15%'}"/>
          </colgroup>
          <tr>
            <th>번호</th>
            <th>질문제목</th>
            <th>질문내용</th>
            <th>질문자이름</th>
            <th>질문일시</th>
          </tr>
          <tr v-for="(item, index) in items" :key="index + '_items'">
            <td>{{item.qnaNo}}</td>
            <td>{{item.qnaTitle}}</td>
            <td><a :href="'#' + item.qnaNo" @click="$router.push({name: 'read', params: {no: item.qnaNo}})">{{item.qnaContent}}</a></td>
            <td>{{item.qnaWriter}}</td>
            <td>{{getFormatDate(item.qnaDatetime)}}</td>
          </tr>
        </table>
      </div>
      <div v-else>
        글이 없습니다.
      </div>
      <div class="text-right">
        <button class="btn btn-primary" @click="movePage">등록</button>
      </div>
    </div>
</template>

<script>
import axios from 'axios';
import moment from 'moment';
export default {
    name:'List',
    data: function () {
    return {
      items: [],
    };
  },
  created() {
    axios.get('http://localhost:9999/happyhouse/api/qna').then(({ data }) => {
      this.items = data;
    });
  },
  methods: {
    getFormatDate(qnaDatetime) {
      return moment(new Date(qnaDatetime)).format('YYYY.MM.DD');
    },
    movePage() {
      this.$router.push('/create');
    },
  },
}
</script>

<style>

</style>