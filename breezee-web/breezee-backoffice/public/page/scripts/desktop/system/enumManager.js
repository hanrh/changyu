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
            this._enumList = this.enumList('#enumList');
            this._enumItemList = this.enumItemList('#enumItemList', false);
            this._enumWinList = this.enumItemList('#enum_option_list', true);
            this.initEvent();
        },
        /**
         * 初始化页面事件
         */
        initEvent: function () {
            var me = this;
            $(".newEnum").click(function () {
                $('#enum_win').modal('show');
            });

            $(".enum_submit").click(function () {
                var ef = $(".edit-form");
                if (Dolphin.form.validate(ef)) {
                    var data = Dolphin.form.getValue(ef, '"');
                    Dolphin.ajax({
                        url: '/api/5a543d0c5b214d2c855124d15e1fca75',
                        type: Dolphin.requestMethod.PUT,
                        data: Dolphin.json2string(data),
                        onSuccess: function (reData) {
                            me._enumList.reload();
                            $('#enum_win').modal('hide');
                        }
                    });

                }
            });
        },
        /**
         * 枚举信息列表，不分页
         * @param panelId
         * @returns {*|LIST}
         */
        enumList: function (panelId) {
            var me = this;
            $(panelId).empty();
            return new Dolphin.LIST({
                panel: panelId,
                idField: 'id',
                columns: [{
                    code: 'name',
                    title: '枚举名称',
                    textAlign: 'left'
                }, {
                    code: 'code',
                    title: '枚举编码'
                }, {
                    code: 'status',
                    title: '是否启用'
                }, {
                    code: '',
                    title: '&nbsp;',
                    width: '180px',
                    formatter: function (val, row, index) {
                        return org.breezee.buttons.edit({
                                id: row.id
                            }) + org.breezee.buttons.del({
                                id: row.id
                            });
                    }
                }],
                multiple: false,
                ajaxType: Dolphin.requestMethod.POST,
                url: '/api/aac22aa5817645bf9d351bcd15116841',
                pagination: false,
                onClick: function (data, thisRow, event) {
                    me._enumItemList.loadData({rows: data.items});
                },
                onLoadSuccess: function () {
                    org.breezee.buttons.editCallback('5b90151b418f4ceb9469a6b265b0d617', 'id', function (data) {
                        me._enumWinList.loadData({rows: data.value.items});
                        $('#enum_win').modal('show');
                    });
                    org.breezee.buttons.delCallback('5b90151b418f4ceb9469a6b265b0d617', function () {
                        me._enumList.reload();
                    });
                }
            });
        },
        /**
         * 枚举项列表
         * @param panelId
         * @param edit
         * @returns {*|LIST}
         */
        enumItemList: function (panelId, edit) {
            $(panelId).empty();
            return new Dolphin.LIST({
                panel: panelId,
                idField: 'pkId',
                columns: [{
                    code: 'id',
                    hidden: true,
                    title: '数据主键'
                }, {
                    code: 'name',
                    title: '项名称'
                }, {
                    code: 'code',
                    title: '项编码'
                }, {
                    code: 'rowNum',
                    title: '排序'
                }],
                multiple: false,
                rowIndex: false,
                checkbox: false,
                editFlag: edit,
                data: {rows: []},
                pagination: false,
                editListName: 'items',
                onClick: function (data, thisRow, event) {

                },
                onRemoveRow: function (data, event, thisRow) {
                    if (thisRow.find('[listName="id"]').val()) {
                        thisRow.remove();
                    }
                }
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
