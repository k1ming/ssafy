<template>
    <div class="container" align="center">
        <div v-if="type==null"> 
            권한이 없습니다.
        </div>
        <div v-else>
            <div v-if="type==1" align="center">
                <table class="table table-borderless">
                    <tr>
                        <td align="right">
                            <button class="btn btn-primary" @click="movePage">등록</button>
                        </td>
                    </tr>
                </table>
            </div>
            <div v-if="boards.length">
                <table class="table table-bordered table-condensed">
                    <thead align="center" id="listhead">
                    <tr>
                        <th>번호</th>
                        <th>제목</th>
                        <th>작성자</th>
                        <th>작성날짜</th>
                        <th>조회수</th>
                    </tr>
                    </thead>
                    <tbody align="center">
                    <tr v-for="(board,index) in boards" :key="index+'_boards'">
                        <td>{{board.no}}</td>
                        <td>
                            <a
                                :href="'#' + board.no"
                                @click="$router.push({name: 'read', params: {no: board.no}})">{{board.title}}</a>
                        </td>
                        <td>{{board.userId}}</td>
                        <td>{{getFormatDate(board.createDate)}}</td>
                        <td>{{board.views}}</td>

                    </tr>
                    </tbody>
                </table>
            </div>
            <div v-else>
                글이 없습니다.
            </div>
        </div>
    </div>
</template>

<script>
    import axios from 'axios';
    import moment from 'moment';
    export default {
        name: 'List',
        data: function () {
            return {
                boards: [], 
                key:'',
                word:'',
                no:'',
                type:'',
                };
        },
        created() {
            this.no=localStorage.getItem('userNo');
            this.type=localStorage.getItem("userType");
           
            axios
                .get('http://localhost:9999/board/notice')
                .then(({data}) => {
                    this.boards = data;
                    
                });
        },
        methods: {
            getFormatDate(time) {
                return moment(new Date(time)).format('YYYY.MM.DD');
            },
            movePage() {
                this
                    .$router
                    .push('/notice/create');
            }, 
        }
    }
</script>

<style>
#listhead{
    background-color: #343a40;
    color: white;
}
</style>