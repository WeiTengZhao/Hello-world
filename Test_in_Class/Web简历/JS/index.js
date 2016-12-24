$(function(){
	$('#dowebok').fullpage({
		'navigation':true,//显示侧边栏
		'navigationTooltips':['首页','关于我','专业技能','工作经历','联系我'],//侧边标签
		'scrollingSpeed':400, //设置滚动速度
		afterRender:function(){
			$("#home_title").css({"margin-top":"100px"});
			$("#home_info1").fadeIn(700,function(){
				$(this).next().animate({width:"800px"},700,function(){
					$("#home_info2").fadeIn(700,function(){
						$(this).next().fadeIn(450,function(){
							$(this).next().fadeIn(450,function(){
								$(this).next().fadeIn(150)
							})
						})
					})
				})	
			});
		},
		afterLoad:function(anchorLink,index){
			if(index == 2) {
				$("#about_content h1").after("<div class='title_text'><h2>About Me</h2></div>");
				$(".title_text").animate({width:"130px"},700,function(){
					$(".title_text h2").slideDown(400);
				});
				$("#about_info").animate({width:"800px",marginTop:"0",marginBottom:"0"},700,function(){
					$("#about_info p").eq(0).animate({bottom:"0"},700,function(){
						$("#about_info p").eq(1).animate({bottom:"0"},700,function(){
							$("#about_info p").eq(2).animate({bottom:"0"},700);
						});
					});
				});
			}
			if(index == 3) {
				$("#skill_content h1").after("<div class='title_text'><h2>My Skill</h2></div>");
				$(".title_text").animate({width:"130px"},700,function(){
					$(".title_text h2").slideDown(400);
				});
			}
			if(index == 4) {
				$("#exp_content h1").after("<div class='title_text'><h2>My Expression</h2></div>");
				$(".title_text").animate({width:"130px"},700,function(){
					$(".title_text h2").slideDown(400);
				});
				$("#exp_info p").animate({bottom:"0"},700);
			}
			if(index == 5) {
				$("#contact_content h1").after("<div class='title_text'><h2>Contact Me</h2></div>");
				$(".title_text").animate({width:"130px"},700,function(){
					$(".title_text h2").slideDown(400);
				});
			}

		},
		onLeave:function(index) {
			if(index==2||index==3||index==4||index==5||index==6){
				$(".title_text").remove();
			}
		},
	});
//第一屏鼠标移过换头像
	$("#title_image2").hover(function(){
		$(this).fadeTo(800,1);
	},function(){
		$(this).stop(true,false).fadeTo(800,0);
	});
//第四屏时光轴鼠标移过显示
	var x=10;
	var y=20;
	$("#exp_timeline a").mouseover(function(e){
		this.aa=this.title;
		this.title="";
		$("body").append("<div class='exp_timeline_title'>"+this.aa+"</div>");	
		$(".exp_timeline_title").css({
			"top":e.pageY+y+"px",
			"left":e.pageX+x+"px"
		}).show("fast");
	}).mouseout(function(){
		this.title=this.aa;
		$(".exp_timeline_title").remove();
	}).mousemove(function(e){
		$(".exp_timeline_title").css({
			"top":e.pageY+y+"px",
			"left":e.pageX+x+"px"
		});
	}).click(function(){
		var p = $(this).index() * 1000;
		$("#exp_list_content").animate({right:p},200,function(){
			return false;
		});	
	});
// 点击留言
	$("#contact_message1").click(function(){
		$(this).avgrund({
			height: 200,
			holderClass: 'custom',
			showClose: true,
			showCloseText: 'close',
			onBlurContainer: '.container',
			template: '<p>感谢您浏览本网站，希望你们能够联系我</p>' +
			'<div>' +
			'<a href="https://github.com/WeiTengZhao/helloworld" target="_blank" class="github">Github</a>' +
			'<a href="http://qm.qq.com/cgi-bin/qm/qr?k=yMZ2n_w_GA3BgoZjkdPT4GJW-l_6RRui" target="_blank" class="qq">QQ</a>' +
			'<a href="http://weibo.com/u/3957165566?refer_flag=1001030102_&is_all=1" target="_blank" class="weibo">微博</a>' +
			'</div>'
		});
	});
});
