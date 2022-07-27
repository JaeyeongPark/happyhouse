<template>
  <div id="home">
    <home-banner></home-banner>
  </div>
</template>

<script>
export default {
  data() {
    return {
      colors: [
        "indigo",
        "warning",
        "pink darken-2",
        "red lighten-1",
        "deep-purple accent-4",
      ],
      slides: ["First", "Second", "Third", "Fourth", "Fifth"],
    };
  },
  components: {
    // About: () => import("@/components/home/About"),
    HomeBanner: () => import("@/components/home/HomeBanner.vue"),
  },
};
</script>
