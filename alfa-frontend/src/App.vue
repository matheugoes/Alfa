<template>
  <div id="app">
    <router-view/>
  </div>
</template>

<script>
export default {
  name: 'App',
}
</script>

<style>
@import '~bootstrap-vue/dist/bootstrap-vue.css';

:root {
  --primary-btn-color: #FF8A0C;
  --primary-btn-palceholder-color: #828282;
  --primary-btn-focus-color: #4f4f4f;
  --primary-btn-color-hover: #CA8642;
  --primary-input-color: #F2F2F2;
}

html {
  height: 100%;
}

body {
  max-width: 600px;
  min-height: 100%;
  margin: 0 !important;
  padding: 0;
  margin: auto!important;;
}

.row {
  margin-right: 0 !important;
  margin-left: 0 !important;
}

#app {
  font-family: "Mulish";
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
</style>
