(function() {
  'use strict';
  angular.module('myApp.registration')
    .factory('User', ['$resource', function($resource) {
       return $resource('api/user/:userName');
    }])
})();
