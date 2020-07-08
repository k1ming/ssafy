<template>
    <div>
        <div class="form-group">
            <label for="replyContent">내용</label>
            <textarea type="text" class="form-control" id="replyContent" ref="replyContent" placeholder="내용을 입력하세요" v-model="replyContent"></textarea>
        </div>
        <div class="text-right">
            <button class="btn btn-primary" @click="checkHandler">수정</button>
        </div>
    </div>
</template>

<script>
import axios from 'axios';
export default {
    name: 'UpdateA',
    data: function () {
        return {
        qnaNo: '',
        replyContent: '',
        user: []
        };
    },
    methods: {
        checkHandler() {
            let err = true;
            let msg = '';
            !this.replyContent && ((msg = '내용 입력해주세요'), (err = false), this.$refs.replyContent.focus());

            if (!err) alert(msg);
            else this.updateHandler();
        },
        updateHandler() {
            axios.put(`http://localhost:9999/board/qna/updateA/${this.no}`, {
                qnaNo: this.qnaNo,
                replyMemno: this.user.no,
                replyContent: this.replyContent
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
    },
    created() {
        
        this.user = JSON.parse(localStorage.getItem("userinfo"));

        axios.get(`http://localhost:9999/board/qna/${this.$route.query.no}`)
        .then(({ data }) => {
            this.qnaNo = data.qnaNo;
            this.replyContent = data.replyContent;
        });

        if(!(this.user && this.user.type == 1)){
            alert("접근 권한이 없습니다.");
            // 로그인창으로 이동
            location.href="/";
        }
    }
}
</script>

<style>

</style>