/*左切换按钮的隐藏显示功能*/ 
$(function(){
    $(".box").on("mouseover",function(){
        var obj = $(".box-left");
        obj.css("visibility","visible")
    })
})
$(function(){
    $(".box").on("mouseout",function(){
        var obj = $(".box-left");
        obj.css("visibility","hidden")
    })
})
/*右切换按钮的隐藏显示功能*/ 
$(function(){
    $(".box").on("mouseover",function(){
        var obj = $(".box-right");
        obj.css("visibility","visible")
    })
})
$(function(){
    $(".box").on("mouseout",function(){
        var obj = $(".box-right");
        obj.css("visibility","hidden")
    })
})
/*自动轮播效果*/
$(function(){
    var index = 0;
    var f;
    function timetask(){
        f = setInterval(function(){
            if(index==$(".box-img").length-1) {
                index=0;
                $(".box-img").css("opacity","0");
                $(".box-img").eq(index%$(".box-img").length).css("opacity","1");
                $(".button").css("background-color","#ccc");
                $(".button").eq(index).css("background-color","#fff");
            }
            else {
                index++;
                $(".box-img").css("opacity","0");
                $(".box-img").eq(index%$(".box-img").length).css("opacity","1");
                $(".button").css("background-color","#ccc");
                $(".button").eq(index).css("background-color","#fff");
            }
        },4000)
    }
    timetask(); 
    /*左按钮切换效果*/
    $(".box-left").on("click",function(){
        clearInterval(f);
        if(index == 0) {
            index = $(".box-img").length-1;
            $(".box-img").css("opacity","0");
            $(".box-img").eq(index).css("opacity","1");
            $(".button").css("background-color","#ccc");
            $(".button").eq(index).css("background-color","#fff");
            timetask();
        }
        else {
            index--;
            $(".box-img").css("opacity","0");
            $(".box-img").eq(index).css("opacity","1");
            $(".button").css("background-color","#ccc");
            $(".button").eq(index).css("background-color","#fff");
            timetask();
        }   
    })
    /*右按钮切换效果*/
    $(".box-right").on("click",function(){
        clearInterval(f);
        if(index == $(".box-img").length-1) {
            index = 0;
            $(".box-img").css("opacity","0");
            $(".box-img").eq(index).css("opacity","");
            $(".button").css("background-color","#ccc");
            $(".button").eq(index).css("background-color","#fff");
            timetask();
        }
        else {
            index++;
            $(".box-img").css("opacity","0");
            $(".box-img").eq(index).css("opacity","1");
            $(".button").css("background-color","#ccc");
            $(".button").eq(index).css("background-color","#fff");
            timetask();
        }   
    })
    /*指定按钮切换*/
    $(".button").on("click",function(){
        clearInterval(f);
        var obj = $(this).index();
        index = obj;
        $(".box-img").css("opacity","0");
        $(".box-img").eq(index).css("opacity","1");
        $(".button").css("background-color","#ccc");
        $(".button").eq(index).css("background-color","#fff");
        timetask();
    })    
})