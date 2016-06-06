/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved. 
 */

$(function () {
    org.breezee.page = {
        init: function () {
            this.orgTree('#orgTree');
            this.initEvent();
        },
        /**
         * 初始化事件
         */
        initEvent: function () {
            var me = this;
            $(".newOrg").click(function () {
                $('#org_win').modal('show');
            });
            /**
             * 保存按钮
             */
            $(".btn_submit").click(function () {
                var ef = $(".edit-form");
                if (Dolphin.form.validate(ef)) {
                    var data = Dolphin.form.getValue(ef, '"');
                    if (data.company)
                        data.company = data.company.join(',');
                    Dolphin.ajax({
                        url: '/api/ae55fd5637d040249574c12f97e11cc9',
                        type: Dolphin.requestMethod.PUT,
                        data: Dolphin.json2string(data),
                        onSuccess: function (reData) {
                            $('#org_win').modal('hide');
                        }
                    });

                }
            });
        },
        orgTree: function () {
            var tree = new Dolphin.TREE({
                panel: arguments[0],
                url: '/api/ed040a7849cc400fbf55ec6ec0abf43b@parentId={id}',
                mockPathData: ['id'],
                defaultId: '-1',
                multiple: false,
                onChecked: function (data) {

                },
                onLoad: function () {
                    if (tree.data.length > 0)
                        tree.expend(tree.data[0]);
                }
            });

            return tree;
        }

    };
    org.breezee.page.init();
});