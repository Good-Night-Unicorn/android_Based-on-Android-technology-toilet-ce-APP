import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
    import gongcexinxi from '@/views/modules/gongcexinxi/list'
    import news from '@/views/modules/news/list'
    import yuangong from '@/views/modules/yuangong/list'
    import kengweiqingjie from '@/views/modules/kengweiqingjie/list'
    import kaoqinjilu from '@/views/modules/kaoqinjilu/list'
    import storeup from '@/views/modules/storeup/list'
    import discusskengwei from '@/views/modules/discusskengwei/list'
    import discussgongcexinxi from '@/views/modules/discussgongcexinxi/list'
    import qingjieshenqing from '@/views/modules/qingjieshenqing/list'
    import quyu from '@/views/modules/quyu/list'
    import yonghu from '@/views/modules/yonghu/list'
    import messages from '@/views/modules/messages/list'
    import kengwei from '@/views/modules/kengwei/list'
    import kengweishiyong from '@/views/modules/kengweishiyong/list'
    import config from '@/views/modules/config/list'


//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }
      ,{
	path: '/gongcexinxi',
        name: '公厕信息',
        component: gongcexinxi
      }
      ,{
	path: '/news',
        name: '公告信息',
        component: news
      }
      ,{
	path: '/yuangong',
        name: '员工',
        component: yuangong
      }
      ,{
	path: '/kengweiqingjie',
        name: '坑位清洁',
        component: kengweiqingjie
      }
      ,{
	path: '/kaoqinjilu',
        name: '考勤记录',
        component: kaoqinjilu
      }
      ,{
	path: '/storeup',
        name: '我的收藏管理',
        component: storeup
      }
      ,{
	path: '/discusskengwei',
        name: '坑位评论',
        component: discusskengwei
      }
      ,{
	path: '/discussgongcexinxi',
        name: '公厕信息评论',
        component: discussgongcexinxi
      }
      ,{
	path: '/qingjieshenqing',
        name: '清洁申请',
        component: qingjieshenqing
      }
      ,{
	path: '/quyu',
        name: '区域',
        component: quyu
      }
      ,{
	path: '/yonghu',
        name: '用户',
        component: yonghu
      }
      ,{
	path: '/messages',
        name: '投诉建议',
        component: messages
      }
      ,{
	path: '/kengwei',
        name: '坑位',
        component: kengwei
      }
      ,{
	path: '/kengweishiyong',
        name: '坑位使用',
        component: kengweishiyong
      }
      ,{
	path: '/config',
        name: '轮播图管理',
        component: config
      }
    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
