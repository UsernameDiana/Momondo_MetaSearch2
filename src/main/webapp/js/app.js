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

    $scope.search3Param = function () {

        $http.get('http://airline-plaul.rhcloud.com/api/flightinfo/', {
            params: {
                origin: $scope.flight.startPlace,
                destination: $scope.flight.endPlace,
                date: $scope.flight.startDate,
                tickets: $scope.flight.passangers

            }
        }).then(function (response, $scope) {
            $scope.flights = response;
        });
    };

    $scope.search2Param = function () {

        $http.get('http://airline-plaul.rhcloud.com/api/flightinfo/', {
            params: {
                origin: $scope.flight.startPlace,
                destination: $scope.flight.endPlace,
                tickets: $scope.flight.passangers
            }
        }).then(function (response, $scope) {
            $scope.flights = response;
        });
    };
});
