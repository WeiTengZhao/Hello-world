<?php
    /**
    *@ Author:Shao
    *@ Date: 2017-01-24
    *@ Despriction:前台页面控制器
    */
    class indexController {
        function index() {
            $newsobj = M('news');
            $data = json_encode($newsobj -> get_news_list());
            VIEW::assign(array('data' => $data));
            VIEW::display('index/index.html');
        }
    }
?>
