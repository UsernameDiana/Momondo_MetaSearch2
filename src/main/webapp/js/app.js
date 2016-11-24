var app = angular.module('MomondoMetaApp', []);

app.controller('SearchCtrl', function ($scope, $http) {
    $scope.flight = {};


    $scope.search3Param = function ($scope) {

        $http.get('http://airline-plaul.rhcloud.com/api/flightinfo/', {
            params: {
                origin: $scope.flight.startPlace,
                destination: $scope.flight.endPlace,
                date: $scope.flight.startDate
                
            }
        }).then(function (response, $scope){scope.flight = response;});
    };
    
    $scope.search2Param = function ($scope) {

        $http.get('http://airline-plaul.rhcloud.com/api/flightinfo/', {
            params: {
                origin: $scope.flight.startPlace,
                destination: $scope.flight.endPlace
            }
        }).then(function (response, $scope){scope.flight = response;});
    };
});