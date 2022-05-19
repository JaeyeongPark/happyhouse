<template>
  <v-app id="inspire">
    <header-nav></header-nav>

    <v-main class="grey lighten-3">
      <router-view></router-view>
    </v-main>
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
<style scoped>
#inspire {
  height: 900px;
}
</style>
