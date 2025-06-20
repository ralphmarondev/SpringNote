import {createRouter, createWebHistory} from 'vue-router'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'login',
      component: () => import('@/views/auth/login/LoginIndex.vue'),
    },
    {
      path: '/register',
      name: 'register',
      component: () => import('@/views/auth/register/RegisterIndex.vue'),
    }
  ],
})

export default router
