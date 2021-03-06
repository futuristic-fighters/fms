/**
 * Created by lijunjun on 2018-09-01.
 */
app.controller('collection_task_confirm_controller', ['$scope', '$http','$modal','toaster', '$location',function ($scope, $http,$modal,toaster,$location) {

    $scope.collectionTaskVo={};
    $scope.formValidate = false;
    $scope.submit = false;
    $scope.fileType = CommonCodeUtils.basFileTypes.collectionFile;
    $scope.treeFileId = "collection_task_confirm_file_tree";
    $scope.notUpload = false;
    $scope.collectionTaskNo = $location.search()['serviceId'];

    $http.get('collection_task/findCollectionTasksByTaskNo?collectionTaskNo='+ $scope.collectionTaskNo).success(function (data) {
        if (data.code == Response.successCode){
            $scope.collectionTaskVo = data.data;
            $scope.collectionTaskVo.remark = "";
            $scope.cstmContactList = $scope.collectionTaskVo.cstmAddrInfoVoList;
            $scope.collectionTaskVo.collectionLevelName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.collectionLevel, $scope.collectionTaskVo.collectionLevel);
            $scope.collectionTaskVo.dispatchTypeName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.dispatchType, $scope.collectionTaskVo.dispatchType);

            $scope.collectionTaskVo.repayDesireName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.repayDesireType, $scope.collectionTaskVo.repayDesire);
            $scope.collectionTaskVo.selfUseFlagName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.yesNoFlag, $scope.collectionTaskVo.selfUseFlag);
            $scope.collectionTaskVo.witnessFlagName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.yesNoFlag, $scope.collectionTaskVo.witnessFlag);
            if ($scope.collectionTaskVo.bizFilesList){
                $scope.bizFilesList = $scope.collectionTaskVo.bizFilesList;
            }
            initDetailTable();
        }else{
            modalAlert($modal,data.message);
        }
    });

    /*出租人地址信息*/
    function initDetailTable(){
        //参数配置
        $scope.dataTableProperties= {
            //table的html id
            dataTableId:'cstm_contact_table',
            dataTableColumn:[
                {title:'申请编号',data:'applyNo'},
                {title:'联系人姓名',data:'name'},
                {title:'联系人关系',data:'relationType',
                    render:function (data, type, row, meta) {
                        return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.relation, data);
                    }
                },
                {title:'联系人号码',data:'mobileNo'},
                {title:'地址类型',data:'addrType',
                    render:function (data, type, row, meta) {
                        return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.addressType, data);
                    }
                },
                {title:'联系人地址',data:'resideAddr'},
            ],
            dataTableData: $scope.cstmContactList
        }
        CommonDataTableUtils.createDataTableForData($scope.dataTableProperties);
    }

    $scope.getDispatchUserName = function () {
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/system/sys_user/sys_user_list_select.html'+getCacheTime(),
            controller: 'sys_user_list_select_controller',
            resolve:{
            }
        });
        rtn.result.then(function (data) {
            if(data){
                $scope.collectionTaskVo.dispatchUserName = data.userName;
                $scope.collectionTaskVo.dispatchUser = data.user;
            }
        },function(){
        });
    };

    /**
     * 上门催收结果确认提交
     */
    $scope.collectionConfirmAgree = function () {
        if(!$scope.form.$invalid) {
            $scope.submit = true;
            $scope.collectionTaskVo.taskId = $location.search()['taskId'];
            $http.post('collection_task/collectionAgree', $scope.collectionTaskVo).success(function (data) {
                if (data.code == Response.successCode)
                    $location.path('app/home');
                else
                    modalAlert($modal,data.message);
                $scope.submit = false;
            }).error(function(data){
                modalAlert($modal,data);
                $scope.submit = false;
            })

        }else{
            $scope.formValidate = true;
            toaster_info(promptInfo.submitWarn,toaster);
        }
    }

    /**
     * 上门催收结果确认退回
     */
    $scope.collectionConfirmBack = function () {
        $scope.submit = true;
        $scope.collectionTaskVo.taskId = $location.search()['taskId'];
        $http.post('collection_task/collectionBack', $scope.collectionTaskVo).success(function (data) {
            if (data.code == Response.successCode)
                $location.path('app/home');
            else
                modalAlert($modal,data.message);
            $scope.submit = false;
        }).error(function(data){
            modalAlert($modal,data);
            $scope.submit = false;
        })
    }

    //查看逾期详情
    $scope.overdueDetail = function () {
        //取得逾期客户id
        var overdueCstmId = $scope.collectionTaskVo.overdueCstmId;
        if(CommonStringUtils.isTrimBlank(overdueCstmId)){
            modalAlert($modal,'请选择逾期客户');
        } else {
            var id = overdueCstmId;
            var url = 'app.postbiz_overdue_cstm_modify?overdueCstmId=' + overdueCstmId
                + '&detail=true&isTab=true';
            var title = '逾期详情';
            var html = "<a data-id=\""+id+"\" data-url=\""+url+"\" data-title=\""+title+"\"></a>";
            if(window.parent.addTab){
                window.parent.addTab(html);
            }
        }
    };

    /**
     * 关闭窗口
     * @param status
     */
    $scope.close = function(){
        $location.path('app/home');
    };


    /**
     * 引用流程日志共通
     */
    $scope.wfLogType = CommonCodeUtils.bizTypes.collectionTask;
    if ($location.search()['serviceId']){
        $scope.wfLogNo = $location.search()['serviceId'];
    }
}]);


