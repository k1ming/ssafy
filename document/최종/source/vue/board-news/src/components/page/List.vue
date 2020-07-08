<template>
    <div>
      <!-- 검색 영역 -->
      <div style="display:none">
        <select ref="searchKey" v-model="searchKey">
          <option value="" selected disabled hidden>선택하시오</option>
          <option value="newsTitle">제목</option>
          <option value="newsContents">내용</option>
          <option value="newsMemno">작성자</option>
          <option value="refWriter">원작자</option>
          <option value="refSource">출처</option>
        </select>
        <input type="text" v-model.trim="searchValue" placeholder="검색어를 입력하세요">
        <button v-show="searchValue.trim().length !== 0">검색</button>
      </div>
      <!-- 등록 버튼영역 -->
      <div class="text-right" v-if="user!=null && user.type == 1" align="right">
        <table class="table table-borderless">
          <tr>
            <td align="right">
              <button class="btn btn-primary" @click="movePage">등록</button>
            </td>
          </tr>
        </table>
      </div>
      <!-- 리스트 영역 -->
      <div v-if="items.length">
        <table class="table table-bordered table-condensed">
          <colgroup>
            <col :style="{ width: '10%' }" />
            <col :style="{ width: '75%' }" />
            <col :style="{ width: '5%' }" />
            <col :style="{ width: '10%' }" />
          </colgroup>
          <tr align="center">
            <th>작성자</th>
            <th>제목</th>
            <th>조회수</th>
            <th>날짜</th>
          </tr>
          <tr v-for="(item, index) in items" :key="index + '_items'" align="center">
              <td>{{item.newsMemid}}</td>
              <td><a :href="'#' + item.newsNo" @click="$router.push({name: 'read', params: {no: item.newsNo}})">{{item.newsTitle}}</a></td>
              <td>{{item.newsViews}}</td>
              <td>{{getFormatDate(item.newsCreateDate)}}</td>
            </tr>
        </table>
      </div>
      <div v-else>글이 없습니다.</div>
  </div>
</template>

<script>
import axios from 'axios';
import moment from 'moment';
import VueLocalStorage from 'vue-localstorage';

export default {
    name: 'List',
    data: function(){
        return {
            items: [],
            user: [],
            searchValue: "",
            searchKey: ""
        };
    },
    created(){
        
        // login 처리
        localStorage.setItem('userinfo', JSON.stringify({'no':'13','type':'1'}));
        // console.log(localStorage.getItem("userinfo"));
        // localStorage.clear();
        this.user = JSON.parse(localStorage.getItem("userinfo"));
        // console.log(this.user);

        axios.get('http://localhost:9999/board/news').then(({ data }) => {
            this.items = data;
            console.log(this.items);
        })
    },
    methods: {
        getFormatDate(regtime){
            return moment(new Date(regtime)).format('YYYY.MM.DD');
        },
        movePage(){
            this.$router.push('/create');
        }
    }
}
</script>

<style>

</style>