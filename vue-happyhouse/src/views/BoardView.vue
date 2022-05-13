<template>
  <v-main class="grey lighten-4">
    <v-container>
      <v-row>
        <v-col>
          <v-sheet min-height="300vh" rounded="lg">
            <router-view></router-view>
          </v-sheet>
        </v-col>
      </v-row>
    </v-container>
  </v-main>
</template>

<script>
export default {};
</script>

<style></style>
