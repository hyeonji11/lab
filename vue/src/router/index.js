import {createRouter, createWebHistory} from "vue-router";

const router = createRouter({
    history: createWebHistory(""),
    routes: [
        {
            path: "/",
            name: "main",
            component: () => import("../components/HelloWorld.vue"),
        },
        {
            path: "/login",
            name: "login",
            component: () => import("../Login.vue"),
        },
        {
            path: "/oauth2/redirect",
            name: "loginSuccess",
            component: () => import("../components/LoginSuccess.vue"),
        },
    ],
});
export default router;