<template>
  <div class="regist text-center">
    <h1>글 삭제</h1>
    <div>삭제중...</div>
  </div>
</template>

<script>
import http from "@/api/http";

export default {
  created() {
    http.delete(`/board/${this.$route.params.no}`).then(({ data }) => {
      let msg = "삭제 처리시 문제가 발생했습니다.";
      if (data.flag == 1) {
        msg = "삭제가 완료되었습니다.";
      }
      alert(msg);

      this.$router.push({ name: "list" });
    });
  },
};
</script>

<style></style>
