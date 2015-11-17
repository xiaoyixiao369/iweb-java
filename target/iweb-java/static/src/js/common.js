'use strict';
// jQuery Ajax全局设置
$.ajaxSetup({
    timeout: 10000,
    contentType: 'applcation/json',
    dataType: 'json',
    headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
    },
    error: function (xhr, status, e) {
        var responseText = xhr.responseText;
        if(responseText.indexOf('<') > 0){
            toastr['error']('解析错误');
        } else {
            var errJSON = $.parseJSON(responseText);
            if(errJSON){
                toastr['error']('服务器错误: ' + errJSON.msg);
            } else {
                toastr['error']('未知错误');
            }
        }

    },
    beforeSend: function (xhr) {

    },
    complete: function (xhr) {

    }
});

// toastr设置
toastr.options = {
    "closeButton": false,
    "debug": false,
    "positionClass": "toast-top-center",
    "onclick": null,
    "showDuration": "300",
    "hideDuration": "1000",
    "timeOut": "5000",
    "extendedTimeOut": "1000",
    "showEasing": "swing",
    "hideEasing": "linear",
    "showMethod": "fadeIn",
    "hideMethod": "fadeOut"
};

window.Route = {
    sys: {
        menu: '/sys/menu'
    },
    bis: {
        businessOverview: {
            list: '/bis/businessOverview/list',
            updatedAt: '/bis/businessOverview/updatedAt'
        },
        goodsStatistical: {
            list: '/bis/goodsStatistical/list',
            updatedAt: '/bis/goodsStatistical/updatedAt'
        },
        goodsSaleDetail: {
            list: '/bis/goodsSaleDetail/list',
            updatedAt: '/bis/goodsSaleDetail/updatedAt'
        }
    }
};

window.ErrMsg = {
    failMenu: '加载菜单失败',
    failRenderMenu: '渲染菜单失败',
    noData: '当前选择的日期(段)没有查询到数据',
    dateNotBeNull: '日期不能为空',
    dateCanNotOverToday: '请输入昨天以前的日期',
    starstDateCanNotOverEndDate: '起始日期不能大于结束日期',
    twoManySearchWords: '输入的搜索词语太多了',
    errSNNumbers: '错误的商品SN编码集合,请注意逗号后没有空格',
    loadError: '加载错误'
};

window.Const = {
    SUCCESS: 'success',
    FAILURE: 'failure',
    DATA_UPDATED_TO: '数据已经更新至 '
};

window.NumberKit = {
    with2Precision: function(inputNum){
        if($.isNumeric(inputNum)){
            return numeral(inputNum).format('0.00');
        }
        return '';
    }
};

window.App = {
    util: {
        checkAjaxCallback: function (callback) {
            if (typeof(callback) != 'function') {
                throw "callback is not a function";
            }
            return true;
        }
    },
    get: function (url, data, callback) {
        App.util.checkAjaxCallback(callback);
        $.ajax({
            type: 'GET',
            url: url,
            data: data,
            success: function (resData) {
                callback(resData);
            }
        });
    },
    post: function (url, data, callback) {
        App.util.checkAjaxCallback(callback);
        $.ajax({
            type: 'POST',
            url: url,
            data: JSON.stringify(data),
            success: function (resData) {
                callback(resData);
            }
        });
    }
};

window.UtilKit = {
    deepCopy: function(obj) {
        return JSON.parse(JSON.stringify(obj));
    }
};

window.DateKit = {
    getDate: function(dayOffset) {
        var dd = new Date();
        dd.setDate(dd.getDate()+dayOffset);
        return dd;
    },
    formatDate: function(date, separater){
        var y = date.getFullYear();
        var m = date.getMonth() + 1;
        var d = date.getDate();
        return y+separater+m+separater+d;
    }
};

window.KitBox = {
    alert: function (message) {
        layer.alert(message);
    }
};

window.ChartKit = {
    rainbowBarColorList: [
        '#F3A43B','#C1232B','#B5C334','#FCCE10','#E87C25','#27727B', '#FE8463','#9BCA63','#FAD860','#60C0DD', '#D7504B','#C6E579','#F4E001','#F0805A','#26C0C0'
    ],
    rainbowBarOption: function(chartName, seriesName, xData, yData){
        return  {
            title: {
                x: 'center',
                text: chartName
            },
            tooltip : {
                trigger: 'axis'
            },
            calculable : true,
            grid: {
                borderWidth: 0,
                y: 80,
                y2: 60
            },
            xAxis : [
                {
                    type : 'category',
                    splitLine: {show: false},
                    data : xData
                }
            ],
            yAxis : [
                {
                    type : 'value',
                    splitLine: {show: false}
                }
            ],
            series : [
                {
                    name:seriesName,
                    type:'bar',
                    itemStyle: {
                        normal: {
                            color: function(params, index, value) {
                                return ChartKit.rainbowBarColorList[index];
                            },
                            label: {
                                show: true,
                                position: 'top',
                                formatter: '{b}\n{c}'
                            }
                        }
                    },
                    data:yData
                }
            ]
        };
    }
};