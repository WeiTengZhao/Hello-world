<?php
    /**
    *@ Author:Shao
    *@ Date: 2017-01-13
    *@ Despriction:控制器主要调用模型，调用视图，将模型返回的数据传给视图显示
    */
    class testController {
        function show(){
            global $view;//将index中的view变量引入
            $testModel = M('test');
            $data = $testModel -> get();//获取模型返回数据
//            $testView = V('test');//选取视图，实例化对象
//            $testView -> display($data);
            $view -> assign('str','哈哈哈');
            $view -> display('test.tpl');
        }
    }
?>
