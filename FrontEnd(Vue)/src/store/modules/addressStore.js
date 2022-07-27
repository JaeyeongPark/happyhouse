import {
  sidoList,
  gugunList,
  dongList,
  dongcode,
  Categoryvalue,
  getAllAddress,
} from "@/api/address.js";

const addressStore = {
  namespaced: true,
  state: {
    sidos: [{ value: null, text: "선택하세요" }],
    guguns: [{ value: null, text: "선택하세요" }],
    dongs: [{ value: null, text: "선택하세요" }],
    categorys: [
      { value: null, text: "선택하세요" },
      { value: "kinder", text: "유치원" },
      { value: "nursery", text: "어린이집" },
      { value: "school", text: "초등학교" },
      { value: "academy", text: "학원" },
      { value: "park", text: "공원" },
      { value: "protectionzone", text: "어린이보호구역" },
    ],
    categoryvalues: [{ value: null, text: "선택하세요" }],
    dongcode: "",
    dealYear: "",
    addresscondition: {
      sidoName: "",
      gugunName: "",
      dongName: "",
    },
    condition: {
      dongCode: "",
      category: "",
      categoryvalue: "",
    },
    alladdress: {
      sidoName: "",
      gugunName: "",
      dongName: "",
    },
  },
  getters: {},
  mutations: {
    SET_SIDO_LIST: (state, sidos) => {
      sidos.sidolist.forEach((sido) => {
        state.sidos.push({ value: sido.sidoName, text: sido.sidoName });
      });
    },
    SET_GUGUN_LIST: (state, guguns) => {
      guguns.gugunlist.forEach((gugun) => {
        if (gugun) {
          state.guguns.push({ value: gugun.gugunName, text: gugun.gugunName });
        }
      });
    },
    SET_DONG_LIST: (state, dongs) => {
      dongs.donglist.forEach((dong) => {
        if (dong) {
          state.dongs.push({ value: dong.dongName, text: dong.dongName });
        }
      });
    },
    SET_DONGCODE_LIST: (state, dongcode) => {
      if (dongcode) {
        state.dongcode = dongcode.dongcode.dongCode;
      }
    },
    SET_CATEGORYVALUES_LIST: (state, data) => {
      data.categoryvaluelist.forEach((categoryvalue) => {
        if (categoryvalue) {
          state.categoryvalues.push({
            value: categoryvalue,
            text: categoryvalue,
          });
        }
      });
    },
    SET_CONDITION_LIST: (state, condition) => {
      state.condition = condition;
    },
    CLEAR_SIDO_LIST: (state) => {
      state.sidos = [{ text: "선택하세요" }];
    },
    CLEAR_GUGUN_LIST: (state) => {
      state.guguns = [{ text: "선택하세요" }];
    },
    CLEAR_DONG_LIST: (state) => {
      state.dongs = [{ text: "선택하세요" }];
    },
    SET_SIDO: (state, data) => {
      state.addresscondition.sidoName = data;
    },
    SET_GUGUN: (state, data) => {
      state.addresscondition.gugunName = data;
    },
    SET_DONG: (state, data) => {
      state.addresscondition.dongName = data;
    },
    CLEAR_CATEGOTYVALUE_LIST: (state) => {
      state.categoryvalues = [{ text: "선택하세요" }];
    },
    SET_DEALYEAR_LIST: (state, data) => {
      state.dealYear = data;
    },
    SET_ADDRESS_NAME: (state, address) => {
      state.alladdress = address;
    },
    CLEAR_CONDITION_LIST(state) {
      state.condition = {
        dongCode: "",
        category: "",
        categoryvalue: "",
      };
      state.addresscondition = {
        sidoName: "",
        gugunName: "",
        dongName: "",
      };
    },
  },
  actions: {
    getAddressName: ({ commit }, dongcode) => {
      const params = {
        dongcode,
      };

      getAllAddress(
        params,
        ({ data }) => {
          commit("SET_ADDRESS_NAME", data);
        },
        (error) => {
          console.log("에러....");
          console.log(error);
        }
      );
    },
    getSido: ({ commit }) => {
      sidoList(
        ({ data }) => {
          commit("SET_SIDO_LIST", data);
        },
        (error) => {
          console.log(error);
        }
      );
    },
    getGugun: ({ commit }, sidoName) => {
      const params = {
        sido: sidoName,
      };
      gugunList(
        params,
        ({ data }) => {
          // console.log(commit, response);
          commit("SET_GUGUN_LIST", data);
        },
        (error) => {
          console.log(error);
        }
      );
    },
    getDong: ({ commit }, arr) => {
      const params = {
        sido: arr[0],
        gugun: arr[1],
      };
      dongList(
        params,
        ({ data }) => {
          // console.log(commit, response);
          commit("SET_DONG_LIST", data);
        },
        (error) => {
          console.log(error);
        }
      );
    },
    getDongcode: ({ commit }, arr) => {
      const params = {
        sido: arr[0],
        gugun: arr[1],
        dong: arr[2],
      };
      dongcode(
        params,
        ({ data }) => {
          // console.log(commit, response);
          commit("SET_DONGCODE_LIST", data);
        },
        (error) => {
          console.log(error);
        }
      );
    },
    getCategoryvalue: ({ commit }, arr) => {
      const params = {
        dongCode: arr[0],
        category: arr[1],
      };
      Categoryvalue(
        params,
        ({ data }) => {
          commit("SET_CATEGORYVALUES_LIST", data);
        },
        (error) => {
          console.log(error);
        }
      );
    },
    search: ({ commit }, condition) => {
      commit("SET_CONDITION_LIST", condition);
    },
    aptsearch: ({ commit }, condition) => {
      commit("SET_CONDITION_LIST", condition.dongCode);
      commit("SET_DEALYEAR_LIST", condition.dealYear);
    },
  },
};

export default addressStore;
