<template>
  <v-main class="grey lighten-3">
    <v-container>
      <v-row>
        <v-col>
          <v-sheet min-height="70vh" rounded="lg">
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
