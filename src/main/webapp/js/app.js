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
            })
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
                    + "/" + $scope.flight.date + "/" + $scope.flight.passangers
                    + "/" + $scope.flight.endPlace,
            method: 'GET',
        }).then(function (response, $scope) {
            $scope.flights = response;
        });
    };

    $scope.search3Param = function () {
        $http({
            url: 'http://airline-plaul.rhcloud.com/api/flightinfo/' + $scope.flight.startPlace
                    + "/" + $scope.flight.date + "/" + $scope.flight.passangers,
            method: 'GET',
        }).then(function (response, $scope) {
            $scope.flights = response;
        });
    };
});
//http://localhost:8084/Momondo_MetaSearch2/api/search/CPH/2017-01-23T00:00:00.000Z/1
//
