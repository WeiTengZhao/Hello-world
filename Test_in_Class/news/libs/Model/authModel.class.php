<?php
/**
*@ Author:Shao
*@ Date: 2017-01-22
*@ Despriction: 用于验证管理员帐户的模型
*/
    class authModel {
        private $auth = '';//存放当前登录管理员的信息

        public function __construct() {//authModel的构造函数
            if(isset($_SESSION['auth']) && (!empty($_SESSION['auth']))) {
                $this -> auth = $_SESSION['auth'];
            }
        }

        public function loginsubmit() {//进行登录验证的一系列业务逻辑
            if(empty($_POST['username']) || empty($_POST['password'])) {//检验用户名和密码是否为空
                return false;
            }
            $username = daddslashes($_POST['username']);//对用户名和密码字符串进行转义
            $password = daddslashes($_POST['password']);

            if($this -> auth = $this -> checkuser($username,$password)) {
                $_SESSION['auth'] = $this -> auth;
                return true;
            }else {
                return false;
            }
        }

        private function checkuser($username,$password) {//验证用户名和密码的函数
            $adminobj = M('admin');
            $auth = $adminobj -> findOne_by_username($username);
            if((!empty($auth)) && $auth['password'] == $password) {
                return $auth;
            }else{
                return false;
            }
        }

        public function logout() { //退出登录操作，释放SESSION，并且把存放当前登录对象内容置为空
            unset($_SESSION['auth']);
            $this -> auth = '';
        }

        public function getauth() {
            return $this -> auth; //返回auth的值使外部能够接收
        }
    }
?>
