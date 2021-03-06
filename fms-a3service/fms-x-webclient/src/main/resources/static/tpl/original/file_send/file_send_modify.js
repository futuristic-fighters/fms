/**
 * Created by ningyangyang on 2018-05-04.
 */
app.controller('file_send_modify_controller', ['$scope', '$http','$modal', '$modalInstance','toaster','filePostId', function ($scope, $http,$modal, $modalInstance,toaster,filePostId) {

    $scope.fileSend={};

    $scope.formValidate = false;

    $scope.submit = false;

    $http.get('file_send/findFileSendByFilePostId?filePostId='+ filePostId).success(function(data){
        $scope.fileSend = data.data;
    });

    /**
     * 保存组织机构属性信息
     */
    $scope.modify = function () {

        if(!$scope.form.$invalid) {

            $scope.submit = true;

            $http.put('file_send/modifyFileSend', $scope.fileSend).success(function (data) {
                if (data.code == Response.successCode)
                    $scope.close(Response.successMark);
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
     * 关闭窗口
     * @param status
     */
    $scope.close = function(status){
        $modalInstance.close(status);
    };

}]);


