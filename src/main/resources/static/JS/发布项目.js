/*加载Layui的laydate模块*/
$(function(){
    layui.use('laydate', function(){
        var laydate = layui.laydate;

        //执行一个laydate实例
        laydate.render({
            elem: '#time' //指定元素
        });
    });
})
