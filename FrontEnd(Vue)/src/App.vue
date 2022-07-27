<template>
  <v-app id="inspire">
    <header-nav></header-nav>

    <v-main>
      <v-sheet height="50px" class="grey lighten-3"></v-sheet>
      <router-view></router-view>
      <v-sheet height="50px" class="grey lighten-3"></v-sheet>
    </v-main>

    <footer-nav></footer-nav>
  </v-app>
</template>

<script>
import HeaderNav from "@/components/layout/HeaderNav.vue";
import FooterNav from "@/components/layout/FooterNav.vue";
export default {
  name: "App",
  components: {
    HeaderNav,
    FooterNav,
  },
  watch: {
    $route() {
      window.scrollTo(0, 0);
    },
  },
};
</script>
<style>
#inspire {
  height: 900px;
}
button {
  font-family: "SuseongDotum";
}
@font-face {
  font-family: "SuseongDotum";
  src: url("@/assets/fonts/SuseongDotum.ttf") format("truetype");
  font-weight: 700;
}
@font-face {
  font-family: "Regular";
  src: url("@/assets/fonts/Regular.ttf") format("truetype");
  font-weight: 700;
}
@font-face {
  font-family: "Bold";
  src: url("@/assets/fonts/Bold.ttf") format("truetype");
  font-weight: 700;
}
@font-face {
  font-family: "Cafe24Ssurround";
  src: url("@/assets/fonts/Cafe24Ssurround.ttf") format("truetype");
  font-weight: 700;
}
@font-face {
  font-family: "Cafe24SsurroundAir";
  src: url("@/assets/fonts/Cafe24SsurroundAir.ttf") format("truetype");
  font-weight: 700;
}
@font-face {
  font-family: "KITA";
  src: url("@/assets/fonts/KITA.ttf") format("truetype");
  font-weight: 700;
}
@font-face {
  font-family: "HSSantokki-Regular";
  src: url("@/assets/fonts/HSSantokki-Regular.ttf") format("truetype");
  font-weight: 700;
}
@font-face {
  font-family: "SBAgroB";
  src: url("@/assets/fonts/SBAgroB.ttf") format("truetype");
  font-weight: 700;
}
@font-face {
  font-family: "SBAgroL";
  src: url("@/assets/fonts/SBAgroL.ttf") format("truetype");
  font-weight: 700;
}
@font-face {
  font-family: "SBAgroM";
  src: url("@/assets/fonts/SBAgroM.ttf") format("truetype");
  font-weight: 700;
}
</style>
