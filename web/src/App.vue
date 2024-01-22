<template>
  <div id="app">
    <TestIndex></TestIndex>
  </div>
</template>

<script>
import TestIndex from "@/components/TestIndex.vue";

export default {
  name: 'App',
  components: {
      TestIndex
  }
}
</script>

<style>
#app {
}

html,body {
    margin: 0px;
}
</style>
