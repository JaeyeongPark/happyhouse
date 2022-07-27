<template>
  <v-footer color="blue lighten-4">
    <v-card
      flat
      tile
      width="100%"
      class="blue lighten-4 text-center"
      light
      style="font-weight: bold"
    >
      <!-- <v-card-text class="white--text">
        {{ new Date().getFullYear() }} — <strong>HappyHouseProject</strong>
      </v-card-text> -->

      <!-- <hr /> -->
      <v-container>
        <v-row>
          <v-col>
            <v-img
              max-width="100"
              max-height="80"
              src="@/assets/img/SSAFY.jpg"
            />
          </v-col>
          <v-col class="text-right">
            <v-row>
              <p>(SSAFY)서울시 강남구 테헤란로 멀티스퀘어</p>
            </v-row>
            <v-row class="text-right">
              <p>1544-9001</p>
            </v-row>
          </v-col>
        </v-row>
      </v-container>
    </v-card>
  </v-footer>
</template>

<script>
export default {};
</script>

<style></style>
