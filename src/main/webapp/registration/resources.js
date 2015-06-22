(function() {
  'use strict';
  angular.module('myApp.registration')
    .factory('User', ['$resource', function($resource) {
       return $resource('user/:userName');
    }])
	.factory('Users', ['$resource', function($resource) {
      // return $resource('user/:userName');
    	return $resource('user/add',{},{save: {method:'POST'}});
    }]);
})();
