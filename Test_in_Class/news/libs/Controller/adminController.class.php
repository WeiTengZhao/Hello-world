<?php
/**
*@ Author:Shao
*@ Date: 2017-01-22
*@ Despriction: 后台的控制器文件
*/

    class adminController {
        public $auth = '';

        public function __construct() {//admin控制器的构造函数
            //判断当前是否已经登录，放到auth模型中处理

            //如果没有登录且不在登录也，则跳转回登录页
            $authobj = M('auth');
            $this -> auth = $authobj -> getauth();
            if(empty($this -> auth) && (SHAO::$method != 'login')) {
                $this -> showmessage('请登录后再操作!','admin.php?controller=admin&method=login');
            }

        }


        public function login()
        {
            if ($_POST) {
                //进行登录处理,业务逻辑放在 admin auth
                //admin同表名模型:从数据库里取用户信息
                //auth模型:核对用户信息
                $this -> checklogin();
            } else{
                VIEW::display('admin/login.html');//显示登录界面
            }
        }

        private function checklogin() {
            $authobj = M('auth');
            if($authobj -> loginsubmit()) {
                $this -> showmessage('登录成功!','admin.php?controller=admin&method=index');//登录成功跳转页面
            }else {
                $this -> showmessage('登录失败！','admin.php?controller=admin&method=login');//登录失败返回原页面
            }
        }


        public function index() { //登录后后台首页显示函数
            $newsobj = M('news');
            $newsnum = $newsobj -> count();
            VIEW::assign(array('newsnum' => $newsnum));
            VIEW::display('admin/index.html');
        }

        public function logout(){//退出登录的方法
            $authobj = M('auth');
            $authobj -> logout();
            $this -> showmessage('退出成功','admin.php?controller=admin&method=login');
        }

        private function showmessage($info, $url){//显示提示信息函数
            echo "<script>alert('$info');window.location.href='$url'</script>";
            exit;
        }

        public function newsadd() {//添加新闻的方法
            //判断是否有POST数据
            if(empty($_POST)) {//没有POST数据，停留在添加、修改的界面
                //修改操作时要读取旧的信息,业务逻辑放在newsModel
                if (isset($_GET['id'])) {//判断是否有id传入，有则是修改，读取新闻
                    $data = M('news') -> getnewsinfo($_GET['id']);
                }else {//没有则是添加
                    $data = array();
                }
                VIEW::assign(array('data' => $data));//向视图框架注册变量
                VIEW::display('admin/newsadd.html');//显示新闻添加页面
            }else {//进入对数据库添加、修改的函数
                $this -> newssubmit();
                $this -> imagesubmit();
            }
        }
        private function newssubmit() {
            $result = M('news') -> newssubmit($_POST);//实例化模型并调用新闻提交处理函数
            if ($result == 0) {
                $this -> showmessage("操作失败",'admin.php?controller=admin&method=newsadd&id='.$_POST['id']);
            }
            if($result == 1) {
                $this -> showmessage("添加成功",'admin.php?controller=admin&method=newslist');
            }
            if($result == 2) {
                $this -> showmessage("修改成功",'admin.php?controller=admin&method=newslist');
            }
        }

        public function newslist() {//显示新闻列表函数
            $newsobj = M('news');//实例化模型
            $data = $newsobj -> find_orderby_dateline();//调用函数获取内容
            VIEW::assign(array('data' => $data));//视图引擎注册变量
            VIEW::display('admin/newslist.html');//视图引擎显示页面
        }

        public function newsdel() {
            if(intval($_GET['id'])) {
                $newsobj = M('news');
                $newsobj -> del_by_id($_GET['id']);
                $this -> showmessage("删除成功",'admin.php?controller=admin&method=newslist');
            }
        }
        function test() {
            echo 'hello world';
        }
    }
?>
