import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/components/Home'
import BoardList from '@/components/board/BoardList'
import BoardModify from '@/components/board/BoardModify'
import BoardWrite from '@/components/board/BoardWrite'
import BoardDetail from '@/components/board/BoardDetail'

Vue.use(Router)

export default new Router({
  mode:'history',
  routes: [
    {
      path: '/',
      name: 'Home',
      component: Home
    },
    {
      path: '/boardlist',
      name: 'BoardList',
      component: BoardList
    },
    {
      path: '/boardmodify/:id',
      name: 'board-modify',
      component: BoardModify,
      props:true
    },
    {
      path: '/boardwrite',
      name: 'BoardWrite',
      component: BoardWrite
    },
    {
      path: '/boarddetail/:id',
      name: 'board-detail',
      component: BoardDetail,
      props:true
    }
  ]
})
