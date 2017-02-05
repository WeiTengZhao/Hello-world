<?php
    /**
    *@ Author:Shao
    *@ Date: 2017-01-16
    *@ Despriction: 入库文件的处理函数
    */

    function C($name,$method) { //控制器调用函数
        require_once ('libs/Controller/'.$name.'Controller.class.php');//引入控制器文件
        eval('$obj = new '.$name.'Controller(); $obj -> '.$method.'();');//实例化控制器对象并调用方法
    }
//    C('test','show');

    function M($name) {//模型调用函数
        $obj = null;
        require_once ('libs/Model/'.$name.'Model.class.php');
        eval('$obj = new  '.$name.'Model();');
        return $obj;
    }

    function V($name) {//视图调用函数
        $obj = null;
        require_once ('libs/View/'.$name.'View.class.php');
        eval('$obj = new '.$name.'View();');
        return $obj;
    }

    function daddslashes($str) {//字符串转义函数
        return (!get_magic_quotes_gpc()) ? addslashes($str) : $str;
    }

    function ORG($path,$name,$params = array()) {//第三方类调用函数，path是第三方类路径，name是类名,params是初始化配置
        $obj = null;
        require_once ('libs/ORG/'.$path.''.$name.'.class.php');//引入第三方类
        eval('$obj = new '.$name.'();');//初始化第三方类
        if(!empty($params)) {//若配置内容不为空哦，则重新进行初始化
            foreach ($params as $key => $value) {
//                eval(''.$obj.' -> '.$key.' = \''.$value.'\';');
                  $obj -> $key = $value;
            }
        }
        return $obj;
    }

?>