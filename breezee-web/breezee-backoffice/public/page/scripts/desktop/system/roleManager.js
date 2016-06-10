/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved. 
 */

$(function () {
    org.breezee.page = {
        init: function () {
            this.initEvent();
            this._roleList = this.roleList('#roleList');
            $('.selectpicker').selectpicker('render');
        },
        /**
         * 初始化页面事件
         */
        initEvent: function () {
            var me = this;
            $(".newRole").click(function () {
                $('#role_win').modal('show');
            });
            /**
             * 保存按钮
             */
            $(".btn_submit").click(function () {
                var ef = $(".edit-form");
                if (Dolphin.form.validate(ef)) {
                    var data = Dolphin.form.getValue(ef, '"');
                    if (data.permits)
                        data.permits = data.permits.join(',');
                    Dolphin.ajax({
                        url: '/api/84c3d29503064850a856c830dfb10c23',
                        type: Dolphin.requestMethod.PUT,
                        data: Dolphin.json2string(data),
                        onSuccess: function (reData) {
                            me._roleList.reload();
                            $('#role_win').modal('hide');
                        }
                    });

                }
            });
            $('.content-refresh').click(function () {
                me._roleList.reload();
            });
        },
        roleList: function (panelId) {
            $(panelId).empty();
            return new Dolphin.LIST({
                panel: panelId,
                title: '角色列表',
                idField: 'id',
                columns: [{
                    code: 'name',
                    title: '角色名称',
                    width: '120px'
                }, {
                    code: 'code',
                    title: '角色编码',
                    width: '100px'
                }, {
                    code: 'permits',
                    title: '角色权限',
                    formatter: function (val) {
                        console.log(val.length);
                        return val.length > 100 ? val.substring(0, 100) + '...' : val;
                    }
                }, {
                    code: 'id',
                    title: '&nbsp;',
                    width: '180px',
                    formatter: function (val, row, index) {
                        return org.breezee.buttons.edit({
                                id: row.id
                            })
                            +
                            org.breezee.buttons.del({
                                id: row.id
                            });
                    }
                }],
                multiple: true,
                rowIndex: true,
                checkbox: true,
                ajaxType: Dolphin.requestMethod.POST,
                url: '/api/8a6d6925e3d14ba7b49903ad16083a2b',
                pagination: true,
                onLoadSuccess: function () {
                    org.breezee.buttons.editCallback('b2e406a3d1d241aca116107a65e366a1', 'id', function (data) {
                        if (data.value && data.value.permits)
                            $('.selectpicker').selectpicker('val', data.value.permits.split(','));
                        $('#role_win').modal('show');
                    });
                }
            });
        }
    };
    org.breezee.page.init();
});