<template>
  <v-main class="grey lighten-3 pt-3">
    <v-sheet class="grey lighten-3" height="700px">
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
                  <th class="text-center">작성일</th>
                  <!-- <v-divider vertical></v-divider> -->
                </tr>
              </thead>
              <tbody>
                <notice-list-item
                  v-for="article in noticies"
                  :key="article.no"
                  :article="article"
                ></notice-list-item>
              </tbody>
            </template>
          </v-simple-table>
        </v-card>
      </v-container>

      <v-container>
        <v-row>
          <v-col cols="3"></v-col>

          <v-col v-if="noticies && noticies.length != 0">
            <notice-paging
              :pagenavi="pagenavi"
              :BoardInfoObj="NoticeInfoObj"
              style="text-align: center"
            ></notice-paging>
          </v-col>
          <v-col v-else cols="6"></v-col>
        </v-row>
      </v-container>
    </v-sheet>
  </v-main>
</template>

<script>
import NoticeListItem from "@/components/notice/NoticeListItem";
import NoticePaging from "@/components/notice/NoticePaging.vue";
import { mapState, mapActions } from "vuex";

export default {
  components: {
    NoticeListItem,
    NoticePaging,
  },
  data() {
    return {
      NoticeInfoObj: {
        pg: 1,
      },
    };
  },

  computed: {
    ...mapState("noticeStore", ["noticies", "pagenavi"]),
  },
  created() {
    let pg = 1;
    this.getNoticeList(pg);
  },
  methods: {
    ...mapActions("noticeStore", ["getNoticeList"]),
  },
};
</script>

<style scopd>
td {
  text-align: center;
}
</style>
