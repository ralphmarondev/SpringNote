import {createRouter, createWebHistory} from 'vue-router'
import {useAuthStore} from "@/stores/useAuthStore.ts";

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
    },
    {
      path: '/note-list',
      name: 'note-list',
      component: () => import('@/views/home/note-list/NoteListIndex.vue')
    }
  ],
})

router.beforeEach((to, from, next) => {
  const publicPages = ['login', 'register']
  const authRequired = !publicPages.includes(to.name as string)
  const authStore = useAuthStore()

  if (authRequired && !authStore.accessToken) {
    return next({name: 'login'})
  }
  next()
})

export default router
