<template>
  <tr class="text-center">
    <td style="width: 100px">{{ article.noticeno }}</td>
    <!-- <th class="text-center"><v-divider vertical></v-divider></th> -->
    <td style="width: 500px; text-align: center">
      <router-link
        :to="{ name: 'noticedetail', params: { no: article.noticeno } }"
        >{{ article.subject }}</router-link
      >
    </td>
    <!-- <td><v-divider vertical></v-divider></td> -->
    <td style="width: 300px">{{ article.joindate }}</td>

    <!-- <td><v-divider vertical></v-divider></td> -->

    <!-- <td><v-divider vertical></v-divider></td> -->

    <!-- <td><v-divider vertical></v-divider></td> -->
  </tr>
</template>

<script>
export default {
  props: {
    article: Object,
  },
};
</script>

<style></style>
