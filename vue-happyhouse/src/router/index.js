import Vue from "vue";
import VueRouter from "vue-router";
import HomeView from "@/views/HomeView.vue";
import BoardView from "@/views/BoardView.vue";
import BoardList from "@/components/board/BoardList.vue";
import BoardDetail from "@/components/board/BoardDetail.vue";
import BoardModify from "@/components/board/BoardModify.vue";
import BoardDelete from "@/components/board/BoardDelete.vue";
import BoardRegist from "@/components/board/BoardRegist.vue";
import HouseView from "@/views/HouseView.vue";
import HouseList from "@/components/House/HouseList.vue";
import UserView from "@/views/UserView.vue";
import LoginForm from "@/components/user/LoginForm.vue";
import UserRegist from "@/components/user/UserRegist.vue";
import UserDetail from "@/components/user/UserDetail.vue";
import FindPassword from "@/components/user/FindPassword.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "home",
    component: HomeView,
  },
  {
    path: "/login",
    name: "login",
    component: LoginForm,
  },
  {
    path: "/user",
    name: "user",
    component: UserView,
    redirect: "/",
    children: [
      {
        path: "regist",
        name: "userregist",
        component: UserRegist,
      },
      {
        path: "detail",
        name: "userdetail",
        component: UserDetail,
      },
      {
        path: "findpw",
        name: "findpw",
        component: FindPassword,
      },
    ],
  },
  {
    path: "/board",
    name: "board",
    component: BoardView,
    redirect: "/board/list",
    children: [
      {
        path: "list",
        name: "list",
        component: BoardList,
      },
      {
        path: "detail/:no",
        name: "detail",
        component: BoardDetail,
      },
      {
        path: "modify/:no",
        name: "modify",
        component: BoardModify,
      },
      {
        path: "delete/:no",
        name: "delete",
        component: BoardDelete,
      },
      {
        path: "regist",
        name: "regist",
        component: BoardRegist,
      },
    ],
  },
  {
    path: "/house",
    name: "house",
    component: HouseView,
    redirect: "/house/list",
    children: [
      {
        path: "list",
        name: "list",
        component: HouseList,
      },
    ],
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
