(function() {
  'use strict';

angular.module('myApp.registration')
.controller('registrationFormCtrl', ['$scope', 'User', 'Users', function($scope, User, Users) {

  $scope.model = {userName:'', passWord:''};
  $scope.validateUser = function() {
    if($scope.model.userName.length < 5) {
      $scope.err = 'The username length should be no less than 5 characters'; return;
    }
    if( /[^a-zA-Z0-9]/.test($scope.model.userName)) {
      $scope.err = 'The username field accepts alpha-numeric values only'; return;
    }
    
    User.get({
          userName: $scope.model.userName
        }, function(user) {
        	if(user !== null && user.id !== undefined) {
	            $scope.err = 'This username already registered';
	            return;
        	}
        	else {
                // all good!
                $scope.err = null;
                return;
            }
        }, function(response) {
              $scope.err = 'Server Error! Error code='+response.status;
              return;
            }
    );
  };

  $scope.validatePswd = function() {
    if($scope.model.passWord.length < 8) {
      $scope.pswdErr = 'The password should have a minimum length of 8 characters'; return;
    }
    if(! /[0-9]/.test($scope.model.passWord)) {
      $scope.pswdErr = 'The password should contains at least 1 number'; return;
    }
    if(! /[a-z]/.test($scope.model.passWord)) {
      $scope.pswdErr = 'The password should contains at least 1 lowercase character'; return;
    }
    if(! /[A-Z]/.test($scope.model.passWord)) {
      $scope.pswdErr = 'The password should contains at least 1 uppercase character'; return;
    }
    $scope.pswdErr = null;
  };

  $scope.submit = function() {
    Users.save( $scope.model, 
      function(){
        alert("Your registration has completed successfully!");
      },
      function(response) {
        $scope.err = 'Server Error when saving your registration! Error code='+response.status;
        return;
      });
  };

}]);
})();
