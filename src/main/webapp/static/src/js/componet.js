window.SYS = {
    loadMenu: function(){ //动态加载菜单
        App.get(Route.sys.menu, null, function(result){
            if(Const.SUCCESS == result.resultState){
                var data = result.data;
                var $sideMenu = $('#side-menu');
                var dataIndex = -1;
                if(data.length > 0){
                    for(var i = 0; i < data.length; i++){
                        var menu = data[i];
                        var menuHTML = '<li>';

                        menuHTML += '\
                    <a href="#">\
                    <i class="'+menu.iconClass+'"></i>\
                    <span class="nav-label">'+menu.name+'</span>';
                        var children = menu.children;
                        if(children && children.length > 0){
                            menuHTML += '<span class="fa arrow"></span></a>';
                            menuHTML += '<ul class="nav nav-second-level collapse">';
                            for(var j = 0; j < children.length; j++){
                                var child = children[j];
                                menuHTML +=  '<li>\
                                <a class="J_menuItem" href="'+child.href+'" data-index='+(dataIndex+1)+'><i class="'+child.iconClass+' x-second-level-icon"></i><span class="nav-label">'+child.name+'</span></a>\
                            </li>';
                            }
                            menuHTML += '</ul>';
                        } else {
                            menuHTML += '</a>';
                        }

                        menuHTML += '</li>';
                        $sideMenu.append(menuHTML);
                    }
                    // 激活菜单行为
                    $sideMenu.metisMenu();
                    // 动态加载一次以激活点击菜单后其内容被加载到contab中
                    jQuery.getScript("/static/lib/bootstrap/js/contabs.min.js")
                        .done(function() {

                        })
                        .fail(function() {
                            KitBox.alert(ErrMsg.failRenderMenu);
                        });
                }
            } else {
                KitBox.alert(ErrMsg.failMenu);
            }
        })
    }

};