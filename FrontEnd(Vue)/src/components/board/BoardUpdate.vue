<template>
  <v-main class="grey lighten-3">
    <board-address-search></board-address-search>

    <v-container class="grey">
      <v-sheet outlined>
        <v-simple-table fixed-header>
          <thead>
            <tr class="text-center">
              <th class="text-center" width="100px">작성자</th>
              <th class="text-left" width="10px">
                <v-divider vertical></v-divider>
              </th>
              <th class="">
                <v-text-field
                  class="mt-6"
                  label="작성자 아이디"
                  solo
                  v-model="boardupinfo.id"
                ></v-text-field>
              </th>
            </tr>
            <tr>
              <th class="text-center" width="100px">제목</th>
              <th class="text-left" width="10px">
                <v-divider vertical></v-divider>
              </th>
              <th>
                <v-text-field
                  class="mt-6"
                  label="제목"
                  solo
                  v-model="boardupinfo.subject"
                ></v-text-field>
              </th>
            </tr>
            <tr height="500px">
              <th class="text-center" width="100px">제목</th>
              <th class="text-left" width="10px">
                <v-divider vertical></v-divider>
              </th>
              <th>
                <v-textarea
                  class="mt-6"
                  label="내용"
                  solo
                  height="470px"
                  v-model="boardupinfo.content"
                ></v-textarea>
              </th>
            </tr>
          </thead>
        </v-simple-table>
      </v-sheet>
    </v-container>
    <v-container class="text-right">
      <v-btn class="ml-3" color="primary" @click="updatevalue">수정</v-btn>
      <v-btn class="ml-3" color="primary" :to="{ name: 'boarddetail' }"
        >취소</v-btn
      >
      <v-btn class="ml-3" color="primary" @click="moveList">목록</v-btn>
    </v-container>

    <v-container height="50px"></v-container>
  </v-main>
</template>

<script>
import { mapActions, mapState, mapMutations } from "vuex";
import BoardAddressSearch from "../layout/BoardAddressSearch.vue";
// import http from "@/api/http";
export default {
  components: {
    BoardAddressSearch,
  },
  data() {
    return {
      boardupinfo: {
        id: "",
        subject: "",
        content: "",
        dongcode: "",
        category: "",
        categoryvalue: "",
      },
    };
  },
  watch: {
    board: function (data) {
      this.boardupinfo = data;
    },
    datastate: function (data) {
      if (data == "success") {
        alert("글 수정성공");
      } else {
        alert("글 수정실패");
      }
      this.$router.push({ name: "boardlist" });
      this.SET_DATASTATE_NULL();
    },
    condition: function (condition) {
      this.boardupinfo.dongcode = condition.dongCode;
      this.boardupinfo.category = condition.category;
      this.boardupinfo.categoryvalue = condition.categoryvalue;
    },
  },
  created() {
    this.detailBoard(this.$route.params.no);
    this.SET_DATASTATE_NULL();
  },
  computed: {
    ...mapState("boardStore", ["board", "comments", "datastate"]),
    ...mapState("addressStore", ["condition"]),
  },
  methods: {
    ...mapActions("boardStore", ["detailBoard", "updateBoard"]),
    ...mapMutations("boardStore", ["SET_DATASTATE_NULL"]),
    updatevalue() {
      let arr = [this.$route.params.no, this.boardupinfo];
      this.updateBoard(arr);
    },
    moveList() {
      this.$router.push({ name: "boardlist" });
    },
  },
};
</script>

<style scoped>
.view {
  border: 1px solid black;
  margin-top: 10px;
  margin-bottom: 10px;
}
label {
  font-weight: bold;
  display: block;
}
input {
  display: block;
}
</style>
