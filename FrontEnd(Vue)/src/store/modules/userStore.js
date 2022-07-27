import jwt_decode from "jwt-decode";
// import http from "@/api/http.js";
import {
  login,
  confirminterest,
  findById,
  userinterdelete,
  userinterlist,
  deleteUser,
  updateUser,
} from "@/api/user.js";
import { userinterregist } from "@/api/user.js";
const userStore = {
  namespaced: true,
  state: {
    isLogin: false,
    isLoginError: false,
    isinterest: false,
    userInfo: null,
    userinterest: [],
    intermarkercenter: {},
    facilmarkercenter: {},
    isinterdelete: false,
    isinterregist: false,
  },
  getters: {
    checkUserInfo: function (state) {
      return state.userInfo;
    },
  },
  mutations: {
    SET_IS_LOGIN: (state, isLogin) => {
      console.log(isLogin);
      state.isLogin = isLogin;
    },
    SET_IS_LOGIN_ERROR: (state, isLoginError) => {
      state.isLoginError = isLoginError;
    },
    SET_USER_INFO: (state, userInfo) => {
      state.isLogin = true;
      state.userInfo = userInfo;
    },
    SET_USERINTER_CONFIRM: (state) => {
      state.isinterest = true;
    },
    CLEAR_USERINTER_CONFIRM: (state) => {
      state.isinterest = false;
    },
    SET_USERINTER_LIST: (state, data) => {
      state.userinterest = data;
    },
    SET_INTERMARKER_CENTER: (state, data) => {
      state.intermarkercenter = data;
    },
    SET_FACILMARKER_CENTER: (state, data) => {
      state.facilmarkercenter = data;
    },
    SET_INTERDELETE: (state) => {
      console.log("3번들어가고");
      state.isinterdelete = true;
      state.isinterregist = false;
    },
    SET_INTERREGIST: (state) => {
      state.isinterregist = true;
      state.isinterdelete = false;
    },
  },
  actions: {
    async userConfirm({ commit }, user) {
      await login(user, (response) => {
        if (response.data.message === "success") {
          let token = response.data["access-token"];
          commit("SET_IS_LOGIN", true);
          commit("SET_IS_LOGIN_ERROR", false);
          sessionStorage.setItem("access-token", token);
        } else {
          commit("SET_IS_LOGIN", false);
          commit("SET_IS_LOGIN_ERROR", true);
        }
      });
    },
    getUserInfo({ commit }, token) {
      let decode_token = jwt_decode(token);
      findById(decode_token.id, (response) => {
        if (response.data.message === "success") {
          commit("SET_USER_INFO", response.data.userInfo);
        } else {
          console.log("유저 정보 없음!!");
        }
      });
    },
    interestregist({ commit }, data) {
      userinterregist(data, (response) => {
        commit("SET_INTERREGIST", response);
      });
    },
    interestdelete({ commit }, data) {
      userinterdelete(data, (response) => {
        console.log("2번들어가고");
        commit("SET_INTERDELETE", response);
      });
    },
    interestlist({ commit }, data) {
      userinterlist(data, (response) => {
        commit("SET_USERINTER_LIST", response.data.userinterdelist);
      });
    },
    isinterestfacility({ commit }, data) {
      confirminterest(data, (response) => {
        if (response.data.message === "success") {
          commit("SET_USERINTER_CONFIRM");
        }
      });
    },
    deleteuser({ commit }, data) {
      deleteUser(data, (response) => {
        console.log(response);
        commit("SET_IS_LOGIN", false);
        commit("SET_USER_INFO", null);
        sessionStorage.removeItem("access-token");
      });
    },
    updateuser({ commit }, data) {
      console.log("data:" + data);
      updateUser(data, (response) => {
        console.log("response" + response);
        commit("SET_USER_INFO", response.data.userInfo);
      });
    },
  },
};

export default userStore;
