<template>
  <v-main class="grey lighten-3">
    <div class="regist text-center row" style="float: none; margin: 100 auto">
      <board-address-search></board-address-search>
    </div>
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
                  v-model="boardreginfo.id"
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
                  v-model="boardreginfo.subject"
                ></v-text-field>
              </th>
            </tr>
            <tr height="500px">
              <th class="text-center" width="100px">내용</th>
              <th class="text-left" width="10px">
                <v-divider vertical></v-divider>
              </th>
              <th>
                <v-textarea
                  class="mt-6"
                  label="내용"
                  solo
                  height="470px"
                  v-model="boardreginfo.content"
                ></v-textarea>
              </th>
            </tr>
          </thead>
        </v-simple-table>
      </v-sheet>
    </v-container>
    <v-container class="text-right">
      <v-btn color="primary" class="ml-3" @click="boardregist">등록</v-btn>
      <v-btn color="primary" class="ml-3" @click="moveList">목록</v-btn>
    </v-container>
  </v-main>
</template>

<script>
import { mapActions, mapState, mapMutations } from "vuex";
import BoardAddressSearch from "../layout/BoardAddressSearch.vue";
export default {
  components: { BoardAddressSearch },
  data() {
    return {
      boardreginfo: {
        id: "",
        subject: "",
        content: "",
        dongcode: "",
        category: "",
        categoryvalue: "",
        sidoName: "",
        gugunName: "",
        dongName: "",
      },
    };
  },
  watch: {
    condition: function (condition) {
      this.boardreginfo.dongcode = condition.dongCode;
      this.boardreginfo.category = condition.category;
      this.boardreginfo.categoryvalue = condition.categoryvalue;
    },
    datastate: function (data) {
      if (data == "success") {
        alert("글 등록성공");
      } else {
        alert("글 등록실패");
      }
      // this.$store.state.boardStore.condition = {
      //   pg: 1,
      //   key: "",
      //   word: "",
      //   dongcode: "",
      //   category: "",
      //   categoryvalue: "",
      // };
      this.$router.push({ name: "boardlist" });
      this.SET_DATASTATE_NULL();
    },
  },
  created() {
    this.$store.state.addressStore.dongcode = "";
    console.log(this.$store.state.boardStore.condition);
    this.boardreginfo.id = this.$store.state.userStore.userInfo.id;
    this.SET_DATASTATE_NULL();
  },
  computed: {
    ...mapState("addressStore", ["condition", "addresscondition"]),
    ...mapState("boardStore", ["datastate"]),
  },
  methods: {
    ...mapActions("boardStore", ["registBoard"]),
    ...mapMutations("boardStore", ["SET_DATASTATE_NULL"]),
    boardregist() {
      this.boardreginfo.sidoName =
        this.$store.state.addressStore.addresscondition.sidoName;
      this.boardreginfo.gugunName =
        this.$store.state.addressStore.addresscondition.gugunName;
      this.boardreginfo.dongName =
        this.$store.state.addressStore.addresscondition.dongName;
      // console.log(this.boardreginfo);

      this.$store.state.addressStore.condition = {
        dongCode: "",
        category: "",
        categoryvalue: "",
      };
      this.$store.state.addressStore.alladdress = {
        sidoName: "",
        gugunName: "",
        dongName: "",
      };

      this.registBoard(this.boardreginfo);
    },
    moveList() {
      this.$router.push({ name: "boardlist" });
    },
  },
};
</script>

<style>
.view {
  border: 1px solid black;
  margin-top: 4px;
  margin-bottom: 4px;
}
label {
  font-weight: bold;
  display: inline;
}
input {
  display: block;
}
</style>
