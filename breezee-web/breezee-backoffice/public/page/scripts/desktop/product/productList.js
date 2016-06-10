/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved. 
 */

$(function () {

    org.breezee.page = {
        /**
         * 初始化页面
         */
        init: function () {
            this.destroy();
            this._productList = this.productList('#prtList');
            this._priceList = this.priceList('#priceList');
            this._limitList = this.limitList('#limitList');
            this.initEvent();
        },
        /**
         * 初始化页面事件
         */
        initEvent: function () {
            var me = this;
            $('.content-refresh').click(function () {
                me._productList.reload();
            });
        },
        /**
         * 产品信息列表分页
         * @param panelId
         * @returns {*|LIST}
         */
        productList: function (panelId) {
            var me = this;
            $(panelId).empty();
            return new Dolphin.LIST({
                panel: panelId,
                idField: 'id',
                columns: [{
                    code: 'code',
                    title: '物料编码',
                    width: '100px'
                }, {
                    code: 'shortText',
                    title: '物料描述',
                    textAlign: 'left',
                    width: '300px',
                    formatter: function (val) {
                        return '<div style="max-width: 300px;overflow: hidden;text-overflow:ellipsis;white-space:nowrap;">' + val + '</div>'
                    }
                }, {
                    code: 'brand',
                    title: '品牌'
                }, {
                    code: 'factory',
                    title: '工厂'
                }, {
                    code: 'divisor',
                    textAlign: 'right',
                    title: '箱托'
                }, {
                    code: 'grade',
                    title: '档次'
                }, {
                    code: 'wrapped',
                    title: '包装'
                }, {
                    code: 'volume',
                    title: '容量'
                }, {
                    code: 'group',
                    title: '物料组'
                }, {
                    code: 'measureUnit',
                    title: '计量'
                }, {
                    code: 'saleUnit',
                    textAlign: 'right',
                    title: '销售'
                }, {
                    code: 'grossWeight',
                    textAlign: 'right',
                    title: '毛重'
                }, {
                    code: 'netWeight',
                    textAlign: 'right',
                    title: '净重'
                }, {
                    code: 'bulk',
                    textAlign: 'right',
                    title: '体积'
                }, {
                    code: 'stock',
                    textAlign: 'right',
                    title: '库存',
                    formatter: function (val) {
                        return "0";
                    }
                }, {
                    code: '',
                    title: '&nbsp;',
                    width: '90px',
                    formatter: function (val, row, index) {
                        return org.breezee.buttons.view({
                            id: row.id
                        });
                    }
                }],
                multiple: false,
                ajaxType: Dolphin.requestMethod.POST,
                url: '/api/cfc2371f4b614e428928e7027f96ccca',
                pagination: true,
                onClick: function (data, thisRow, event) {
                },
                onLoadSuccess: function () {
                    org.breezee.buttons.viewCallback('8f6fbf4a5aed48a3adc18eba8e588715', 'id', function (data) {
                        me._priceList.loadData({rows: data.value.priceInfoList});
                        me._limitList.load('/api/ccb070cd523d441c86b37cf37a66e010?product_obj=' + data.value.id);
                        $('#product_win').modal('show');
                    });
                }
            });
        },
        /**
         * 价格列表
         * @param panelId
         * @returns {*|LIST}
         */
        priceList: function (panelId) {
            var me = this;
            $(panelId).empty();
            return new Dolphin.LIST({
                panel: panelId,
                idField: 'id',
                columns: [{
                    code: 'productId',
                    title: '物料编码'
                }, {
                    code: 'province',
                    title: '省份'
                }, {
                    code: 'channel',
                    title: '渠道'
                }, {
                    code: 'baseValue',
                    textAlign: 'right',
                    title: '基本价格'
                }, {
                    code: 'addInValue',
                    textAlign: 'right',
                    title: '附加价格'
                }, {
                    code: 'unit',
                    textAlign: 'right',
                    title: '单位'
                }, {
                    code: 'startTime',
                    title: '开始时间'
                }, {
                    code: 'endTime',
                    title: '结束时间'
                }, {
                    code: 'customerId',
                    title: '客户标识'
                }],
                multiple: false,
                pagination: false,
                data: {rows: []}
            });
        },
        /**
         * 限售列表
         * @param panelId
         * @returns {*|LIST}
         */
        limitList: function (panelId) {
            var me = this;
            $(panelId).empty();
            return new Dolphin.LIST({
                panel: panelId,
                idField: 'id',
                columns: [{
                    code: 'productId',
                    title: '物料编码'
                }, {
                    code: 'province',
                    title: '省份'
                }, {
                    code: 'channel',
                    title: '渠道'
                }, {
                    code: 'source',
                    title: '来源'
                }, {
                    code: 'startTime',
                    title: '开始时间'
                }, {
                    code: 'endTime',
                    title: '结束时间'
                }],
                multiple: false,
                data: {rows: []},
                pagination: false,
                ajaxType: Dolphin.requestMethod.POST
            });
        },
        /**
         * 一些页面DOM对象和事件的销毁
         */
        destroy: function () {
        }
    };
    org.breezee.page.init();
});