import Vue from "vue";
import Vuex from "vuex";
import createPersistedState from "vuex-persistedstate";
Vue.use(Vuex);

import addressStore from "@/store/modules/addressStore.js";
import facilityStore from "@/store/modules/facilityStore.js";
import houseStore from "@/store/modules/houseStore.js";
import boardStore from "@/store/modules/boardStore.js";
import userStore from "@/store/modules/userStore.js";
import noticeStore from "@/store/modules/noticeStore.js";
const store = new Vuex.Store({
  modules: {
    addressStore,
    facilityStore,
    houseStore,
    boardStore,
    userStore,
    noticeStore,
  },
  plugins: [
    createPersistedState({
      // 브라우저 종료시 제거하기 위해 localStorage가 아닌 sessionStorage로 변경. (default: localStorage)
      paths: ["userStore"],
      storage: sessionStorage,
    }),
  ],
});
export default store;
