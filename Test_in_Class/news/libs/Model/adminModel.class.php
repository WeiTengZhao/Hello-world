<?php
/**
*@ Author:Shao
*@ Date: 2017-01-22
*@ Despriction: 从管理员帐户表中取数据，验证登录是否成功
*/
    class adminModel {
        public $_table = 'admin';//定义表名，表示从admin表取数据

        function findOne_by_username($username) {//通过用户名取用户信息
            $sql = 'SELECT * FROM '.$this ->_table.' WHERE USERNAME="'.$username.'"';
            return DB::findOne($sql);
        }

        //用户密码核对在auth模型中进行
    }
