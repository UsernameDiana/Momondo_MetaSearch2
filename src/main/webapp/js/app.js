var app = angular.module('MomondoMetaApp', ['ngRoute']);

app.config(function ($routeProvider) {
    $routeProvider
            .when("/home", {
                templateUrl: "views/home.html",
                controller: "SearchCtrl"
            })
            .when("/documentation", {
                templateUrl: "views/documentation.html",
                controller: "DocController"
            })
            .when("/about", {
                templateUrl: "views/about.html",
                controller: "AboutController"
            })
            .when("/info/:index", {
                templateUrl: "views/bookdetail.html",
                controller: "ProductController"
            })
            .otherwise({
                redirectTo: "/index"
            });
});

app.controller('DocController', function ($scope) {
    $scope.documentation = "Documentation view";
});

app.controller('AboutController', function ($scope) {
    $scope.about = "About view";
});

app.controller('SearchCtrl', function ($scope, $http) {
    $scope.flight = {};



    $scope.search4Param = function () {
        $http({
            url: 'http://airline-plaul.rhcloud.com/api/flightinfo/' + $scope.flight.startPlace
                    + "/" + $scope.date + "/" + $scope.flight.passangers
                    + "/" + $scope.flight.endPlace,
            method: 'GET'
        }).then(function (response, $scope) {
            $scope.flights = response;
        });
    };

    $scope.search3Param = function () {
        
        var date;        
        date = new Date($scope.myDate);
        var dateTemp = date.getTime() - (date.getTimezoneOffset() * 60000);
        var adjustedDate = new Date(dateTemp).toISOString();
        
        JSON.stringify($scope.date);
        $http({
            method: 'GET',
            url: 'http://airline-plaul.rhcloud.com/api/flightinfo/' + $scope.flight.startPlace
                    + "/" + adjustedDate + "/" + $scope.flight.passangers,
            headers: {
                'Content-Type' : 'application/json'
            }
            
        }).then(function (response, $scope) {
            $scope.status = response;
            $scope.flights = JSON.stringify(response.data, null, 2);
        }, function error(response) {
            $scope.status = response.status;
            $scope.flights = JSON.stringify(response.data, null, 2);
        });
    };
});
//http://localhost:8084/Momondo_MetaSearch2/api/search/CPH/2017-01-23T00:00:00.000Z/1
//
