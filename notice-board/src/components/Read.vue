<template>
    <div class="container" align="center">
        <table class="table table-bordered  thead-dark">
            <tr>
                <th id="read">번호</th>
                <td>{{board.no}}</td>
            </tr>
            <tr>
                <th id="read">작성자</th>
                <td>{{board.userId}}</td>
            </tr>
            <tr>
                <th id="read">제목</th>
                <td>{{board.title}}</td>
            </tr>
            <tr>
                <th id="read">조회수</th>
                <td>{{board.views}}</td>
            </tr>
            <tr>
                <td colspan="2">
                    {{board.contents}}
                </td>
            </tr>
        </table>
        <div class="text-center">
            <router-link :to="'/notice/list'">
                <button class="btn btn-primary">목록</button>
            </router-link>
        
            <div v-if="type==1" style="display:inline;">
                <router-link :to="'/notice/update?no='+board.no">
                    <button class="btn btn-warning">수정</button>
                </router-link>
                <router-link :to="'/notice/delete/' + board.no">
                    <button class="btn btn-danger">
                        삭제
                    </button>
                </router-link>
            </div>
        </div>
    </div>
</template>

<script>
    import axios from 'axios';
    export default {
        name: 'Read',
        data: function () {
            return {board: {}, 
            no:'',
            type:'',
            
            };
        },
        created() {
            
           this.no=localStorage.getItem('userNo');
            this.type=localStorage.getItem("userType");
            
            // const params = new URL(document.location).searchParams;
            axios
                .get(`http://localhost:9999/board/notice/${this.$route.params.no}`)
                .then(({data}) => {
                    this.board = data;
                    console.log(this.board);
                });
        }
    }
</script>

<style>
#read{
    width: 20%;
}
</style>