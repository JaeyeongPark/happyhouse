<template>
  <v-main class="grey lighten-3 pt-3">
    <!-- <option-nav></option-nav> -->

    <v-sheet class="grey lighten-3" height="700px">
      <v-container justify-center>
        <v-row>
          <v-col cols="1"></v-col>
          <v-col cols="10"><search-nav></search-nav></v-col>
          <v-col cols="1"></v-col>
        </v-row>
        <v-row>
          <v-col cols="2"></v-col>
          <v-col cols="2">
            <v-select
              v-model="BoardInfoObj.key"
              :items="optionitems"
              class="mt-1"
              label="옵션"
              solo
              dense
            ></v-select>
          </v-col>
          <v-col cols="5">
            <v-text-field
              label="검색어를 입력하세요"
              hide-details="auto"
              solo
              v-model="BoardInfoObj.word"
            ></v-text-field>
          </v-col>
          <v-col cols="3">
            <v-btn color="primary" class="mr-4 mt-1" @click="search">
              검색
            </v-btn>
          </v-col>
        </v-row>
      </v-container>
      <v-container justify-center>
        <v-card max-width="1800px">
          <v-simple-table>
            <template v-slot:default>
              <thead>
                <tr>
                  <th class="text-center">글번호</th>
                  <!-- <v-divider vertical></v-divider> -->
                  <th class="text-center">제목</th>
                  <!-- <v-divider vertical></v-divider> -->
                  <th class="text-center">작성자</th>
                  <!-- <v-divider vertical></v-divider> -->
                  <th class="text-center">지역</th>
                  <!-- <v-divider vertical></v-divider> -->
                  <th class="text-center">시설</th>
                  <!-- <v-divider vertical></v-divider> -->
                  <th class="text-center">시설명</th>
                </tr>
              </thead>
              <tbody>
                <board-list-item
                  v-for="article in boards"
                  :key="article.no"
                  :article="article"
                ></board-list-item>
              </tbody>
            </template>
          </v-simple-table>
        </v-card>
      </v-container>

      <v-container>
        <v-row>
          <v-col cols="3"></v-col>
          <template v-if="boards && boards.length != 0">
            <v-col>
              <board-paging
                :pagenavi="pagenavi"
                :BoardInfoObj="BoardInfoObj"
                style="text-align: center"
              ></board-paging>
            </v-col>
            <!-- <v-col cols="6"></v-col> -->
          </template>
          <template v-else>
            <v-col cols="6"></v-col>
          </template>
          <v-col class="d-flex" cols="3" sm="3">
            <v-btn class="ml-3" color="primary" @click="regboard()">
              글쓰기
            </v-btn>
            <v-btn class="ml-3" color="primary" @click="clearboard()">
              전체글보기
            </v-btn>
          </v-col>
        </v-row>
      </v-container>
    </v-sheet>
  </v-main>
</template>

<script>
import BoardListItem from "@/components/board/BoardListItem";
import BoardPaging from "@/components/board/BoardPaging.vue";
// import OptionNav from "@/components/layout/OptionNav.vue";
import { mapState, mapActions, mapMutations } from "vuex";
import SearchNav from "../layout/SearchNav.vue";

export default {
  components: {
    BoardListItem,
    BoardPaging,
    // OptionNav,
    SearchNav,
  },
  data() {
    return {
      BoardInfoObj: {
        pg: 1,
        key: "",
        word: "",
        dongcode: "",
        category: "",
        categoryvalue: "",
      },
      optionitems: [
        { text: "이름", value: "id" },
        { text: "제목", value: "subject" },
        { text: "내용", value: "contents" },
      ],
    };
  },

  watch: {
    boards: function (data) {
      // console.log(data);
      if (this.$store.state.boardStore.issearchdirect && data.length == 0) {
        alert("관련 게시물이 없습니다.");
        this.$store.state.boardStore.issearchdirect = false;
      } else {
        this.$store.state.boardStore.issearchdirect = false;
      }
    },
    condition: function (condition) {
      console.log(condition);
      console.log(1);
      this.BoardInfoObj.dongcode = condition.dongCode;
      this.BoardInfoObj.category = condition.category;
      this.BoardInfoObj.categoryvalue = condition.categoryvalue;
      let conditions = this.BoardInfoObj;
      this.getBoardList(conditions);
    },
    directboardcondition: function (data) {
      console.log("이게만약 찍히면 보드리스트에 121번줄을 확인해 꼭!" + data);
    },
  },
  computed: {
    ...mapState("boardStore", ["boards", "pagenavi"]),
    ...mapState("addressStore", ["condition", "directboardcondition"]),
  },
  created() {
    // console.log(this.$store.state.boardStore.issearchdirect);
    this.$store.state.addressStore.dongcode = "";
    if (this.$store.state.boardStore.issearchdirect) {
      let conditions = {
        pg: 1,
        key: "",
        word: "",
        dongcode: this.$store.state.addressStore.condition.dongCode,
        category: this.$store.state.addressStore.condition.category,
        categoryvalue: this.$store.state.addressStore.condition.categoryvalue,
        // dongcode: "",
        // category: "",
        // categoryvalue: "",
      };
      // this.$store.state.boardStore.issearchdirect = false;
      this.getBoardList(conditions);
    } else if (
      !this.$store.state.boardStore.issearchdirect &&
      this.$store.state.addressStore.condition.dongCode
    ) {
      console.log(2);
      let conditions = {
        pg: 1,
        key: "",
        word: "",
        dongcode: this.$store.state.addressStore.condition.dongCode,
        category: this.$store.state.addressStore.condition.category,
        categoryvalue: this.$store.state.addressStore.condition.categoryvalue,
        // dongcode: "",
        // category: "",
        // categoryvalue: "",
      };
      // this.$store.state.boardStore.issearchdirect = false;
      this.getBoardList(conditions);
    } else {
      let conditions = {
        pg: 1,
        key: "",
        word: "",
        dongcode: "",
        category: "",
        categoryvalue: "",
      };
      // this.$store.state.boardStore.issearchdirect = false;
      this.getBoardList(conditions);
    }
  },
  methods: {
    ...mapActions("boardStore", ["getBoardList"]),
    ...mapMutations("addressStore", ["CLEAR_CONDITION_LIST"]),
    updatepage(newpg) {
      let conditions = this.BoardInfoObj;
      conditions.pg = newpg;
      this.getBoardList(conditions);
    },
    regboard() {
      if (sessionStorage.getItem("access-token")) {
        this.$router.push({ name: "boardregist" });
      } else {
        alert("로그인 해주세요");
      }
    },
    search() {
      let conditions = this.BoardInfoObj;
      this.getBoardList(conditions);
    },
    clearboard() {
      let conditions = {
        pg: 1,
        key: "",
        word: "",
        dongcode: "",
        category: "",
        categoryvalue: "",
      };
      this.CLEAR_CONDITION_LIST();
      this.getBoardList(conditions);
    },
  },
};
</script>

<style scoped>
tr {
  text-align: center;
}
</style>
