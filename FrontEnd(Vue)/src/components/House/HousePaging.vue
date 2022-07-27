<template>
  <ul class="pagination">
    <li class="page-item" data-pg="1">
      <button @click="updatepage(1)" class="page-link">최신</button>
    </li>
    <li class="page-item" :data-pg="pagenavi.prevPageVal">
      <button @click="updatepage(pagenavi.prevPageVal)" class="page-link">
        이전
      </button>
    </li>
    <template v-for="pg in pagenavi.pagenum">
      <li
        v-if="pageclassdecide(pg)"
        class="page-item active"
        :data-pg="pg"
        v-bind:key="pg"
      >
        <button @click="updatepage(pg)" class="page-link">{{ pg }}</button>
      </li>
      <li v-else class="page-item" :data-pg="pg" v-bind:key="pg">
        <button @click="updatepage(pg)" class="page-link">{{ pg }}</button>
      </li>
    </template>
    <li class="page-item" :data-pg="pagenavi.nextPageVal">
      <button @click="updatepage(pagenavi.nextPageVal)" class="page-link">
        다음
      </button>
    </li>
    <li class="page-item" :data-pg="pagenavi.totalPageCount">
      <button @click="updatepage(pagenavi.totalPageCount)" class="page-link">
        마지막
      </button>
    </li>
  </ul>
</template>

<script>
import { mapActions } from "vuex";
export default {
  props: {
    pagenavi: Object,
    HouseInfoObj: Object,
  },
  data() {
    return {
      pageclass: "",
    };
  },
  methods: {
    ...mapActions("houseStore", ["gethouselist"]),
    pageclassdecide(pg) {
      if (pg == this.pagenavi.currentPage) {
        return true;
      } else {
        return false;
      }
    },
    updatepage(newpg) {
      let conditions = this.HouseInfoObj;
      conditions.pg = newpg;
      this.gethouselist(conditions);
    },
  },
};
</script>

<style></style>
