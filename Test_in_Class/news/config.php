<?php
/**
*@ Author:Shao
*@ Date: 2017-01-18
*@ Despriction: 配置文件，存放初始化配置
*/
    $config = array(
        /************Smarty的五项基础配置***********/
        'viewconfig' => array(
                'left_delimiter' => '{',//定义Smarty的左界定符
                'right_delimiter' => '}',//定义Smarty的右界定符
                'compile_dir' => 'template_c',//定义Smarty模板编译存储目录
                'template_dir' => 'tpl',//html模板地址
                'cache_dir' => 'cache' //缓存地址
              ),
        /********************************************/

        /*************DB的配置信息*******************/
        'dbconfig' => array(
                'dbhost' => 'localhost',
                'dbuser' => 'notebook',
                'dbpsw' => '19931117',
                'dbname' => 'test2',
                'dbcharset' => 'utf8'
            )
    );
    /********************************************/
?>
