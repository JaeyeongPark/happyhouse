<template>
  <div>
    <div>
      <v-container fluid>
        <v-row align="center">
          <v-col class="d-flex" cols="12" sm="1">
            <v-select
              v-model="BoardInfoObj.key"
              :items="optionitems"
              label="옵션"
              dense
            ></v-select>
          </v-col>
          <v-col class="d-flex" cols="12" sm="3">
            <v-text-field
              label="검색어를 입력하세요"
              hide-details="auto"
              v-model="BoardInfoObj.word"
            ></v-text-field>
          </v-col>
          <v-col class="d-flex" cols="12" sm="3">
            <v-btn color="success" class="mr-4" @click="search"> 검색 </v-btn>
          </v-col>
          <v-col class="d-flex" cols="12" sm="2"> </v-col>
          <v-col class="d-flex" cols="12" sm="3">
            <v-btn color="success" :to="{ name: 'regist' }"> 글쓰기 </v-btn>
          </v-col>
        </v-row>
      </v-container>
    </div>
    <div style="text-align: center">
      <v-simple-table>
        <template v-slot:default>
          <thead>
            <tr>
              <th class="text-left">글번호</th>
              <th class="text-left">제목</th>
              <th class="text-left">작성자</th>
              <th class="text-left">조회수</th>
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
    </div>
    <div>
      <board-paging
        :pagenavi="pagenavi"
        :BoardInfoObj="BoardInfoObj"
      ></board-paging>
    </div>
  </div>
</template>

<script>
import BoardListItem from "@/components/board/BoardListItem.vue";
import BoardPaging from "@/components/board/BoardPaging.vue";
import { mapState } from "vuex";
export default {
  components: {
    BoardListItem,
    BoardPaging,
  },
  data() {
    return {
      BoardInfoObj: {
        pg: 1,
        key: "",
        word: "",
      },
      optionitems: [
        { text: "이름", value: "id" },
        { text: "제목", value: "subject" },
        { text: "내용", value: "contents" },
      ],
    };
  },
  computed: {
    ...mapState(["boards", "pagenavi"]),
  },
  created() {
    let pg = this.BoardInfoObj.pg;
    let key = this.BoardInfoObj.key;
    let word = this.BoardInfoObj.word;
    let getboardarr = [pg, key, word];
    this.$store.dispatch("getBoardList", getboardarr);
  },

  methods: {
    updatepage(newpg) {
      let pg = newpg;
      let key = this.BoardInfoObj.key;
      let word = this.BoardInfoObj.word;
      let getboardarr = [pg, key, word];
      this.$store.dispatch("getBoardList", getboardarr);
    },

    search() {
      let pg = this.BoardInfoObj.pg;
      let key = this.BoardInfoObj.key;
      let word = this.BoardInfoObj.word;
      let getboardarr = [pg, key, word];
      this.$store.dispatch("getBoardList", getboardarr);
    },
  },
};
</script>

<style></style>
