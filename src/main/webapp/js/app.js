var app = angular.module('MomondoMetaApp', []);

app.controller('SearchCtrl', function($scope){
    
    $scope.startDate= {};
    $scope.endDate = {};
    
});

// from Lars dummy app.js
// 
//'use strict';
//
//// Declare app level module which depends on views, and components
//angular.module('myApp', [
//  'ngRoute',
//  'ngAnimate',
//  'ui.bootstrap',
//  'ui.grid', 'ui.grid.edit',
//  'myApp.home',
//  'myApp.links',
//  'myApp.about',
//  'myApp.api',
//  'myApp.airlineUrls',
//  'myApp.project',
//  'myApp.about',
//  'myApp.security'
//]).
//        config(['$routeProvider', function ($routeProvider) {
//            $routeProvider.otherwise({redirectTo: '/home'});
//          }]).
//        config(function ($httpProvider) {
//          $httpProvider.interceptors.push('authInterceptor');
//        }).
//        controller("mainCtrl", ["$scope", function ($scope) {
//            $scope.isHome = true;
//            $scope.setHome = function (val) {
//              $scope.isHome = val;
//            };
//          }]);