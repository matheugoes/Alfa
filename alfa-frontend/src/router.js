import Vue from "vue";
import VueRouter from "vue-router";
import ScreenStructure from "./screens/ScreenStructure";
import Welcome from "./screens/Welcome.vue";
import Login from "./screens/Login.vue";
import SignUp from "./screens/SignUp.vue";
import SignUpStudent from "./screens/SignUpStudent.vue";
import SignUpTeacher from "./screens/SignUpTeacher.vue";
import Modules from "./screens/Modules.vue";
import Home from "./screens/Home.vue";
import Activities from "./screens/Activities.vue";
import Invite from "./screens/Invite.vue"

Vue.use(VueRouter);

const routes = [
	{path: "", component: Welcome},
	{path: "/alfa/invite/:classData", component: Invite},
	{path: "/home", component: Home,  meta: { authRequired: true },},
	{path: "/", component: ScreenStructure, children: [
		{path: "/login", component: Login},
		{path: "/signup", component: SignUp},
    { path: "/modules", component: Modules, meta: { authRequired: true } },
    { path: "/modules/:moduleId/activities", component: Activities, props: true },
		{path: "/signup/student", component: SignUpStudent},
		{path: "/signup/student/:classId", component: SignUpStudent},
		{path: "/signup/teacher", component: SignUpTeacher},
	]},
]

const router = new VueRouter({
  mode: "history",
  routes,
});

router.beforeEach((to, from, next) => {
  if (to.matched.some((record) => record.meta.authRequired)) {
    if (sessionStorage.getItem("user")) {
      next();
    } else {
      next({
        path: "/",
      });
    }
  } else {
    next();
  }
});

export default router;
