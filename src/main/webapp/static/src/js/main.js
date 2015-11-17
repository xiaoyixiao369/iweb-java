$(function($){
    // 加载菜单
    SYS.loadMenu();

    // tab栏退出
    $('.x-logout').on('click', function(){
        layer.confirm('确定要退出?', {icon: 3, title:'提示'}, function(index){
            window.location.href = 'logout';
            layer.close(index);
        });
    });
});