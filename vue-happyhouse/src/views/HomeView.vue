<template>
  <v-main>
    <!-- 움직이는 화면 시작 -->
    <!-- <v-carousel
      cycle
      height="400"
      hide-delimiter-background
      show-arrows-on-hover
    >
      <v-carousel-item v-for="(slide, i) in slides" :key="i">
        <v-sheet :color="colors[i]" height="100%">
          <v-row class="fill-height" align="center" justify="center">
            <div class="text-h2">{{ slide }} Slide</div>
          </v-row>
        </v-sheet>
      </v-carousel-item>
    </v-carousel> -->
    <!-- 움직이는 화면 끝 -->
    <v-img src="@/assets/img/풍경.jpg" aspect-ratio="2.3"></v-img>

    <v-sheet height="500px" color="grey">
      <v-responsive class="overflow-y-hidden" max-height="600">
        <v-responsive vh="200"></v-responsive>
        <v-lazy
          v-model="isActive"
          :options="{
            threshold: 1.0,
          }"
          min-height="200"
          transition="fade-transition"
        >
          <v-card class="mx-auto" max-width="336">
            <v-card-title>Card title</v-card-title>

            <v-card-text>
              Phasellus magna. Quisque rutrum. Nunc egestas, augue at
              pellentesque laoreet, felis eros vehicula leo, at malesuada velit
              leo quis pede. Aliquam lobortis. Quisque libero metus, condimentum
              nec, tempor a, commodo mollis, magna. In turpis. In dui magna,
              posuere eget, vestibulum et, tempor auctor, justo. In turpis.
              Pellentesque dapibus hendrerit tortor. Ut varius tincidunt libero.
            </v-card-text>
          </v-card>
        </v-lazy>
      </v-responsive>
    </v-sheet>
    <v-sheet height="350px"></v-sheet>
    <v-sheet height="350px" color="black"></v-sheet>
  </v-main>
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
      isActive: false,
    };
  },
};
</script>
<style scoped></style>
