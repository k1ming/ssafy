<template>
    <div class="container" align="center">
        <div class="text-right" v-if="user">
            <table class="table table-borderless">
                <tr>
                    <td align="right">
                        <button class="btn btn-primary" @click="movePage">등록</button>
                    </td>
                </tr>
            </table>
        </div>
        <div v-if="items.length">
            <table class="table table-bordered table-condensed" align="center">
                <colgroup>
                    <col :style="{ width: '5%' }" />
                    <col :style="{ width: '50%' }" />
                    <col :style="{ width: '10%' }" />
                    <col :style="{ width: '25%' }" />
                </colgroup>
                <thead align="center" id="listhead">
                    <tr>
                        <th>번호</th>
                        <th>제목</th>
                        <th>작성자</th>
                        <th>날짜</th>
                    </tr>
                </thead>
                <tr v-for="(item, index) in items" :key="index + '_items'" align="center">
                    <td>{{item.qnaNo}}</td>
                    <td><a :href="'#' + item.qnaNo" @click="$router.push({name: 'read', params: {no: item.qnaNo}})">{{item.qnaTitle}}</a></td>
                    <td>{{item.qnaMemid}}</td>
                    <td>{{getFormatDate(item.qnaDatetime)}}</td>
                </tr>
            </table>
        </div>
        <div v-else>글이 없습니다.</div>
        
    </div>
</template>

<script>
import axios from 'axios';
import moment from 'moment';
export default {
    name: 'List',
    data: function () {
        return {
            items: [],
            user: []
        };
    },
    created() {
        
        // localStorage.setItem('userinfo', JSON.stringify({'no':'14','type':'2'}));
        // console.log(localStorage.getItem("userinfo"));
        // localStorage.clear();
        this.user = JSON.parse(localStorage.getItem("userinfo"));
        console.log(this.user);

        if(!this.user){
            alert("접근 권한이 없습니다.");
            // 로그인창으로 이동
            location.href = "/";
        }
        else{
            axios.get('http://localhost:9999/board/qna').then(({ data }) => {
                this.items = data;
                console.log(this.items);
            });
        }

    },
    methods: {
        getFormatDate(regtime) {
            return moment(new Date(regtime)).format('YYYY.MM.DD');
        },
        movePage() {
            this.$router.push('/createQ');
        },
    },
}
</script>

<style>
#listhead{
    background-color: #343a40;
    color: white;
}
</style>