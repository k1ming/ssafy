<template>
    <div class="container" align="center">
        <div v-if="type==null"> 
            권한이 없습니다.
        </div>
        <div v-else>
            <div align="center">
                <table class="table table-borderless">
                    <tr>
                        <td align="right">
                            <select v-model="key" class="form-control" style="width:20%"> 
                            <option value="">선택하세요</option>
                            <option value="title">제목</option>
                            <option value="contents">내용</option>
                            <option value="userId">작성자(아이디)</option>
                            </select>
                            <input type="text" class="form-control" id="search" ref="se" placeholder="검색어 입력." style="width:20%" v-model="word" @keypress.enter="checkHandler">
                            <button v-on:click="checkHandler" type="button" class="btn btn-success">검색</button>
                            &nbsp;
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
                temps:[],
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
                .get('http://localhost:9999/board/free')
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
                    .push('/free/create');
            }, 
            checkHandler() {
            // 사용자 입력값 체크하기
            // 작성자, 제목, 내용 
            // 없을 경우 각 항목에 맞는 메세지를 출력
            let err = true;
            let msg = '';
             !this.key && (msg = '전체조회', err = false,
                axios
                .get('http://localhost:9999/board/free')
                .then(({data}) => {
                    this.boards = data;
                })
             );
             err&&!this.word&&(msg = '단어를 입력해주세요', err = false, this.$refs.se.focus());
            
            if (!err) alert(msg);
            // 만약, 내용이 다 입력되어 있다면 createHandler 호출
            else this.Search();
        },
            Search(){
                 axios
                    .get(`http://localhost:9999/board/free/${this.key}/word/${this.word}`)
                    .then(({data}) => {
                        this.boards = data;
                        console.log(this.temps);
                 });
            }
        }
    }
</script>

<style>
#listhead{
    background-color: #343a40;
    color: white;
}
</style>