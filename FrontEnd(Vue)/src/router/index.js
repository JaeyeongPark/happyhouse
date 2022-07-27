import Vue from "vue";
import VueRouter from "vue-router";
import HomeView from "@/views/HomeView.vue";
import BoardView from "@/views/BoardView.vue";
import BoardList from "@/components/board/BoardList.vue";
import BoardDetail from "@/components/board/BoardDetail.vue";
import BoardUpdate from "@/components/board/BoardUpdate.vue";
import BoardDelete from "@/components/board/BoardDelete.vue";
import BoardRegist from "@/components/board/BoardRegist.vue";
import HouseView from "@/views/HouseView.vue";
import HouseList from "@/components/House/HouseList.vue";
import UserView from "@/views/UserView.vue";
import LoginForm from "@/components/user/LoginForm.vue";
import UserRegist from "@/components/user/UserRegist.vue";
import UserDetail from "@/components/user/UserDetail.vue";
import FindPassword from "@/components/user/FindPassword.vue";
import NoticeView from "@/views/NoticeView.vue";
import FacilityView from "@/views/FacilityView.vue";
import InterestView from "@/views/InterestView.vue";
import NoticeList from "@/components/notice/NoticeList";
import FacilityList from "@/components/facility/FacilityList";
import FacilityDetail from "@/components/facility/FacilityDetail";
import InterestList from "@/components/interest/InterestList.vue";
import UserUpdate from "@/components/user/UserUpdate.vue";
import NoticeDetail from "@/components/notice/NoticeDetail.vue";
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
      {
        path: "update",
        name: "userupdate",
        component: UserUpdate,
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
        name: "boardlist",
        component: BoardList,
      },
      {
        path: "regist",
        name: "boardregist",
        component: BoardRegist,
      },
      {
        path: "detail/:no",
        name: "boarddetail",
        component: BoardDetail,
      },
      {
        path: "update/:no",
        name: "boardupdate",
        component: BoardUpdate,
      },
      {
        path: "delete/:no",
        name: "boarddelete",
        component: BoardDelete,
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
  {
    path: "/notice",
    name: "notice",
    component: NoticeView,
    redirect: "/notice/list",
    children: [
      {
        path: "list",
        name: "noticelist",
        component: NoticeList,
      },
      {
        path: "detail",
        name: "noticedetail",
        component: NoticeDetail,
      },
    ],
  },
  {
    path: "/facility",
    name: "facility",
    component: FacilityView,
    redirect: "/facility/list",
    children: [
      {
        path: "list",
        name: "facilitylist",
        component: FacilityList,
      },
      {
        path: "detail",
        name: "detail",
        component: FacilityDetail,
      },
    ],
  },
  {
    path: "/interest",
    name: "interest",
    component: InterestView,
    redirect: "/interest/list",
    children: [
      {
        path: "list",
        name: "list",
        component: InterestList,
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
