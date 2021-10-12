import Vue from 'vue'
import App from './App.vue'

import router from "./router"
import store from "./store/store"

//Bootstrap-vue
import { BootstrapVue, BootstrapVueIcons } from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

//Firebase
import firebase from "firebase/app";
// Your web app's Firebase configuration
const firebaseConfig = {
  apiKey: "AIzaSyDN8J_kKVYC9uIEuQ43B8FNB8bo2jk7ApY",
  authDomain: "projeto-alfa-e1490.firebaseapp.com",
  projectId: "projeto-alfa-e1490",
  storageBucket: "projeto-alfa-e1490.appspot.com",
  messagingSenderId: "981984895516",
  appId: "1:981984895516:web:3ed20bd8c7ba02ea71f5d9"
};

// Initialize Firebase
firebase.initializeApp(firebaseConfig);

firebase.auth().onAuthStateChanged(user => {
  user ? sessionStorage.setItem("user", user.uid) :  sessionStorage.removeItem("user");
})

Vue.use(BootstrapVue)
Vue.use(BootstrapVueIcons)

Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: h => h(App),
}).$mount('#app')
