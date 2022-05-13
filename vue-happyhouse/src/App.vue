<template>
  <v-app id="inspire">
    <header-nav></header-nav>
    <router-view></router-view>
  </v-app>
</template>

<script>
import HeaderNav from "@/components/HeaderNav.vue";

export default {
  name: "App",
  components: {
    HeaderNav,
  },

  data: () => ({
    //
  }),
};
</script>
