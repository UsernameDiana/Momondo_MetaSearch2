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
})

app.controller('AboutController', function ($scope) {
    $scope.about = "About view";
})

app.controller('SearchCtrl', function ($scope, $http) {
    $scope.flight = {};

    $scope.search3Param = function ($scope) {

        $http.get('http://airline-plaul.rhcloud.com/api/flightinfo/', {
            params: {
                origin: $scope.flights.startPlace,
                destination: $scope.flights.endPlace,
                date: $scope.flights.startDate,
                tickets: $scope.flights.passangers

            }
        }).then(function (response, $scope) {
            scope.flight = response;
        });
    };

    $scope.search2Param = function ($scope) {

        $http.get('http://airline-plaul.rhcloud.com/api/flightinfo/', {
            params: {
                origin: $scope.flights.startPlace,
                destination: $scope.flights.endPlace,
                tickets: $scope.flights.passangers
            }
        }).then(function (response, $scope) {
            scope.flight = response;
        });
    };
});
