'use strict';

var App = angular.module('myApp',[]);

App.config(['$httpProvider', function($httpProvider) {
	$httpProvider.defaults.cache = true;
	$httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
}]);





